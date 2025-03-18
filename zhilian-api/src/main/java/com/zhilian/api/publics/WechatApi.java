package com.zhilian.api.publics;

import com.zhilian.api.publics.dto.response.OpenIdResDTO;
import com.zhilian.api.publics.dto.response.PhoneResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "zhilian-publics", value = "zhilian-publics", path = "/publics/inner/wechat")
public interface WechatApi {

    @GetMapping("/getOpenId")
    OpenIdResDTO getOpenId(@RequestParam("code") String code);

    @GetMapping("/getPhone")
    PhoneResDTO getPhone(@RequestParam("code") String code);
}
