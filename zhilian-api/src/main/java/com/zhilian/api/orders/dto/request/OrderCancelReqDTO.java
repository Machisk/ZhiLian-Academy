package com.zhilian.api.orders.dto.request;

import lombok.Data;

/**
 * 订单取消请求
 *
 **/
@Data
public class OrderCancelReqDTO {
    /**
     * 订单id
     */
    private Long id;

    /**
     * 取消/退款原因
     */
    private String cancelReason;
}
