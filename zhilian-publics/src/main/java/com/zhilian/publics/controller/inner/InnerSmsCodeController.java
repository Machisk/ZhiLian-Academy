package com.zhilian.publics.controller.inner;

import com.zhilian.api.publics.SmsCodeApi;
import com.zhilian.api.publics.dto.response.BooleanResDTO;
import com.zhilian.common.enums.SmsBussinessTypeEnum;
import com.zhilian.publics.service.ISmsCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 验证码
 *
 **/
@RestController
@RequestMapping("/inner/sms-code")
@Api(tags = "内部接口 - 验证码相关接口")
public class InnerSmsCodeController implements SmsCodeApi {
    @Resource
    private ISmsCodeService smsCodeService;

    @Override
    @GetMapping("/verify")
    @ApiOperation("校验短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "验证手机号", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "bussinessType", value = "业务类型", required = true, dataTypeClass = SmsBussinessTypeEnum.class),
            @ApiImplicitParam(name = "verifyCode", value = "验证码", required = true, dataTypeClass = String.class)
    })
    public BooleanResDTO verify(@RequestParam("phone") String phone,
                                @RequestParam("bussinessType") SmsBussinessTypeEnum bussinessType,
                                @RequestParam("verifyCode") String verifyCode) {
        return new BooleanResDTO(smsCodeService.verify(phone, bussinessType, verifyCode));
    }
}
