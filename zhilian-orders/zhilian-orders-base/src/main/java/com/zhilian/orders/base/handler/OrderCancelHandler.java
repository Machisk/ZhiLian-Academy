package com.zhilian.orders.base.handler;

import cn.hutool.db.DbRuntimeException;
import com.zhilian.orders.base.enums.OrderStatusChangeEventEnum;
import com.zhilian.orders.base.enums.OrderStatusEnum;
import com.zhilian.orders.base.enums.OrderPayStatusEnum;
import com.zhilian.orders.base.model.dto.OrderSnapshotDTO;
import com.zhilian.orders.base.model.dto.OrderUpdateStatusDTO;
import com.zhilian.orders.base.service.IOrdersCommonService;
import com.zhilian.statemachine.core.StatusChangeEvent;
import com.zhilian.statemachine.core.StatusChangeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 未支付时订单取消处理器
 *
 **/
@Slf4j
@Component("order_cancel")
public class OrderCancelHandler implements StatusChangeHandler<OrderSnapshotDTO> {
    @Resource
    private IOrdersCommonService ordersService;

    /**
     * 订单评价处理逻辑
     *
     * @param bizId   业务id
     * @param bizSnapshot 快照
     */
    @Override
    public void handler(String bizId, StatusChangeEvent statusChangeEventEnum, OrderSnapshotDTO bizSnapshot) {
        log.info("订单取消事件处理逻辑开始，订单号：{}", bizId);
        // 修改订单状态
        OrderUpdateStatusDTO orderUpdateStatusDTO = OrderUpdateStatusDTO.builder()
                .id(Long.valueOf(bizId))
                .originStatus(OrderStatusEnum.NO_PAY.getStatus())
                .targetStatus(OrderStatusEnum.CANCELED.getStatus())
                .build();
        int result = ordersService.updateStatus(orderUpdateStatusDTO);
        if (result <= 0) {
            throw new DbRuntimeException("订单取消事件处理失败");
        }
    }
}
