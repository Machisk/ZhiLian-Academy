package com.zhilian.orders.base.handler;

import cn.hutool.db.DbRuntimeException;
import com.zhilian.orders.base.enums.OrderPayStatusEnum;
import com.zhilian.orders.base.enums.OrderStatusEnum;
import com.zhilian.orders.base.model.dto.OrderSnapshotDTO;
import com.zhilian.orders.base.model.dto.OrderUpdateStatusDTO;
import com.zhilian.orders.base.service.IOrdersCommonService;
import com.zhilian.statemachine.core.StateMachineSnapshot;
import com.zhilian.statemachine.core.StatusChangeEvent;
import com.zhilian.statemachine.core.StatusChangeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 订单支付成功处理器
 *
 **/
@Slf4j
@Component("order_payed")
public class OrderPayedHandler implements StatusChangeHandler<OrderSnapshotDTO> {
    @Resource
    private IOrdersCommonService ordersService;

    /**
     * 订单支付处理逻辑
     *
     * @param bizId   业务id
     * @param statusChangeEventEnum   状态变更事件
     * @param bizSnapshot 快照
     */
    @Override
    public void handler(String bizId, StatusChangeEvent statusChangeEventEnum, OrderSnapshotDTO bizSnapshot) {
        log.info("支付事件处理逻辑开始，订单号：{}", bizId);
        // 修改订单状态和支付状态
        OrderUpdateStatusDTO orderUpdateStatusDTO = OrderUpdateStatusDTO.builder().id(Long.valueOf(bizId))
                .originStatus(OrderStatusEnum.NO_PAY.getStatus())
                .targetStatus(OrderStatusEnum.DISPATCHING.getStatus())
                .payStatus(OrderPayStatusEnum.PAY_SUCCESS.getStatus())
                .payTime(LocalDateTime.now())
                .tradingOrderNo(bizSnapshot.getTradingOrderNo())
                .transactionId(bizSnapshot.getThirdOrderId())
                .tradingChannel(bizSnapshot.getTradingChannel())
                .build();
        int result = ordersService.updateStatus(orderUpdateStatusDTO);
        if (result <= 0) {
            throw new DbRuntimeException("支付事件处理失败");
        }
    }


}
