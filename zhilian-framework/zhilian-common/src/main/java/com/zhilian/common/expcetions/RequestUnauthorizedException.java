package com.zhilian.common.expcetions;

import com.zhilian.common.constants.ErrorInfo;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

/**
 * 身份校验异常，错误码401
 * 使用场景：网关校验token，token不合法或token过期
 *
 */
public class RequestUnauthorizedException extends CommonException {

    public RequestUnauthorizedException() {
        this(ErrorInfo.Msg.REQUEST_UNAUTHORIZED);
    }

    public RequestUnauthorizedException(String message) {
        super(HTTP_UNAUTHORIZED, message);
    }

    public RequestUnauthorizedException(Throwable throwable, String message) {
        super(throwable, HTTP_UNAUTHORIZED, message);
    }
    public RequestUnauthorizedException(Throwable throwable) {
        super(throwable, HTTP_UNAUTHORIZED, ErrorInfo.Msg.REQUEST_UNAUTHORIZED);
    }


}
