package com.zhilian.customer.controller.consumer;

import com.zhilian.customer.service.ICommonUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 普通用户相关接口
 *
 **/
@RestController("consumerCommonUserController")
@RequestMapping("/consumer/common-user")
@Api(tags = "用户端 - 普通用户相关接口")
public class CommonUserController {
    @Resource
    private ICommonUserService commonUserService;

    @PutMapping
    @ApiOperation("更新用户手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phoneCode", value = "微信手机号授权码", required = true, dataTypeClass = String.class)
    })
    public void update(@RequestParam("phoneCode") String phoneCode) {
        commonUserService.updatePhone(phoneCode);
    }

}
