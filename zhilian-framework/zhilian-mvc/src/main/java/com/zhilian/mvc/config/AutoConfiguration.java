package com.zhilian.mvc.config;

import com.zhilian.mvc.handler.RequestIdHandlerImpl;
import com.zhilian.mvc.handler.UserInfoHandlerImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RequestIdHandlerImpl.class, UserInfoHandlerImpl.class})
public class AutoConfiguration {
}
