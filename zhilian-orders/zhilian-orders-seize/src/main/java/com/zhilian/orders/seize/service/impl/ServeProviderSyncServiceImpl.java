package com.zhilian.orders.seize.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.common.constants.UserType;
import com.zhilian.common.utils.NumberUtils;
import com.zhilian.common.utils.ObjectUtils;
import com.zhilian.orders.base.mapper.ServeProviderSyncMapper;
import com.zhilian.orders.base.model.domain.ServeProviderSync;
import com.zhilian.orders.seize.service.IOrdersServeService;
import com.zhilian.orders.seize.service.IServeProviderSyncService;
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
    private IOrdersServeService ordersServeService;

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
            List<Integer> serveTimes = ordersServeService.countServeTimes(id);
            serveProviderSync.setServeTimes(serveTimes);
        }else {
            serveProviderSync.setServeTimes(new ArrayList<>());
        }
        Integer acceptanceNum = ordersServeService.countNoServedNum(id);
        serveProviderSync.setAcceptanceNum(NumberUtils.null2Zero(acceptanceNum));
        this.saveOrUpdate(serveProviderSync);
    }
}
