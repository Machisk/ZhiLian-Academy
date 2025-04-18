package com.zhilian.customer.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.customer.enums.CertificationStatusEnum;
import com.zhilian.customer.mapper.AgencyCertificationMapper;
import com.zhilian.customer.model.domain.AgencyCertification;
import com.zhilian.customer.model.dto.AgencyCertificationUpdateDTO;
import com.zhilian.customer.service.IAgencyCertificationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机构认证信息表 服务实现类
 * </p>
 *
 */
@Service
public class AgencyCertificationServiceImpl extends ServiceImpl<AgencyCertificationMapper, AgencyCertification> implements IAgencyCertificationService {



    /**
     * 根据机构id更新
     *
     * @param agencyCertificationUpdateDTO 机构认证更新模型
     */
    @Override
    public void updateByServeProviderId(AgencyCertificationUpdateDTO agencyCertificationUpdateDTO) {
        LambdaUpdateWrapper<AgencyCertification> updateWrapper = Wrappers.<AgencyCertification>lambdaUpdate()
                .eq(AgencyCertification::getId, agencyCertificationUpdateDTO.getId())
                .set(AgencyCertification::getCertificationStatus, agencyCertificationUpdateDTO.getCertificationStatus())
                .set(ObjectUtil.isNotEmpty(agencyCertificationUpdateDTO.getName()), AgencyCertification::getName, agencyCertificationUpdateDTO.getName())
                .set(ObjectUtil.isNotEmpty(agencyCertificationUpdateDTO.getIdNumber()), AgencyCertification::getIdNumber, agencyCertificationUpdateDTO.getIdNumber())
                .set(ObjectUtil.isNotEmpty(agencyCertificationUpdateDTO.getLegalPersonName()), AgencyCertification::getLegalPersonName, agencyCertificationUpdateDTO.getLegalPersonName())
                .set(ObjectUtil.isNotEmpty(agencyCertificationUpdateDTO.getLegalPersonIdCardNo()), AgencyCertification::getLegalPersonIdCardNo, agencyCertificationUpdateDTO.getLegalPersonIdCardNo())
                .set(ObjectUtil.isNotEmpty(agencyCertificationUpdateDTO.getBusinessLicense()), AgencyCertification::getBusinessLicense, agencyCertificationUpdateDTO.getBusinessLicense())
                .set(ObjectUtil.isNotEmpty(agencyCertificationUpdateDTO.getCertificationTime()), AgencyCertification::getCertificationTime, agencyCertificationUpdateDTO.getCertificationTime());
        super.update(updateWrapper);
    }


}
