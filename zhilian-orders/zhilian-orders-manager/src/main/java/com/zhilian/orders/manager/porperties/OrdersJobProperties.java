package com.zhilian.orders.manager.porperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "zhilian.job")
public class OrdersJobProperties {

    /**
     * 自动评价订单数量，默认100
     */
    private Integer autoEvaluateCount = 100;

    /**
     * 退款订单数量，默认100
     */
    private Integer refundOrderCount = 100;

    /**
     * 超时支付订单数量，默认100
     */
    private Integer overTimePayOrderCount = 100;

    /**
     * 派单超时订单数量，默认100
     */
    private Integer dispatchOverTimeOrderCount = 100;
}