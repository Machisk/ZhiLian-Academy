package com.zhilian.orders.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.orders.base.mapper.OrdersCanceledMapper;
import com.zhilian.orders.base.model.domain.OrdersCanceled;
import com.zhilian.orders.manager.service.IOrdersCanceledService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  订单取消服务实现类
 * </p>
 *
 */
@Service
public class OrdersCanceledServiceImpl extends ServiceImpl<OrdersCanceledMapper, OrdersCanceled> implements IOrdersCanceledService {

}
