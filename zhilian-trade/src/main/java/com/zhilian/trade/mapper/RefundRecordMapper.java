package com.zhilian.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.trade.model.domain.RefundRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款记录表Mapper接口
 */
@Mapper
public interface RefundRecordMapper extends BaseMapper<RefundRecord> {

}
