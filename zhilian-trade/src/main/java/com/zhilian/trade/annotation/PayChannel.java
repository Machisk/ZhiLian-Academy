package com.zhilian.trade.annotation;

import com.zhilian.api.trade.enums.PayChannelEnum;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented //标记注解
public @interface PayChannel {

    PayChannelEnum type();

}