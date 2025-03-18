package com.zhilian.customer.controller.inner;

import com.zhilian.api.customer.CommonUserApi;
import com.zhilian.api.customer.dto.response.CommonUserResDTO;
import com.zhilian.common.utils.BeanUtils;
import com.zhilian.customer.service.ICommonUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 内部接口-普通用户相关接口
 *
 **/
@RestController
@RequestMapping("inner/common-user")
@Api(tags = "内部接口 - 普通用户相关接口")
public class InnerCommonUserController implements CommonUserApi {
    @Resource
    private ICommonUserService commonUserService;

    @Override
    public CommonUserResDTO findById(Long id) {
        return BeanUtils.toBean(commonUserService.getById(id), CommonUserResDTO.class);
    }
}
