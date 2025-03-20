package com.zhilian.common.expcetions;

import com.zhilian.common.constants.ErrorInfo;

import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;

/**
 * 服务不可用，注册中心找不到对应服务
 *
 */
public class ServerUnavailableException extends CommonException {
    public ServerUnavailableException() {
        this(ErrorInfo.Msg.PROCESS_FAILD);
    }

    public ServerUnavailableException(String message) {
        super(HTTP_UNAVAILABLE, message);
    }

    public ServerUnavailableException(Throwable throwable, String message) {
        super(throwable, HTTP_UNAVAILABLE, message);
    }

    public ServerUnavailableException(Throwable throwable) {
        super(throwable, HTTP_UNAVAILABLE, ErrorInfo.Msg.PROCESS_FAILD);
    }
}
