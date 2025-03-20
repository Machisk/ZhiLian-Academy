package com.zhilian.mvc.handler;

import com.zhilian.common.handler.UserInfoHandler;
import com.zhilian.common.model.CurrentUserInfo;
import com.zhilian.mvc.utils.UserContext;
import org.springframework.stereotype.Component;

@Component
public class UserInfoHandlerImpl implements UserInfoHandler {
    @Override
    public CurrentUserInfo currentUserInfo() {
        return UserContext.currentUser();
    }
}
