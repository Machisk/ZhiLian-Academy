package com.zhilian.customer.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhilian.api.customer.dto.request.CommonUserPageQueryReqDTO;
import com.zhilian.api.customer.dto.request.CommonUserUpdateReqDTO;
import com.zhilian.api.customer.dto.response.CommonUserResDTO;
import com.zhilian.api.orders.OrdersApi;
import com.zhilian.api.publics.WechatApi;
import com.zhilian.api.publics.dto.response.PhoneResDTO;
import com.zhilian.common.model.PageResult;
import com.zhilian.customer.mapper.CommonUserMapper;
import com.zhilian.customer.model.domain.CommonUser;
import com.zhilian.customer.service.ICommonUserService;
import com.zhilian.mvc.utils.UserContext;
import com.zhilian.mysql.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 */
@Service
public class CommonUserServiceImpl extends ServiceImpl<CommonUserMapper, CommonUser> implements ICommonUserService {
    @Resource
    private CommonUserMapper commonUserMapper;
    @Resource
    private WechatApi wechatApi;
    @Resource
    private OrdersApi ordersApi;

    @Override
    public CommonUser findByOpenId(String openId) {
        return lambdaQuery().eq(CommonUser::getOpenId, openId)
                .one();
    }

    /**
     * 分页查询
     *
     * @param commonUserPageQueryReqDTO 查询条件
     * @return 分页结果
     */
    @Override
    public PageResult<CommonUserResDTO> page(CommonUserPageQueryReqDTO commonUserPageQueryReqDTO) {
        //1.分页查询用户
        Page<CommonUser> page = PageUtils.parsePageQuery(commonUserPageQueryReqDTO, CommonUser.class);
        LambdaQueryWrapper<CommonUser> queryWrapper = Wrappers.<CommonUser>lambdaQuery()
                .eq(ObjectUtil.isNotEmpty(commonUserPageQueryReqDTO.getNickname()), CommonUser::getNickname, commonUserPageQueryReqDTO.getNickname())
                .eq(ObjectUtil.isNotEmpty(commonUserPageQueryReqDTO.getPhone()), CommonUser::getPhone, commonUserPageQueryReqDTO.getPhone());
        Page<CommonUser> commonUserPage = commonUserMapper.selectPage(page, queryWrapper);

        //3.封装数据
        return PageUtils.toPage(commonUserPage, CommonUserResDTO.class);
    }

    /**
     * 更新用户电话
     *
     * @param phoneCode 微信手机号授权码
     */
    @Override
    public void updatePhone(String phoneCode) {
        PhoneResDTO phoneResDTO = wechatApi.getPhone(phoneCode);

        CommonUser commonUser = new CommonUser();
        commonUser.setId(UserContext.currentUserId());
        commonUser.setPhone(phoneResDTO.getPhone());
        commonUserMapper.updateById(commonUser);
    }

    /**
     * 更新状态
     *
     * @param commonUserUpdateReqDTO 更新信息
     */
    @Override
    public void updateStatus(CommonUserUpdateReqDTO commonUserUpdateReqDTO) {
        CommonUser commonUser = BeanUtil.toBean(commonUserUpdateReqDTO, CommonUser.class);
        commonUserMapper.updateById(commonUser);
    }
}
