package com.zhilian.redis.config;

import com.zhilian.redis.properties.RedisSyncProperties;
import com.zhilian.redis.sync.impl.SyncManagerImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties(RedisSyncProperties.class)
@Import(SyncManagerImpl.class)
public class RedisQueueSyncConfiguration {
}
