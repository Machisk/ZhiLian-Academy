package com.zhilian.api.trade;

import com.zhilian.api.trade.dto.response.TradingResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "zhilian-trade", value = "zhilian-trade", path = "/trade/inner/tradings")
public interface TradingApi {

    /**
     * 根据交易单号查询交易单的交易结果，与findTradByTradingOrderNo不同的是当支付中时会立即调用第三方支付系统查询支付结果
     *
     * @param tradingOrderNo 订单号
     * @return 交易单数据
     */
    @GetMapping("/findTradResultByTradingOrderNo")
    TradingResDTO findTradResultByTradingOrderNo(@RequestParam("tradingOrderNo") Long tradingOrderNo);
}
