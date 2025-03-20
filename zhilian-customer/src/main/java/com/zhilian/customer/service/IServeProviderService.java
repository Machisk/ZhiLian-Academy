package com.zhilian.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.api.customer.dto.request.ServerProviderUpdateStatusReqDTO;
import com.zhilian.api.customer.dto.response.ServeProviderResDTO;
import com.zhilian.api.customer.dto.response.ServeProviderSimpleResDTO;
import com.zhilian.common.model.PageResult;
import com.zhilian.customer.model.domain.ServeProvider;
import com.zhilian.customer.model.dto.request.InstitutionRegisterReqDTO;
import com.zhilian.customer.model.dto.request.InstitutionResetPasswordReqDTO;
import com.zhilian.customer.model.dto.request.ServeProviderPageQueryReqDTO;
import com.zhilian.customer.model.dto.response.CertificationStatusDTO;
import com.zhilian.customer.model.dto.response.ServeProviderBasicInformationResDTO;
import com.zhilian.customer.model.dto.response.ServeProviderInfoResDTO;
import com.zhilian.customer.model.dto.response.ServeProviderListResDTO;

import java.util.List;

/**
 * <p>
 * 服务人员/机构表 服务类
 * </p>
 *
 */
public interface IServeProviderService extends IService<ServeProvider> {

    /**
     * 分页查询服务人员列表
     *
     * @param serveProviderPageQueryReqDTO 查询条件
     * @return 分页结果
     */
    PageResult<ServeProviderListResDTO> pageQueryWorker(ServeProviderPageQueryReqDTO serveProviderPageQueryReqDTO);

    /**
     * 分页查询机构列表
     *
     * @param serveProviderPageQueryReqDTO 查询条件
     * @return 分页结果
     */
    PageResult<ServeProviderListResDTO> pageQueryAgency(ServeProviderPageQueryReqDTO serveProviderPageQueryReqDTO);

    /**
     * 更新服务人员/机构状态
     *
     * @param serverProviderUpdateStatusReqDTO 服务人员/机构更新状态请求
     */
    void updateStatus(ServerProviderUpdateStatusReqDTO serverProviderUpdateStatusReqDTO);

    /**
     * 根据手机号和用户类型获取用户信息
     *
     * @param phone 注册手机号
     * @param type  用户类型，2：服务人员，3：机构人员
     * @return
     */
    ServeProvider findByPhoneAndType(String phone, Integer type);

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    ServeProvider findById(Long id);

    /**
     * 注册机构用户
     *
     * @param institutionRegisterReqDTO
     */
    void registerInstitution(InstitutionRegisterReqDTO institutionRegisterReqDTO);

    /**
     * 新增用户
     *
     * @param phone    新增服务人员或机构的访问手机号
     * @param type     服务人员/机构类型，2：服务人员，3：机构
     * @param password 机构登录密码
     */
    ServeProvider add(String phone, Integer type, String password);

    /**
     * 机构密码重置
     *
     * @param institutionResetPasswordReqDTO
     */
    void resetPassword(InstitutionResetPasswordReqDTO institutionResetPasswordReqDTO);

//    /**
//     * 校验是否完成首次配置，如果完成则打上标记
//     * @param currentUserId
//     */
//    void settingStatus(Long currentUserId);

    ServeProviderResDTO findServeProviderInfo(Long id);

    /**
     * 根据id更新名称
     *
     * @param id   服务人员/机构id
     * @param name 名称
     */
    void updateNameById(Long id, String name);

    /**
     * 根据服务人员/机构id查询基本信息
     *
     * @param id 服务人员/机构id
     * @return 基本信息
     */
    ServeProviderBasicInformationResDTO findBasicInformationById(Long id);


    /**
     * 根据id更新评分数据
     *
     * @param id            服务人员/机构id
     * @param score         综合分数
     * @param goodLevelRate 好评率
     */
    void updateScoreById(Long id, Double score, String goodLevelRate);


    List<ServeProviderSimpleResDTO> batchGet(List<Long> ids);

    /**
     * 获取当前用户信息
     *
     * @return 用户信息
     */
    ServeProviderInfoResDTO currentUserInfo();

    /**
     * 获取服务人员或机构的信息状态
     * @param userType
     * @param providerId
     * @return
     */
    CertificationStatusDTO getCertificationStatus(Integer userType, Long providerId);
}
