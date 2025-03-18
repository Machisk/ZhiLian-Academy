package com.zhilian.foundations.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhilian.foundations.model.domain.Operator;
import com.zhilian.foundations.model.dto.OperatorAddDTO;

/**
 * <p>
 * 运营人员 服务类
 * </p>
 *
 */
public interface IOperatorService extends IService<Operator> {

    /**
     * 根据名称查询运营人员
     *
     * @param username 名称
     * @return 运营人员
     */
    Operator findByUsername(String username);

    /**
     * 新增运营人员
     *
     * @param operatorAddDTO 运营人员新增模型
     */
    void add(OperatorAddDTO operatorAddDTO);
}
