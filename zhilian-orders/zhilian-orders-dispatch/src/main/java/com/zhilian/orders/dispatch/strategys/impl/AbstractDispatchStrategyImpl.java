package com.zhilian.orders.dispatch.strategys.impl;

import com.zhilian.common.utils.CollUtils;
import com.zhilian.orders.dispatch.model.dto.ServeProviderDTO;
import com.zhilian.orders.dispatch.rules.IDispatchRule;
import com.zhilian.orders.dispatch.strategys.IDispatchStrategy;

import java.util.List;
import java.util.Objects;

public abstract class AbstractDispatchStrategyImpl implements IDispatchStrategy {
    private final IDispatchRule dispatchRule;

    public AbstractDispatchStrategyImpl() {
        this.dispatchRule = getRules();
        // 校验是否配置策略
        Objects.requireNonNull(this.dispatchRule);
    }

    /**
     * 设置派单规则
     * @return
     */
    protected abstract IDispatchRule getRules();

    @Override
    public ServeProviderDTO getPrecedenceServeProvider(List<ServeProviderDTO> serveProviderDTOS) {
        // 1.判空
        if (CollUtils.isEmpty(serveProviderDTOS)){
            return null;
        }
        IDispatchRule dr = dispatchRule;

        // 2.根据优先级获取高优先级别的
        serveProviderDTOS = dr.filter(serveProviderDTOS);

        // 3.数据返回
        // 3.1.唯一高优先级直接返回
        int size = 1;
        if((size = CollUtils.size(serveProviderDTOS)) == 1) {
            return serveProviderDTOS.get(0);
        }
        // 3.2.多个高优先级随即将返回
        int randomIndex = (int) (Math.random() * size);
        return serveProviderDTOS.get(randomIndex);
    }
}
