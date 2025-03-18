package com.zhilian.api.publics;

import com.zhilian.api.publics.dto.response.BooleanResDTO;
import com.zhilian.common.enums.SmsBussinessTypeEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "zhilian-publics", value = "zhilian-publics", path = "/publics/inner/sms-code")
public interface SmsCodeApi {

    /**
     * 校验短信验证码
     *
     * @param phone         验证手机号
     * @param bussinessType 业务类型
     * @param verifyCode    验证码
     * @return 验证结果
     */
    @GetMapping("/verify")
    BooleanResDTO verify(@RequestParam("phone") String phone,
                         @RequestParam("bussinessType") SmsBussinessTypeEnum bussinessType,
                         @RequestParam("verifyCode") String verifyCode);
}
