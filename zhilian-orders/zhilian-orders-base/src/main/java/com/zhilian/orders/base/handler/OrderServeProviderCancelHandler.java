package com.zhilian.orders.base.handler;

import cn.hutool.db.DbRuntimeException;
import com.zhilian.orders.base.enums.OrderStatusEnum;
import com.zhilian.orders.base.model.dto.OrderSnapshotDTO;
import com.zhilian.orders.base.model.dto.OrderUpdateStatusDTO;
import com.zhilian.orders.base.service.IOrdersCommonService;
import com.zhilian.statemachine.core.StatusChangeEvent;
import com.zhilian.statemachine.core.StatusChangeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 服务人员/机构取消订单处理器
 *
 **/
@Slf4j
@Component("order_serve_provider_cancel")
public class OrderServeProviderCancelHandler implements StatusChangeHandler<OrderSnapshotDTO> {
    @Resource
    private IOrdersCommonService ordersService;

    /**
     * 服务人员/机构取消订单处理逻辑
     *
     * @param bizId   业务id
     * @param bizSnapshot 快照
     */
    @Override
    public void handler(String bizId, StatusChangeEvent statusChangeEventEnum, OrderSnapshotDTO bizSnapshot) {
        log.info("服务人员/机构取消订单事件处理逻辑开始，订单号：{}", bizId);
        // 修改订单状态
        OrderUpdateStatusDTO orderUpdateStatusDTO = OrderUpdateStatusDTO.builder().id(Long.valueOf(bizId))
                .originStatus(OrderStatusEnum.NO_SERVE.getStatus())
                .targetStatus(OrderStatusEnum.DISPATCHING.getStatus())
                .build();
        int result = ordersService.updateStatus(orderUpdateStatusDTO);
        if (result <= 0) {
            throw new DbRuntimeException("服务人员/机构取消订单事件处理失败");
        }
    }
}
