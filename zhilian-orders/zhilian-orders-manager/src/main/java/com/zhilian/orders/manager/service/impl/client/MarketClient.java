package com.zhilian.orders.manager.service.impl.client;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhilian.api.customer.AddressBookApi;
import com.zhilian.api.customer.dto.response.AddressBookResDTO;
import com.zhilian.api.market.CouponApi;
import com.zhilian.api.market.dto.response.AvailableCouponsResDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * @author MachiskComic
 * @ClassName MarketClient
 * @date 2025-03-20 12:18
 */
@Component
@Slf4j
public class MarketClient {
    @Resource
    private CouponApi couponApi;
    @SentinelResource(value = "getAvailableByCouponApi", fallback = "getAvailableFallback", blockHandler = "getAvailableBlockHandler")
    public List<AvailableCouponsResDTO> getAvailable(BigDecimal totalAmount) {

        log.error("查询可用优惠券,订单金额:{}",totalAmount);
        //调用可用优惠券
        List<AvailableCouponsResDTO> available = couponApi.getAvailable(totalAmount);
        return available;
    }

    //执行异常走
    public List<AvailableCouponsResDTO> getAvailableFallback(BigDecimal totalAmount, Throwable throwable) {
        log.error("非限流、熔断等导致的异常执行的降级方法，totalAmount:{},throwable:", totalAmount, throwable);
        return Collections.emptyList();
    }

    //熔断后的降级逻辑
    public List<AvailableCouponsResDTO> getAvailableBlockHandler(BigDecimal totalAmount, BlockException blockException) {
        log.error("触发限流、熔断时执行的降级方法，totalAmount:{},blockException:", totalAmount, blockException);
        return Collections.emptyList();
    }


}
