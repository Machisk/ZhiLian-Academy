package com.zhilian.orders.manager.service.impl.client;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhilian.api.customer.AddressBookApi;
import com.zhilian.api.customer.dto.response.AddressBookResDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author MachiskComic
 * @ClassName CustomerClient
 * @date 2025-03-20 12:11
 */
@Component
@Slf4j
public class CustomerClient {

    @Resource
    private AddressBookApi addressBookApi;

    //value：资源名称,sentinel基于资源进行限流，熔断
    //fallback 当getDetail方法执行异常时会调用此方法，
    //blockHandler 当发生熔断、限流走此方法
    @SentinelResource(value = "getAddressBookDetail",fallback = "detailFallback", blockHandler = "detailBlockHandler")
    public AddressBookResDTO getDetail(Long id) {
        AddressBookResDTO detail = addressBookApi.detail(id);
        return detail;
    }

    //当getDetail方法执行异常时会调用此方法，
    public AddressBookResDTO detailFallback(Long id,Throwable throwable){
        log.error("非限流、熔断等导致的异常执行的降级方法，id:{},throwable:", id, throwable);
        return null;
    }
    //当发生熔断、限流走此方法
    public AddressBookResDTO detailBlockHandler(Long id, BlockException blockException){
        log.error("触发限流、熔断时执行的降级方法，id:{},blockException:", id, blockException);
        return null;
    }
}