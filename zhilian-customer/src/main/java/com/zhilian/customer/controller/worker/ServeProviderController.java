package com.zhilian.customer.controller.worker;

import com.zhilian.customer.model.dto.response.ServeProviderInfoResDTO;
import com.zhilian.customer.model.dto.response.ServeProviderSettingsGetResDTO;
import com.zhilian.customer.service.IServeProviderService;
import com.zhilian.customer.service.IServeProviderSettingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("workerServeProviderController")
@RequestMapping("/worker/serve-provider")
@Api(tags = "服务端 - 服务人员相关接口")
public class ServeProviderController {

    @Resource
    private IServeProviderService serveProviderService;

    @GetMapping("/currentUserInfo")
    @ApiOperation("获取当前用户信息")
    public ServeProviderInfoResDTO currentUserInfo() {
        return serveProviderService.currentUserInfo();
    }
}
