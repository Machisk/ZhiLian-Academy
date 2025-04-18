package com.zhilian.common.expcetions;

import static com.zhilian.common.constants.ErrorInfo.Msg.PROCESS_FAILD;
import static java.net.HttpURLConnection.HTTP_SERVER_ERROR;

/**
 * 服务器异常
 *
 */
public class ServerErrorException extends CommonException {

    public ServerErrorException() {
        this(PROCESS_FAILD);
    }

    public ServerErrorException(String message) {
        super(HTTP_SERVER_ERROR, message);
    }

    public ServerErrorException(Throwable throwable, String message) {
        super(throwable, HTTP_SERVER_ERROR, message);
    }

    public ServerErrorException(Throwable throwable) {
        super(throwable, HTTP_SERVER_ERROR, PROCESS_FAILD);
    }

}
