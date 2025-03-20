package com.zhilian.foundations.config;

import com.zhilian.common.utils.JwtTool;
import com.zhilian.foundations.properties.ApplicaitonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class JwtConfiguration {

    @Resource
    private ApplicaitonProperties applicaitonProperties;

    @Bean
    public JwtTool jwtTool() {
        return new JwtTool(applicaitonProperties.getJwtKey());
    }
}
