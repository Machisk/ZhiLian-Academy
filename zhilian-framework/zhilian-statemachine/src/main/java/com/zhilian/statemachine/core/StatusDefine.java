package com.zhilian.statemachine.core;

/**
 * 状态抽象接口
 *
 */
public interface StatusDefine {

    /**
     * @return 返回状态编号
     */
    Integer getStatus();

    /**
     * @return 返回状态描述
     */
    String getDesc();

    /**
     * @return 返回状态代码
     */
    String getCode();
}
