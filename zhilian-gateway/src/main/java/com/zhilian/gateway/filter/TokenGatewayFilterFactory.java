package com.zhilian.gateway.filter;

import com.zhilian.gateway.properties.ApplicationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    @Resource
    private ApplicationProperties applicationProperties;

    public TokenGatewayFilterFactory() {
    }

    @Override
    public GatewayFilter apply(Object config) {
        return new TokenFilter(applicationProperties);
    }
}
