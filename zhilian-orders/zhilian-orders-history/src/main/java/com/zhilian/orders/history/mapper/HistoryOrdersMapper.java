package com.zhilian.orders.history.mapper;

import com.zhilian.orders.history.model.domain.HistoryOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 */
public interface HistoryOrdersMapper extends BaseMapper<HistoryOrders> {


}
