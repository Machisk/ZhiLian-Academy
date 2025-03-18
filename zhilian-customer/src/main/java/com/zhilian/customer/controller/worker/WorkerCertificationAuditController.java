package com.zhilian.customer.controller.worker;

import com.zhilian.customer.model.dto.request.WorkerCertificationAuditAddReqDTO;
import com.zhilian.customer.model.dto.response.RejectReasonResDTO;
import com.zhilian.customer.service.IWorkerCertificationAuditService;
import com.zhilian.mvc.utils.UserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("workerWorkerCertificationAuditController")
@RequestMapping("/worker/worker-certification-audit")
@Api(tags = "服务端 - 服务人员认证审核相关接口")
public class WorkerCertificationAuditController {

    @Resource
    private IWorkerCertificationAuditService workerCertificationAuditService;

    @PostMapping
    @ApiOperation("提交认证申请")
    public void auditCertification(@RequestBody WorkerCertificationAuditAddReqDTO workerCertificationAuditAddReqDTO) {
        workerCertificationAuditAddReqDTO.setServeProviderId(UserContext.currentUserId());
        workerCertificationAuditService.applyCertification(workerCertificationAuditAddReqDTO);
    }

    @GetMapping("/rejectReason")
    @ApiOperation("查询最新的驳回原因")
    public RejectReasonResDTO queryCurrentUserLastRejectReason() {
        return workerCertificationAuditService.queryCurrentUserLastRejectReason();
    }
}
