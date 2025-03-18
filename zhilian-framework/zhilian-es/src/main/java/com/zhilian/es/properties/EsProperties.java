package com.zhilian.es.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "zhilian.es")
@Data
public class EsProperties {
    /**
     * es host
     */
    private String host;
    /**
     * es 端口
     */
    private Integer port;
}
