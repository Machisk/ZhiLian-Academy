package com.zhilian.orders.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.orders.base.mapper.OrdersRefundMapper;
import com.zhilian.orders.base.model.domain.OrdersRefund;
import com.zhilian.orders.manager.service.IOrdersRefundService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单退款表 服务实现类
 * </p>
 *
 */
@Service
public class OrdersRefundServiceImpl extends ServiceImpl<OrdersRefundMapper, OrdersRefund> implements IOrdersRefundService {

    /**
     * 查询指定数量的退款订单
     *
     * @param count 数量
     */
    @Override
    public List<OrdersRefund> queryRefundOrderListByCount(Integer count) {
        LambdaQueryWrapper<OrdersRefund> queryWrapper = Wrappers.<OrdersRefund>lambdaQuery()
                .orderByAsc(OrdersRefund::getCreateTime)
                .last("limit " + count);
        return baseMapper.selectList(queryWrapper);
    }
}
