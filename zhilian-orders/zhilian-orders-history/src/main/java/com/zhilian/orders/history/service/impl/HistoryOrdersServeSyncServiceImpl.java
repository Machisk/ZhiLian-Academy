package com.zhilian.orders.history.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.zhilian.orders.history.model.domain.HistoryOrdersServeSync;
import com.zhilian.orders.history.mapper.HistoryOrdersServeSyncMapper;
import com.zhilian.orders.history.service.IHistoryOrdersServeSyncService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务单 服务实现类
 * </p>
 *
 */
@Service
public class HistoryOrdersServeSyncServiceImpl extends ServiceImpl<HistoryOrdersServeSyncMapper, HistoryOrdersServeSync> implements IHistoryOrdersServeSyncService {

    @Override
    public Integer countBySortTime(LocalDateTime minSortTime, LocalDateTime maxSortTime) {
        return lambdaQuery().between(HistoryOrdersServeSync::getSortTime, minSortTime, maxSortTime)
                .count();
    }

    @Override
    public void deleteBySortTime(LocalDateTime minSortTime, LocalDateTime maxSortTime) {
        lambdaUpdate().between(HistoryOrdersServeSync::getSortTime, minSortTime, maxSortTime)
                .remove();
    }
}
