package com.zhilian.api.customer;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(contextId = "customer", value = "zhilian-customer")
public interface CustomerApi {



}
