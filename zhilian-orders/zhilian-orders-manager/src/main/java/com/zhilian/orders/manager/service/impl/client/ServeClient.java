package com.zhilian.orders.manager.service.impl.client;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhilian.api.foundations.ServeApi;
import com.zhilian.api.foundations.dto.response.ServeAggregationResDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author MachiskComic
 * @ClassName ServeClient
 * @date 2025-03-20 21:39
 */
@Component
@Slf4j
public class ServeClient {
    @Resource
    private ServeApi serveApi;
    @SentinelResource(value = "findById", fallback = "findByIdFallback", blockHandler = "findByIdBlockHandler")
    public ServeAggregationResDTO findById(Long id) {
        return serveApi.findById(id);
    }

    //执行异常走
    public ServeAggregationResDTO findByIdFallback(Long id, Throwable throwable) {
        log.error("非限流、熔断等导致的异常执行的降级方法，id:{},throwable:", id, throwable);
        return null;
    }

    //熔断后的降级逻辑
    public ServeAggregationResDTO findByIdBlockHandler(Long id, BlockException blockException) {
        log.error("非限流、熔断等导致的异常执行的降级方法，id:{},throwable:", id, blockException);
        return null;
    }
}
