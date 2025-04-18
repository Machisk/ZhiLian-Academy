package com.zhilian.customer.controller.agency;


import com.zhilian.api.foundations.dto.response.ServeItemSimpleResDTO;
import com.zhilian.api.foundations.dto.response.ServeTypeSimpleResDTO;
import com.zhilian.customer.model.dto.request.ServeSkillAddReqDTO;
import com.zhilian.customer.model.dto.response.ServeSkillCategoryResDTO;
import com.zhilian.customer.service.IServeSkillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务技能表 前端控制器
 * </p>
 *
 */
@RestController("agencyServeSkillController")
@RequestMapping("/agency/serve-skill")
@Api(tags = "机构端 - 服务技能相关接口")
public class ServeSkillController {
    @Resource
    private IServeSkillService serveSkillService;

    @PostMapping("/batchUpsert")
    @ApiOperation("批量新增或修改服务技能")
    public void listServeType(@RequestBody List<ServeSkillAddReqDTO> serveSkillAddReqDTOList) {
        serveSkillService.batchUpsert(serveSkillAddReqDTOList);
    }

    @GetMapping("/category")
    @ApiOperation("查询服务技能目录")
    public List<ServeSkillCategoryResDTO> category() {
        return serveSkillService.category();
    }

    @GetMapping("/queryCurrentUserServeSkillTypeList")
    @ApiOperation("查询当前用户的服务技能类型")
    public List<ServeTypeSimpleResDTO> queryCurrentUserServeSkillTypeList() {
        return serveSkillService.queryCurrentUserServeSkillTypeList();
    }

    @GetMapping("/queryCurrentUserServeSkillItemList")
    @ApiOperation("查询当前用户的服务技能")
    public List<ServeItemSimpleResDTO> queryCurrentUserServeSkillItemList() {
        return serveSkillService.queryCurrentUserServeSkillItemList();
    }
}
