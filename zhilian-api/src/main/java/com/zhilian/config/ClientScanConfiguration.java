package com.zhilian.config;

import com.zhilian.common.handler.RequestIdHandler;
import com.zhilian.common.handler.UserInfoHandler;
import com.zhilian.interceptor.FeignInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@EnableFeignClients(basePackages = "com.zhilian.api")
@Import({com.zhilian.utils.MyQueryMapEncoder.class})
@ConditionalOnProperty(prefix = "feign", name = "enable", havingValue = "true")
public class ClientScanConfiguration {

    @Bean
    public FeignInterceptor feignInterceptor(UserInfoHandler userInfoHandler, RequestIdHandler requestIdHandler){
        return new FeignInterceptor(userInfoHandler, requestIdHandler);
    }


}
