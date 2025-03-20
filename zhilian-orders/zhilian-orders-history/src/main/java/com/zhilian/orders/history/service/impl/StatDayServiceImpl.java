package com.zhilian.orders.history.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhilian.common.utils.DateUtils;
import com.zhilian.orders.history.model.domain.StatDay;
import com.zhilian.orders.history.mapper.StatDayMapper;
import com.zhilian.orders.history.service.IHistoryOrdersService;
import com.zhilian.orders.history.service.IHistoryOrdersSyncService;
import com.zhilian.orders.history.service.IStatDayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.orders.history.mapper.StatDayMapper;
import com.zhilian.orders.history.model.domain.StatDay;
import com.zhilian.orders.history.model.domain.StatHour;
import com.zhilian.orders.history.service.IStatDayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 日统计表 服务实现类
 * </p>
 *
 */
@Service
public class StatDayServiceImpl extends ServiceImpl<StatDayMapper, StatDay> implements IStatDayService {

    @Resource
    private IHistoryOrdersSyncService historyOrdersSyncService;


    /**
     * 根据id范围聚合统计
     *
     * @param minId 最小id
     * @param maxId 最大id
     * @return 聚合统计数据
     */
    @Override
    public StatDay aggregationByIdRange(Long minId, Long maxId) {
        return baseMapper.aggregationByIdRange(minId, maxId);
    }

    /**
     * 根据id范围查询统计数据
     *
     * @param minId 最小id
     * @param maxId 最大id
     * @return 统计数据
     */
    @Override
    public List<StatDay> queryListByIdRange(Long minId, Long maxId) {
        LambdaQueryWrapper<StatDay> queryWrapper = Wrappers.<StatDay>lambdaQuery()
                .between(StatDay::getId, minId, maxId)
                .orderByAsc(StatDay::getId);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public void statAndSaveData() {

    }
}
