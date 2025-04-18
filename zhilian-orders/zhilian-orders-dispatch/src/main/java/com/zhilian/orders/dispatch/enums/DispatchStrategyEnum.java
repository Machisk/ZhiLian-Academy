package com.zhilian.orders.dispatch.enums;

import com.zhilian.orders.dispatch.strategys.IDispatchStrategy;
import com.zhilian.orders.dispatch.strategys.impl.DistanceDispatchStrategyImpl;
import com.zhilian.orders.dispatch.strategys.impl.EvaluationScoreDispatchStrategyImpl;
import com.zhilian.orders.dispatch.strategys.impl.LeastAcceptOrderDispatchStrategyImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum DispatchStrategyEnum {
    /**
     * 距离优先策略
     */
    DISTANCE(1, new DistanceDispatchStrategyImpl()),
    /**
     * 评分优先策略
     */
    EVELUATION_SCORE(2, new EvaluationScoreDispatchStrategyImpl()),
    /**
     * 最少接单策略
     */
    LEAST_ACCEPT_ORDER(3, new LeastAcceptOrderDispatchStrategyImpl());

    private int type;
    private IDispatchStrategy dispatchStrategy;

    public static DispatchStrategyEnum of(Integer type) {
        if(type == null) {
            return null;
        }
        for (DispatchStrategyEnum dispatchStrategyEnum : values()) {
            if(type.equals(dispatchStrategyEnum.type)){
                return dispatchStrategyEnum;
            }
        }
        return null;
    }


}
