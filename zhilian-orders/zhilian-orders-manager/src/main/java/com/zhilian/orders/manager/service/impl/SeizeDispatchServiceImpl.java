package com.zhilian.orders.manager.service.impl;

import com.zhilian.orders.base.mapper.OrdersDispatchMapper;
import com.zhilian.orders.base.mapper.OrdersSeizeMapper;
import com.zhilian.orders.base.utils.RedisUtils;
import com.zhilian.orders.manager.service.ISeizeDispatchService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.zhilian.orders.base.constants.RedisConstants.RedisKey.ORDERS_RESOURCE_STOCK;

@Service
public class SeizeDispatchServiceImpl implements ISeizeDispatchService {


    @Resource
    private RedisTemplate redisTemplate;


    @Resource
    private OrdersSeizeMapper ordersSeizeMapper;
    @Resource
    private OrdersDispatchMapper ordersDispatchMapper;


    @Override
    public void clearSeizeDispatchPool(String cityCode, Long id) {
        String resourceStockRedisKey = String.format(ORDERS_RESOURCE_STOCK, RedisUtils.getCityIndex(cityCode));
        ordersDispatchMapper.deleteById(id);
        ordersSeizeMapper.deleteById(id);
        redisTemplate.opsForHash().delete(resourceStockRedisKey, id);
    }

}
