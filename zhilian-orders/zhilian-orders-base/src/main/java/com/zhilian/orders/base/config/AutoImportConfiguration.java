package com.zhilian.orders.base.config;

import com.zhilian.orders.base.properties.DispatchProperties;
import com.zhilian.orders.base.properties.ExecutorProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.zhilian.orders.base.service","com.zhilian.orders.base.handler"})
@MapperScan("com.zhilian.orders.base.mapper")
@Import({OrderStateMachine.class})
@EnableConfigurationProperties({DispatchProperties.class, ExecutorProperties.class})
public class AutoImportConfiguration {
}
