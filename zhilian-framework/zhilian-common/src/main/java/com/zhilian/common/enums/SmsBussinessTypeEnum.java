package com.zhilian.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SmsBussinessTypeEnum {
    INSTITION_REGISTER(1), INSTITUTION_RESET_PASSWORD(2), SERVE_STAFF_LOGIN(3);

    private int type;
}
