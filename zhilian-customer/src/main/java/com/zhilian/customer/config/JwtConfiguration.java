package com.zhilian.customer.config;

import com.zhilian.common.utils.JwtTool;
import com.zhilian.customer.properties.ApplicationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class JwtConfiguration {

    @Resource
    private ApplicationProperties applicationProperties;

    @Bean
    public JwtTool jwtTool() {
        return new JwtTool(applicationProperties.getJwtKey());
    }
}
