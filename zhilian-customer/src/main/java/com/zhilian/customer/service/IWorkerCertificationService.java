package com.zhilian.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.customer.model.domain.WorkerCertification;
import com.zhilian.customer.model.dto.WorkerCertificationUpdateDTO;

/**
 * <p>
 * 服务人员认证信息表 服务类
 * </p>
 *
 */
public interface IWorkerCertificationService extends IService<WorkerCertification> {



    /**
     * 根据服务人员id更新
     *
     * @param workerCertificationUpdateDTO 服务人员认证更新模型
     */
    void updateById(WorkerCertificationUpdateDTO workerCertificationUpdateDTO);
}
