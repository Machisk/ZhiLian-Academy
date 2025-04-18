package com.zhilian.customer.controller.agency;

import com.zhilian.customer.model.dto.request.AgencyCertificationAuditAddReqDTO;
import com.zhilian.customer.model.dto.response.RejectReasonResDTO;
import com.zhilian.customer.service.IAgencyCertificationAuditService;
import com.zhilian.mvc.utils.UserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("agencyAgencyCertificationAuditController")
@RequestMapping("/agency/agency-certification-audit")
@Api(tags = "机构端 - 机构认证审核相关接口")
public class AgencyCertificationAuditController {
    @Resource
    private IAgencyCertificationAuditService agencyCertificationAuditService;

    @PostMapping
    @ApiOperation("提交认证申请")
    public void auditCertification(@RequestBody AgencyCertificationAuditAddReqDTO agencyCertificationAuditAddReqDTO) {
        agencyCertificationAuditAddReqDTO.setServeProviderId(UserContext.currentUserId());
        agencyCertificationAuditService.applyCertification(agencyCertificationAuditAddReqDTO);
    }

    @GetMapping("/rejectReason")
    @ApiOperation("查询最新的驳回原因")
    public RejectReasonResDTO queryCurrentUserLastRejectReason() {
        return agencyCertificationAuditService.queryCurrentUserLastRejectReason();
    }
}
