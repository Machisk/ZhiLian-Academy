package com.zhilian.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.customer.model.domain.AgencyCertification;
import com.zhilian.customer.model.dto.AgencyCertificationUpdateDTO;
import com.zhilian.customer.model.dto.response.AgencyCertificationResDTO;

/**
 * <p>
 * 机构认证信息表 服务类
 * </p>
 *
 */
public interface IAgencyCertificationService extends IService<AgencyCertification> {


    /**
     * 根据机构id更新
     *
     * @param agencyCertificationUpdateDTO 机构认证更新模型
     */
    void updateByServeProviderId(AgencyCertificationUpdateDTO agencyCertificationUpdateDTO);


}
