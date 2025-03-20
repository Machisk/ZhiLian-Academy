package com.zhilian.orders.base.mapper;

import com.zhilian.orders.base.model.domain.Orders;
import com.zhilian.orders.base.model.dto.OrderUpdateStatusDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 */
public interface OrdersMapper extends BaseMapper<Orders> {


}
