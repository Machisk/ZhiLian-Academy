package com.zhilian.orders.dispatch.annotations;

import com.zhilian.orders.dispatch.enums.DispatchStrategyEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DispatchStrategy {
    /**
     * 派单策略
     * @return
     */
    DispatchStrategyEnum[] value();
}
