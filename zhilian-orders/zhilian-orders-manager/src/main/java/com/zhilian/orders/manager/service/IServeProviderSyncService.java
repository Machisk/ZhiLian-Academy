package com.zhilian.orders.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.orders.base.model.domain.ServeProviderSync;

import java.util.List;

/**
 * <p>
 * 机构服务端更新服务时间 服务类
 * </p>
 *
 */
public interface IServeProviderSyncService extends IService<ServeProviderSync> {

    List<Integer> queryServeTimesById(Long id);

    /**
     * 统计用户或机构当前服务时间列表和接单数量
     *
     * @param id 服务人员或机构id
     * @param serveProviderType 类型，2：服务人员，3：机构
     */
    void countServeTimesAndAcceptanceNum(Long id, Integer serveProviderType);




}
