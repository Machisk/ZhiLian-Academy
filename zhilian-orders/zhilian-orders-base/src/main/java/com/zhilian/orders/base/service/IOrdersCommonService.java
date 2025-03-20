package com.zhilian.orders.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.orders.base.model.domain.Orders;
import com.zhilian.orders.base.model.dto.OrderUpdateStatusDTO;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 */
public interface IOrdersCommonService extends IService<Orders> {

    Integer updateStatus(OrderUpdateStatusDTO orderUpdateStatusReqDTO);
}
