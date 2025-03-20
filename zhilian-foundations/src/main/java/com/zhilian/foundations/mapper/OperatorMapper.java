package com.zhilian.foundations.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhilian.foundations.model.domain.Operator;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 运营人员 Mapper 接口
 * </p>
 *
 */
public interface OperatorMapper extends BaseMapper<Operator> {

    @Select("select * from operator")
    List<Operator> queryAll();
}
