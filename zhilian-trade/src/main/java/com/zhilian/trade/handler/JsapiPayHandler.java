package com.zhilian.trade.handler;

import com.zhilian.trade.model.domain.Trading;

/**
 * jsapi下单处理
 *
 */
public interface JsapiPayHandler {

    /**
     * 创建交易
     *
     * @param tradingEntity 交易单
     */
    void createJsapiTrading(Trading tradingEntity);
}
