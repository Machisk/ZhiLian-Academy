package com.zhilian.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.common.model.PageResult;
import com.zhilian.customer.model.domain.WorkerCertificationAudit;
import com.zhilian.customer.model.dto.request.CertificationAuditReqDTO;
import com.zhilian.customer.model.dto.request.WorkerCertificationAuditAddReqDTO;
import com.zhilian.customer.model.dto.request.WorkerCertificationAuditPageQueryReqDTO;
import com.zhilian.customer.model.dto.response.RejectReasonResDTO;
import com.zhilian.customer.model.dto.response.WorkerCertificationAuditResDTO;

/**
 * <p>
 * 服务人员认证审核表 服务类
 * </p>
 *
 */
public interface IWorkerCertificationAuditService extends IService<WorkerCertificationAudit> {
    /**
     * 服务人员申请资质认证
     *
     * @param workerCertificationAuditAddReqDTO 认证申请请求体
     */
    void applyCertification(WorkerCertificationAuditAddReqDTO workerCertificationAuditAddReqDTO);

    /**
     * 审核认证信息
     *
     * @param id                       申请记录id
     * @param certificationAuditReqDTO 审核请求
     */
    void auditCertification(Long id, CertificationAuditReqDTO certificationAuditReqDTO);

    /**
     * 分页查询
     *
     * @param workerCertificationAuditPageQueryReqDTO 分页查询条件
     * @return 分页结果
     */
    PageResult<WorkerCertificationAuditResDTO> pageQuery(WorkerCertificationAuditPageQueryReqDTO workerCertificationAuditPageQueryReqDTO);

    /**
     * 查询当前用户最近驳回原因
     *
     * @return 驳回原因
     */
    RejectReasonResDTO queryCurrentUserLastRejectReason();
}
