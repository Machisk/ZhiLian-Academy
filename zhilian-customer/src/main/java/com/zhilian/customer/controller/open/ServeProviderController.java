package com.zhilian.customer.controller.open;


import com.zhilian.customer.model.dto.request.InstitutionRegisterReqDTO;
import com.zhilian.customer.service.IServeProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 服务人员/机构表 前端控制器
 * </p>
 *
 */
@RestController("openServeProviderController")
@RequestMapping("/open/serve-provider")
@Api(tags = "白名单接口 - 服务人员或机构相关接口")
public class ServeProviderController {
    @Resource
    private IServeProviderService serveProviderService;

    @PostMapping("/institution/register")
    @ApiOperation("机构注册接口")
    public void institutionRegister(@RequestBody InstitutionRegisterReqDTO institutionRegisterReqDTO) {
        serveProviderService.registerInstitution(institutionRegisterReqDTO);
    }
}
