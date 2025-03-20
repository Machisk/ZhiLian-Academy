package com.zhilian.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.trade.model.domain.Trading;
import org.apache.ibatis.annotations.Mapper;

/**
 * 交易订单表Mapper接口
 */
@Mapper
public interface TradingMapper extends BaseMapper<Trading> {

}
