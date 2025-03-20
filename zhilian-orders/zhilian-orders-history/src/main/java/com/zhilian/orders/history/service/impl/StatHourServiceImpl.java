package com.zhilian.orders.history.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhilian.common.utils.DateUtils;
import com.zhilian.orders.history.model.domain.StatDay;
import com.zhilian.orders.history.model.domain.StatHour;
import com.zhilian.orders.history.mapper.StatHourMapper;
import com.zhilian.orders.history.service.IHistoryOrdersSyncService;
import com.zhilian.orders.history.service.IStatHourService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.orders.history.mapper.StatHourMapper;
import com.zhilian.orders.history.model.domain.StatHour;
import com.zhilian.orders.history.service.IStatHourService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 小时统计表 服务实现类
 * </p>
 *
 */
@Service
public class StatHourServiceImpl extends ServiceImpl<StatHourMapper, StatHour> implements IStatHourService {
    @Resource
    private IHistoryOrdersSyncService historyOrdersSyncService;
    /**
     * 根据id范围查询统计数据
     *
     * @param minId 最小id
     * @param maxId 最大id
     * @return 统计数据
     */
    @Override
    public List<StatHour> queryListByIdRange(Long minId, Long maxId) {
        LambdaQueryWrapper<StatHour> queryWrapper = Wrappers.<StatHour>lambdaQuery()
                .between(StatHour::getId, minId, maxId)
                .orderByAsc(StatHour::getId);
        return baseMapper.selectList(queryWrapper);
    }


    @Override
    public void statAndSaveData() {
        // 1.数据统计
        // 15天前时间
        LocalDateTime statDayLocalDateTime = DateUtils.now().minusDays(15);
        long statDayTime = DateUtils.getFormatDate(statDayLocalDateTime, "yyyMMdd");
        // 统计数据
        List<StatHour> statForHour = historyOrdersSyncService.statForHour((int) statDayTime);
        // 2.数据保存
        saveOrUpdateBatch(statForHour,500);
    }
}
