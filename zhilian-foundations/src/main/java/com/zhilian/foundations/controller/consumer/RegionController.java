package com.zhilian.foundations.controller.consumer;


import com.zhilian.api.foundations.dto.response.RegionSimpleResDTO;
import com.zhilian.foundations.service.IRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 区域表 前端控制器
 * </p>
 *
 */
@RestController("consumerRegionController")
@RequestMapping("/consumer/region")
@Api(tags = "用户端 - 区域相关接口")
public class RegionController {
    @Resource
    private IRegionService regionService;

    @GetMapping("/activeRegionList")
    @ApiOperation("已开通服务区域列表")
    public List<RegionSimpleResDTO> activeRegionList() {
        return regionService.queryActiveRegionListCache();
    }

}
