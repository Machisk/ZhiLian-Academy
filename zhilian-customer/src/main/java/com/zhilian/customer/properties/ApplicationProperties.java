package com.zhilian.customer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "zhilian")
@Configuration
@Data
public class ApplicationProperties {

    private String jwtKey;
}
