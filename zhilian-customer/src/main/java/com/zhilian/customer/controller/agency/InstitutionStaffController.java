package com.zhilian.customer.controller.agency;


import com.zhilian.api.customer.dto.request.InstitutionStaffPageQueryReqDTO;
import com.zhilian.api.customer.dto.response.InstitutionStaffResDTO;
import com.zhilian.common.model.CurrentUserInfo;
import com.zhilian.common.model.PageResult;
import com.zhilian.customer.model.dto.request.InstitutionStaffUpsertReqDTO;
import com.zhilian.customer.model.dto.response.InstitutionStaffSimpleResDTO;
import com.zhilian.customer.service.IInstitutionStaffService;
import com.zhilian.mvc.utils.UserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 机构下属服务人员 前端控制器
 * </p>
 *
 */
@RestController("agencyInstitutionStaffController")
@RequestMapping("/agency/institution-staff")
@Api(tags = "机构端 - 机构下属服务人员相关接口")
public class InstitutionStaffController {
    @Resource
    private IInstitutionStaffService institutionStaffService;

    @PostMapping
    @ApiOperation("新增机构下属服务人员")
    public void add(@RequestBody InstitutionStaffUpsertReqDTO institutionStaffUpsertReqDTO) {
        institutionStaffService.add(institutionStaffUpsertReqDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation("更新机构下属服务人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "机构下属服务人员id", required = true, dataTypeClass = Long.class)
    })
    public void update(@PathVariable("id") Long id, @RequestBody InstitutionStaffUpsertReqDTO institutionStaffUpsertReqDTO) {
        institutionStaffService.update(id, institutionStaffUpsertReqDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "机构下属服务人员id", required = true, dataTypeClass = Long.class)
    })
    public void delete(@PathVariable("id") Long id) {
        institutionStaffService.delete(id);
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public PageResult<InstitutionStaffResDTO> page(InstitutionStaffPageQueryReqDTO institutionStaffPageQueryReqDTO) {
        institutionStaffPageQueryReqDTO.setInstitutionId(UserContext.currentUserId());
        return institutionStaffService.pageQuery(institutionStaffPageQueryReqDTO);
    }

    @GetMapping("/queryInstitutionStaffList")
    @ApiOperation("机构下属服务人员列表")
    public List<InstitutionStaffSimpleResDTO> queryInstitutionStaffList() {
        return institutionStaffService.queryInstitutionStaffList();
    }
}
