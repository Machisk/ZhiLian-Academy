package com.zhilian.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.trade.model.domain.PayChannel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 交易渠道表Mapper接口
 */
@Mapper
public interface PayChannelMapper extends BaseMapper<PayChannel> {

}
