package com.zhilian.orders.manager.strategy.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zhilian.common.constants.UserType;
import com.zhilian.orders.base.config.OrderStateMachine;
import com.zhilian.orders.base.enums.OrderStatusChangeEventEnum;
import com.zhilian.orders.base.model.domain.OrdersCanceled;
import com.zhilian.orders.base.model.dto.OrderSnapshotDTO;
import com.zhilian.orders.manager.model.dto.OrderCancelDTO;
import com.zhilian.orders.manager.service.IOrdersCanceledService;
import com.zhilian.orders.manager.strategy.OrderCancelStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 系统对待支付状态超时订单取消
 *
 **/
@Component("0:NO_PAY")
public class SystemNoPayOrderCancelStrategy implements OrderCancelStrategy {
    @Resource
    private OrderStateMachine orderStateMachine;
    @Resource
    private IOrdersCanceledService ordersCanceledService;

    /**
     * 订单取消
     *
     * @param orderCancelDTO 订单取消模型
     */
    @Override
    public void cancel(OrderCancelDTO orderCancelDTO) {
        //构建订单快照更新模型
        OrderSnapshotDTO orderSnapshotDTO = OrderSnapshotDTO.builder()
                .cancelReason(orderCancelDTO.getCancelReason())
                .cancellerType(UserType.SYSTEM)
                .cancelTime(LocalDateTime.now())
                .build();

        //保存订单取消记录
        OrdersCanceled ordersCanceled = BeanUtil.toBean(orderSnapshotDTO, OrdersCanceled.class);
        ordersCanceled.setId(orderCancelDTO.getId());
        ordersCanceledService.save(ordersCanceled);

        //订单状态变更
        orderStateMachine.changeStatus(orderCancelDTO.getUserId(), orderCancelDTO.getId().toString(), OrderStatusChangeEventEnum.CANCEL, orderSnapshotDTO);
    }
}
