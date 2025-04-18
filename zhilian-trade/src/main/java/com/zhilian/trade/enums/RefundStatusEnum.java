package com.zhilian.trade.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 退款状态枚举
 *
 */
public enum RefundStatusEnum {

    APPLY_REFUND(0, "发起退款"),
    SENDING(1, "退款中"),
    SUCCESS(2, "成功"),
    FAIL(3, "失败");

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String value;

    RefundStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }
}
