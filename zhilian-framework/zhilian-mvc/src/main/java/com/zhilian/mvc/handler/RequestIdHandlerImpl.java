package com.zhilian.mvc.handler;

import cn.hutool.core.util.IdUtil;
import com.zhilian.common.constants.HeaderConstants;
import com.zhilian.common.handler.RequestIdHandler;
import com.zhilian.common.model.CurrentUserInfo;
import com.zhilian.common.utils.StringUtils;
import com.zhilian.mvc.utils.RequestUtils;
import com.zhilian.mvc.utils.UserContext;
import org.springframework.stereotype.Component;

@Component
public class RequestIdHandlerImpl implements RequestIdHandler {
    @Override
    public String getRequestId() {
        // 从请求header头中获取请求id,获取不到id，生成新的请求id
        CurrentUserInfo currentUserInfo = UserContext.currentUser();
        if(currentUserInfo == null) {
            return null;
        }
        String requestId = RequestUtils.getValueFromHeader(HeaderConstants.REQUEST_ID);
        if (StringUtils.isEmpty(requestId)) {
            return IdUtil.getSnowflakeNextIdStr();
        } else {
            return requestId;
        }
    }
}
