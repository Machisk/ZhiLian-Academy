package com.zhilian.foundations.controller.operation;


import com.zhilian.foundations.model.dto.request.ConfigRegionSetReqDTO;
import com.zhilian.foundations.model.dto.response.ConfigRegionResDTO;
import com.zhilian.foundations.service.IConfigRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 区域表 前端控制器
 * </p>
 *
 */
@Validated
@RestController("operationConfigRegionController")
@RequestMapping("/operation/config-region")
@Api(tags = "运营端 - 区域配置相关接口")
public class ConfigRegionController {
    @Resource
    private IConfigRegionService configRegionService;

    @GetMapping("/{id}")
    @ApiOperation("获取区域配置")
    @ApiImplicitParam(name = "id", value = "区域id", required = true, dataTypeClass = Long.class)
    public ConfigRegionResDTO queryById(@PathVariable(value = "id") Long id) {
        return configRegionService.queryById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("区域配置设置")
    @ApiImplicitParam(name = "id", value = "区域id", required = true, dataTypeClass = Long.class)
    public void putById(@PathVariable(value = "id") Long id, @Validated @RequestBody ConfigRegionSetReqDTO configRegionSetReqDTO) {
        configRegionService.setConfigRegionById(id, configRegionSetReqDTO);
    }
}
