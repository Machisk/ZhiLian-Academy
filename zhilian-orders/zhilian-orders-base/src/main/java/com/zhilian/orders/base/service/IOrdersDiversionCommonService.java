package com.zhilian.orders.base.service;

import com.zhilian.orders.base.model.domain.Orders;

/**
 * 订单分流
 */
public interface IOrdersDiversionCommonService {

    /**
     * 订单分流,所有订单均可抢单
     *
     * @param orders
     */
    void diversion(Orders orders);

}
