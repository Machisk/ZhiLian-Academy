package com.zhilian.orders.manager.strategy.impl;

import cn.hutool.core.bean.BeanUtil;
import com.zhilian.api.trade.enums.RefundStatusEnum;
import com.zhilian.orders.base.config.OrderStateMachine;
import com.zhilian.orders.base.enums.OrderStatusChangeEventEnum;
import com.zhilian.orders.base.enums.OrderStatusEnum;
import com.zhilian.orders.base.model.domain.OrdersCanceled;
import com.zhilian.orders.base.model.domain.OrdersRefund;
import com.zhilian.orders.base.model.dto.OrderSnapshotDTO;
import com.zhilian.orders.manager.model.dto.OrderCancelDTO;
import com.zhilian.orders.manager.service.IOrdersCanceledService;
import com.zhilian.orders.manager.service.IOrdersRefundService;
import com.zhilian.orders.manager.service.IOrdersServeManagerService;
import com.zhilian.orders.manager.strategy.OrderCancelStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 运营端服务中状态取消订单
 *
 **/
@Component("4:SERVING")
public class OperationServingOrderCancelStrategy implements OrderCancelStrategy {
    @Resource
    private OrderStateMachine orderStateMachine;
    @Resource
    private IOrdersServeManagerService ordersServeManagerService;
    @Resource
    private IOrdersCanceledService ordersCanceledService;
    @Resource
    private IOrdersRefundService ordersRefundService;

    /**
     * 订单取消
     *
     * @param orderCancelDTO 订单取消模型
     */
    @Override
    public void cancel(OrderCancelDTO orderCancelDTO) {
        //1.状态机更新订单状态
        OrderSnapshotDTO orderSnapshotDTO = OrderSnapshotDTO.builder()
                .refundStatus(RefundStatusEnum.SENDING.getCode())
                .cancellerId(orderCancelDTO.getCurrentUserId())
                .cancelerName(orderCancelDTO.getCurrentUserName())
                .cancellerType(orderCancelDTO.getCurrentUserType())
                .cancelReason(orderCancelDTO.getCancelReason())
                .cancelTime(LocalDateTime.now())
                .build();

        //2.保存订单取消记录
        OrdersCanceled ordersCanceled = BeanUtil.toBean(orderSnapshotDTO, OrdersCanceled.class);
        ordersCanceled.setId(orderCancelDTO.getId());
        ordersCanceledService.save(ordersCanceled);

        //3.订单状态变更
        orderStateMachine.changeStatus(orderCancelDTO.getUserId(), orderCancelDTO.getId().toString(), OrderStatusChangeEventEnum.CLOSE_SERVING_ORDER, orderSnapshotDTO);

        //4.取消服务单
        ordersServeManagerService.cancelByUserAndOperation(orderCancelDTO.getId());

        //5.存入退款表，定时任务扫描进行退款
        OrdersRefund ordersRefund = new OrdersRefund();
        ordersRefund.setId(orderCancelDTO.getId());
        ordersRefund.setTradingOrderNo(orderCancelDTO.getTradingOrderNo());
        ordersRefund.setRealPayAmount(orderCancelDTO.getRealPayAmount());
        ordersRefundService.save(ordersRefund);
    }
}
