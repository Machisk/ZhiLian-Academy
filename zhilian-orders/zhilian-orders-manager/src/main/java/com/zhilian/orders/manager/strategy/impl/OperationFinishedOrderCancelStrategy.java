package com.zhilian.orders.manager.strategy.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.zhilian.api.trade.enums.RefundStatusEnum;
import com.zhilian.common.expcetions.CommonException;
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
import java.time.temporal.ChronoUnit;

/**
 * 运营端取消已完成的订单
 *
 **/
@Component("4:FINISHED")
public class OperationFinishedOrderCancelStrategy implements OrderCancelStrategy {
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
        long between = LocalDateTimeUtil.between(orderCancelDTO.getRealServeEndTime(), LocalDateTime.now(), ChronoUnit.DAYS);
        if(between>=15){
            throw new CommonException("服务完成超时15日，不可退款");
        }
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
        orderStateMachine.changeStatus(orderCancelDTO.getUserId(), orderCancelDTO.getId().toString(), OrderStatusChangeEventEnum.CLOSE_FINISHED_ORDER, orderSnapshotDTO);

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
