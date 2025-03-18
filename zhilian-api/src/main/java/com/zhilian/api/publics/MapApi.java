package com.zhilian.api.publics;

import com.zhilian.api.publics.dto.response.LocationResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "zhilian-publics", value = "zhilian-publics", path = "/publics/inner/map")
public interface MapApi {

    @GetMapping("/getLocationByAddress")
    LocationResDTO getLocationByAddress(@RequestParam("address") String address);
}
