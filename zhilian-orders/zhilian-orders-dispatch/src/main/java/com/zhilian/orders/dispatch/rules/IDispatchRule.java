package com.zhilian.orders.dispatch.rules;

import com.zhilian.orders.dispatch.model.dto.ServeProviderDTO;

import java.util.List;

/**
 * 派单规则
 */
public interface IDispatchRule {

    /**
     * 根据派单规则过滤服务人员
     * @param serveProviderDTOS
     * @return
     */
    List<ServeProviderDTO> filter(List<ServeProviderDTO> serveProviderDTOS);

    /**
     * 获取下一级规则
     *
     * @return
     */
    IDispatchRule next();

}
