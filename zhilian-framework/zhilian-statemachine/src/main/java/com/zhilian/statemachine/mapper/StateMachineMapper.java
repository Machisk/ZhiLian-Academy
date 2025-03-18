package com.zhilian.statemachine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.statemachine.model.StatePersister;
import org.apache.ibatis.annotations.Mapper;

/**
 * 状态持久化数据层
 *
 **/
@Mapper
public interface StateMachineMapper extends BaseMapper<StatePersister> {
}
