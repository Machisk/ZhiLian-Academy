package com.zhilian.statemachine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.statemachine.model.BizSnapshot;
import org.apache.ibatis.annotations.Mapper;

/**
 * 业务数据快照数据层
 *
 **/
@Mapper
public interface BizSnapshotMapper extends BaseMapper<BizSnapshot> {
}
