package com.zhilian.customer.controller.operation;

import com.zhilian.common.model.PageResult;
import com.zhilian.customer.model.dto.request.CertificationAuditReqDTO;
import com.zhilian.customer.model.dto.request.WorkerCertificationAuditPageQueryReqDTO;
import com.zhilian.customer.model.dto.response.WorkerCertificationAuditResDTO;
import com.zhilian.customer.service.IWorkerCertificationAuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("operationWorkerCertificationAuditController")
@RequestMapping("/operation/worker-certification-audit")
@Api(tags = "运营端 - 服务人员认证审核相关接口")
public class WorkerCertificationAuditController {

    @Resource
    private IWorkerCertificationAuditService workerCertificationAuditService;

    @GetMapping("/page")
    @ApiOperation("服务人员认证审核信息分页查询")
    public PageResult<WorkerCertificationAuditResDTO> page(WorkerCertificationAuditPageQueryReqDTO workerCertificationAuditPageQueryReqDTO) {
        return workerCertificationAuditService.pageQuery(workerCertificationAuditPageQueryReqDTO);
    }

    @PutMapping("/audit/{id}")
    @ApiOperation("审核服务人员认证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "认证申请id", required = true, dataTypeClass = Long.class)
    })
    public void auditCertification(@PathVariable("id") Long id, CertificationAuditReqDTO certificationAuditReqDTO) {
        workerCertificationAuditService.auditCertification(id, certificationAuditReqDTO);
    }
}
