package com.zhilian.customer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CertificationStatusEnum {
    INIT(0, "初始态"),
    PROGRESSING(1, "认证中"),
    SUCCESS(2, "认证成功"),
    FAIL(3, "认证失败");

    /**
     * 状态值
     */
    private final int status;

    /**
     * 描述
     */
    private final String description;
}
