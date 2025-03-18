package com.zhilian.api.customer;

import com.zhilian.api.customer.dto.response.CommonUserResDTO;
import com.zhilian.common.model.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 内部接口 - 普通用户相关接口
 *
 */
@FeignClient(contextId = "zhilian-customer", value = "zhilian-customer", path = "/customer/inner/common-user")
public interface CommonUserApi {

    @GetMapping("/{id}")
    CommonUserResDTO findById(@PathVariable("id") Long id);
}
