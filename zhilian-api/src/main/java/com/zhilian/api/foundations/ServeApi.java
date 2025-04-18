package com.zhilian.api.foundations;

import com.zhilian.api.foundations.dto.response.ServeAggregationResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "zhilian-foundations", value = "zhilian-foundations", path = "/foundations/inner/serve")
public interface ServeApi {

    @GetMapping("/{id}")
    ServeAggregationResDTO findById(@PathVariable("id") Long id);

}
