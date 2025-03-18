package com.zhilian.customer.controller.operation;

import com.zhilian.api.customer.dto.request.CommonUserPageQueryReqDTO;
import com.zhilian.api.customer.dto.request.CommonUserUpdateReqDTO;
import com.zhilian.api.customer.dto.response.CommonUserResDTO;
import com.zhilian.common.model.PageResult;
import com.zhilian.customer.service.ICommonUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("operationCommonUserController")
@RequestMapping("/operation/common-user")
@Api(tags = "运营端 - 普通用户相关接口")
public class CommonUserController {

    @Resource
    private ICommonUserService commonUserService;

    @GetMapping("/page")
    @ApiOperation("普通用户分页查询")
    public PageResult<CommonUserResDTO> page(CommonUserPageQueryReqDTO commonUserPageQueryReqDTO) {
        return commonUserService.page(commonUserPageQueryReqDTO);
    }

    @PutMapping("/updateStatus")
    @ApiOperation("账号冻结/解冻")
    public void updateStatus(@RequestBody CommonUserUpdateReqDTO commonUserUpdateReqDTO) {
        commonUserService.updateStatus(commonUserUpdateReqDTO);
    }
}
