package com.zhilian.orders.history.mapper;

import com.zhilian.orders.history.model.domain.HistoryOrdersSync;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.orders.history.model.domain.StatDay;
import com.zhilian.orders.history.model.domain.StatHour;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单统计
 * </p>
 *
 */
public interface HistoryOrdersSyncMapper extends BaseMapper<HistoryOrdersSync> {


    List<StatHour> statForHour(@Param("queryDay") Integer queryDay);

}
