package com.zhilian.customer.controller.operation;

import cn.hutool.core.bean.BeanUtil;
import com.zhilian.customer.model.dto.response.AgencyCertificationResDTO;
import com.zhilian.customer.service.IAgencyCertificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("operationAgencyCertificationController")
@RequestMapping("/operation/agency-certification")
@Api(tags = "运营端 - 机构认证信息相关接口")
public class AgencyCertificationController {

    @Resource
    private IAgencyCertificationService agencyCertificationService;

    @GetMapping("/{id}")
    @ApiOperation("根据机构id查询认证信息")
    public AgencyCertificationResDTO queryById(@PathVariable("id") Long id) {
        return BeanUtil.toBean(agencyCertificationService.getById(id), AgencyCertificationResDTO.class);
    }
}
