package com.zhilian.orders.base.mapper;

import com.zhilian.orders.base.model.domain.HistoryOrdersServeSync;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务任务 Mapper 接口
 * </p>
 *
 */
public interface HistoryOrdersServeSyncMapper extends BaseMapper<HistoryOrdersServeSync> {

    @Select("select max(sort_time) from history_orders_sync")
    LocalDateTime queryMaxSortTime();
}
