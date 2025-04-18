package com.zhilian.customer.controller.open;

import com.zhilian.common.constants.UserType;
import com.zhilian.customer.model.dto.request.LoginForCustomerReqDTO;
import com.zhilian.customer.model.dto.request.LoginForWorkReqDTO;
import com.zhilian.customer.model.dto.response.LoginResDTO;
import com.zhilian.customer.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("openLoginController")
@RequestMapping("/open/login")
@Api(tags = "白名单接口 - 客户登录相关接口")
public class LoginController {

    @Resource
    private ILoginService loginService;

    @PostMapping("/worker")
    @ApiOperation("服务人员/机构人员登录接口")
    public LoginResDTO loginForWorker(@RequestBody LoginForWorkReqDTO loginForWorkReqDTO) {

        if(UserType.INSTITUTION == loginForWorkReqDTO.getUserType()){
            return loginService.loginForPassword(loginForWorkReqDTO);
        }else{
            return loginService.loginForVerify(loginForWorkReqDTO);
        }

    }

    /**
     * c端用户登录接口
     */
    @PostMapping("/common/user")
    @ApiOperation("c端用户登录接口")
    public LoginResDTO loginForCommonUser(@RequestBody LoginForCustomerReqDTO loginForCustomerReqDTO) {
        return loginService.loginForCommonUser(loginForCustomerReqDTO);
    }

}
