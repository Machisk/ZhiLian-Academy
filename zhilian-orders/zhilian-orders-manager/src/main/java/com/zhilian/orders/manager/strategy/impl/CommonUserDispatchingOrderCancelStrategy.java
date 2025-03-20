package com.zhilian.orders.manager.strategy.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zhilian.api.trade.enums.RefundStatusEnum;
import com.zhilian.common.expcetions.ForbiddenOperationException;
import com.zhilian.orders.base.config.OrderStateMachine;
import com.zhilian.orders.base.enums.OrderStatusChangeEventEnum;
import com.zhilian.orders.base.enums.OrderStatusEnum;
import com.zhilian.orders.base.model.domain.OrdersCanceled;
import com.zhilian.orders.base.model.domain.OrdersRefund;
import com.zhilian.orders.base.model.dto.OrderSnapshotDTO;
import com.zhilian.orders.manager.handler.OrdersHandler;
import com.zhilian.orders.manager.model.dto.OrderCancelDTO;
import com.zhilian.orders.manager.service.IOrdersCanceledService;
import com.zhilian.orders.manager.service.IOrdersRefundService;
import com.zhilian.orders.manager.service.ISeizeDispatchService;
import com.zhilian.orders.manager.strategy.OrderCancelStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 普通用户派单状态取消订单
 *
 **/
@Component("1:DISPATCHING")
public class CommonUserDispatchingOrderCancelStrategy implements OrderCancelStrategy {
    @Resource
    private OrderStateMachine orderStateMachine;
    @Resource
    private IOrdersCanceledService ordersCanceledService;

    @Resource
    private ISeizeDispatchService seizeDispatchService;
    @Resource
    private IOrdersRefundService ordersRefundService;

    @Resource
    private OrdersHandler ordersHandler;

    /**
     * 订单取消
     *
     * @param orderCancelDTO 订单取消模型
     */
    @Override
    public void cancel(OrderCancelDTO orderCancelDTO) {
        //1.校验是否为本人操作
        if (ObjectUtil.notEqual(orderCancelDTO.getUserId(), orderCancelDTO.getCurrentUserId())) {
            throw new ForbiddenOperationException("非本人操作");
        }

        //2.构建订单快照更新模型
        OrderSnapshotDTO orderSnapshotDTO = OrderSnapshotDTO.builder()
                .refundStatus(RefundStatusEnum.SENDING.getCode())
                .cancellerId(orderCancelDTO.getCurrentUserId())
                .cancelerName(orderCancelDTO.getCurrentUserName())
                .cancellerType(orderCancelDTO.getCurrentUserType())
                .cancelReason(orderCancelDTO.getCancelReason())
                .cancelTime(LocalDateTime.now())
                .build();

        //3.保存订单取消记录
        OrdersCanceled ordersCanceled = BeanUtil.toBean(orderSnapshotDTO, OrdersCanceled.class);
        ordersCanceled.setId(orderCancelDTO.getId());
        ordersCanceledService.save(ordersCanceled);

        //4.订单状态变更
        orderStateMachine.changeStatus(orderCancelDTO.getUserId(), orderCancelDTO.getId().toString(), OrderStatusChangeEventEnum.CLOSE_DISPATCHING_ORDER, orderSnapshotDTO);


        //5.存入退款表，定时任务扫描进行退款
        OrdersRefund ordersRefund = new OrdersRefund();
        ordersRefund.setId(orderCancelDTO.getId());
        ordersRefund.setTradingOrderNo(orderCancelDTO.getTradingOrderNo());
        ordersRefund.setRealPayAmount(orderCancelDTO.getRealPayAmount());
        ordersRefundService.save(ordersRefund);
        //新启动一个线程请求退款
        ordersHandler.requestRefundNewThread(orderCancelDTO.getId());

        //6.清理抢派单池
        seizeDispatchService.clearSeizeDispatchPool(orderCancelDTO.getCityCode(), orderCancelDTO.getId());
    }
}
