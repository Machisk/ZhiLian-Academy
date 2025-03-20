package com.zhilian.orders.dispatch.strategys;

import com.zhilian.orders.dispatch.enums.DispatchStrategyEnum;

public interface IDispatchStrategyManager {
    /**
     * 设置派单策略
     * @param dispatchStrategy
     */
    void put(DispatchStrategyEnum dispatchStrategyEnum, IDispatchStrategy dispatchStrategy);

    /**
     * 获取派单策略
     * @param dispatchStrategyEnum
     * @return
     */
    IDispatchStrategy get(DispatchStrategyEnum dispatchStrategyEnum);
}
