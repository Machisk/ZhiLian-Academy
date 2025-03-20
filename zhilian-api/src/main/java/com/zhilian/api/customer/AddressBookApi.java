package com.zhilian.api.customer;

import com.zhilian.api.customer.dto.response.AddressBookResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MachiskComic
 * @ClassName AddressBookApi
 * @date 2025-03-20 11:56
 */
//contextId 指定FeignClient实例的上下文id，如果不设置默认为类名，value指定微服务的名称，path:指定接口地址
@FeignClient(contextId = "zhilian-customer", value = "zhilian-customer", path = "/customer/inner/address-book")
public interface AddressBookApi {

    @GetMapping("/{id}")
    AddressBookResDTO detail(@PathVariable("id") Long id);

}