package com.zhilian.customer.controller.operation;


import com.zhilian.api.customer.dto.request.InstitutionStaffPageQueryReqDTO;
import com.zhilian.api.customer.dto.response.InstitutionStaffResDTO;
import com.zhilian.common.model.PageResult;
import com.zhilian.customer.service.IInstitutionStaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 运营端 - 机构下属服务人员相关接口
 * </p>
 *
 */
@Validated
@RestController("operationInstitutionStaffController")
@RequestMapping("/operation/institution-staff")
@Api(tags = "运营端 - 机构下属服务人员相关接口")
public class InstitutionStaffController {
    @Resource
    private IInstitutionStaffService institutionStaffService;

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public PageResult<InstitutionStaffResDTO> page(InstitutionStaffPageQueryReqDTO institutionStaffPageQueryReqDTO) {
        return institutionStaffService.pageQuery(institutionStaffPageQueryReqDTO);
    }
}
