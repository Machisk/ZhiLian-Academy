package com.zhilian.orders.history.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.orders.history.model.domain.StatDay;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 日统计表 Mapper 接口
 * </p>
 *
 */
public interface StatDayMapper extends BaseMapper<StatDay> {

    /**
     * 根据id范围聚合统计
     *
     * @param minId 最小id
     * @param maxId 最大id
     * @return 聚合统计数据
     */
    StatDay aggregationByIdRange(@Param("minId") Long minId, @Param("maxId") Long maxId);
}
