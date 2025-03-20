package com.zhilian.customer.service;

import com.zhilian.api.customer.dto.request.CommonUserPageQueryReqDTO;
import com.zhilian.api.customer.dto.request.CommonUserUpdateReqDTO;
import com.zhilian.api.customer.dto.response.CommonUserResDTO;
import com.zhilian.common.model.PageResult;
import com.zhilian.customer.model.domain.CommonUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 */
public interface ICommonUserService extends IService<CommonUser> {

    CommonUser findByOpenId(String openId);

    /**
     * 分页查询
     *
     * @param commonUserPageQueryReqDTO 查询条件
     * @return 分页结果
     */
    PageResult<CommonUserResDTO> page(CommonUserPageQueryReqDTO commonUserPageQueryReqDTO);

    /**
     * 更新用户电话
     *
     * @param phoneCode 微信手机号授权码
     */
    void updatePhone(String phoneCode);

    /**
     * 更新状态
     *
     * @param commonUserUpdateReqDTO 更新信息
     */
    void updateStatus(CommonUserUpdateReqDTO commonUserUpdateReqDTO);
}
