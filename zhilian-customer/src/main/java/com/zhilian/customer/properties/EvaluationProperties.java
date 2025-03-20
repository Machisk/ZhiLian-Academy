package com.zhilian.customer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "zhilian.evaluation")
public class EvaluationProperties {
    private String appId;
    private String accessKeyId;
    private String accessKeySecret;

    /**
     * 域名或ip
     */
    private String domain;

    /**
     * 服务项
     */
    private EvaluationTargetProperties serveItem;

    /**
     * 师傅
     */
    private EvaluationTargetProperties serveProvider;
}
