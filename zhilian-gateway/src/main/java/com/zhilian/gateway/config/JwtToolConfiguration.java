package com.zhilian.gateway.config;

import cn.hutool.extra.spring.SpringUtil;
import com.zhilian.common.utils.JwtTool;
import com.zhilian.gateway.properties.ApplicationProperties;
import com.zhilian.gateway.constants.UserConstants;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * 生成多个token解析器
 */
@Configuration
public class JwtToolConfiguration {

    @Resource
    private ApplicationProperties applicationProperties;

    /**
     * 初始化JwtTool
     */
    @PostConstruct
    public void initJwtTools() {
        for (Map.Entry<String, String> entry : applicationProperties.getTokenKey().entrySet()) {
            String beanName = UserConstants.JWT_TOKEN_BEAN_NAME + entry.getKey();
            JwtTool jwtTool = new JwtTool(entry.getValue());
            SpringUtil.registerBean(beanName, jwtTool);
        }
    }

}
