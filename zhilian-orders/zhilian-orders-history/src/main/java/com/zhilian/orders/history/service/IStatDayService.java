package com.zhilian.orders.history.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.orders.history.model.domain.StatDay;
import com.zhilian.orders.history.model.domain.StatHour;

import java.util.List;

/**
 * <p>
 * 日统计表 服务类
 * </p>
 *
 */
public interface IStatDayService extends IService<StatDay> {
    /**
     * 根据id范围聚合统计
     *
     * @param minId 最小id
     * @param maxId 最大id
     * @return 聚合统计数据
     */
    StatDay aggregationByIdRange(Long minId, Long maxId);

    /**
     * 根据id范围查询统计数据
     *
     * @param minId 最小id
     * @param maxId 最大id
     * @return 统计数据
     */
    List<StatDay> queryListByIdRange(Long minId, Long maxId);

    /**
     * 按日统计15天内的每日数据，并保存到数据库
     */
    void statAndSaveData();

}
