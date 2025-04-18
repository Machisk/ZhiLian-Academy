package com.zhilian.customer.controller.operation;

import com.zhilian.common.model.PageResult;
import com.zhilian.customer.model.dto.request.AgencyCertificationAuditPageQueryReqDTO;
import com.zhilian.customer.model.dto.request.CertificationAuditReqDTO;
import com.zhilian.customer.model.dto.response.AgencyCertificationAuditResDTO;
import com.zhilian.customer.service.IAgencyCertificationAuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("operationAgencyCertificationAuditController")
@RequestMapping("/operation/agency-certification-audit")
@Api(tags = "运营端 - 机构认证审核相关接口")
public class AgencyCertificationAuditController {

    @Resource
    private IAgencyCertificationAuditService agencyCertificationAuditService;

    @GetMapping("/page")
    @ApiOperation("机构认证审核信息分页查询")
    public PageResult<AgencyCertificationAuditResDTO> page(AgencyCertificationAuditPageQueryReqDTO agencyCertificationAuditPageQueryReqDTO) {
        return agencyCertificationAuditService.pageQuery(agencyCertificationAuditPageQueryReqDTO);
    }

    @PutMapping("/audit/{id}")
    @ApiOperation("审核机构认证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "认证申请id", required = true, dataTypeClass = Long.class)
    })
    public void auditCertification(@PathVariable("id") Long id, CertificationAuditReqDTO certificationAuditReqDTO) {
        agencyCertificationAuditService.auditCertification(id, certificationAuditReqDTO);
    }
}
