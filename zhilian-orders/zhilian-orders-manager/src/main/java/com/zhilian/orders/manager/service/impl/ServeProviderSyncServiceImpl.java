package com.zhilian.orders.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.common.constants.UserType;
import com.zhilian.common.utils.CollUtils;
import com.zhilian.common.utils.NumberUtils;
import com.zhilian.common.utils.ObjectUtils;
import com.zhilian.orders.base.mapper.ServeProviderSyncMapper;
import com.zhilian.orders.base.model.domain.ServeProviderSync;
import com.zhilian.orders.manager.service.IOrdersServeManagerService;
import com.zhilian.orders.manager.service.IServeProviderSyncService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 机构服务端更新服务时间 服务实现类
 * </p>
 *
 */
@Service
public class ServeProviderSyncServiceImpl extends ServiceImpl<ServeProviderSyncMapper, ServeProviderSync> implements IServeProviderSyncService {

    @Resource
    private IOrdersServeManagerService ordersServeManagerService;

    @Override
    public List<Integer> queryServeTimesById(Long id) {

        ServeProviderSync serveProviderSync = lambdaQuery().eq(ServeProviderSync::getId, id).one();
        return ObjectUtils.get(serveProviderSync, ServeProviderSync::getServeTimes);
    }

    @Override
    public void countServeTimesAndAcceptanceNum(Long id, Integer serveProviderType) {
        ServeProviderSync serveProviderSync = new ServeProviderSync();
        serveProviderSync.setId(id);
        if(serveProviderType == UserType.WORKER) {
            List<Integer> serveTimes = ordersServeManagerService.countServeTimes(id);
            //由于调用saveOrUpdate时遇到null不更新，这里如果为空设置为空list
            List<Integer> integers = CollUtils.defaultIfEmpty(serveTimes, new ArrayList<>());
            serveProviderSync.setServeTimes(integers);
        }else {
            serveProviderSync.setServeTimes(new ArrayList<>());
        }
        Integer acceptanceNum = ordersServeManagerService.countNoServedNum(id);
        serveProviderSync.setAcceptanceNum(NumberUtils.null2Zero(acceptanceNum));
        this.saveOrUpdate(serveProviderSync);
    }
}
