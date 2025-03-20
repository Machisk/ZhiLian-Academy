package com.zhilian.orders.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.common.utils.DateUtils;
import com.zhilian.orders.base.enums.BreachHaviorTypeEnum;
import com.zhilian.orders.base.mapper.BreachRecordMapper;
import com.zhilian.orders.base.model.domain.BreachRecord;
import com.zhilian.orders.manager.service.IBreachRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 违约记录 服务实现类
 * </p>
 *
 */
@Service
public class BreachRecordServiceImpl extends ServiceImpl<BreachRecordMapper, BreachRecord> implements IBreachRecordService {



    @Override
    public void add(BreachRecord breachRecord) {
        breachRecord.setBreachDay(DateUtils.getDay());
        breachRecord.setBreachTime(DateUtils.now());
        baseMapper.insert(breachRecord);
    }


    @Override
    public int count(Long serveProviderId, BreachHaviorTypeEnum breachHaviorTypeEnum, int breachDay) {
        return lambdaQuery().eq(BreachRecord::getServeProviderId, serveProviderId)
                .eq(BreachRecord::getBehaviorType, breachHaviorTypeEnum.getType())
                .eq(BreachRecord::getBreachDay, breachDay)
                .count();
    }
}
