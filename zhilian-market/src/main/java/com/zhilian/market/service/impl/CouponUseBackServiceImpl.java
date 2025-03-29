package com.zhilian.market.service.impl;

import com.zhilian.common.utils.DateUtils;
import com.zhilian.common.utils.IdUtils;
import com.zhilian.market.model.domain.CouponUseBack;
import com.zhilian.market.mapper.CouponUseBackMapper;
import com.zhilian.market.service.ICouponUseBackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * 优惠券使用回退记录 服务实现类
 * </p>
 *
 * @author itcast
 * @since 2023-09-18
 */
@Service
public class CouponUseBackServiceImpl extends ServiceImpl<CouponUseBackMapper, CouponUseBack> implements ICouponUseBackService {

}
