package com.zhilian.common.expcetions;

import com.zhilian.common.constants.ErrorInfo;

/**
 * 禁止操作异常
 *
 */
public class ForbiddenOperationException extends CommonException {

    public ForbiddenOperationException() {
        this(ErrorInfo.Msg.FORBIDDEN_OPERATION);
    }

    public ForbiddenOperationException(String message) {
        super(ErrorInfo.Code.FORBIDDEN_OPERATION, message);
    }

    public ForbiddenOperationException(Throwable throwable, String message) {
        super(throwable, ErrorInfo.Code.FORBIDDEN_OPERATION, message);
    }

    public ForbiddenOperationException(Throwable throwable) {
        super(throwable, ErrorInfo.Code.FORBIDDEN_OPERATION, ErrorInfo.Msg.FORBIDDEN_OPERATION);
    }

}
