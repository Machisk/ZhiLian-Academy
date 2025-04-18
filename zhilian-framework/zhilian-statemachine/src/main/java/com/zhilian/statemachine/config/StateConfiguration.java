package com.zhilian.statemachine.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 状态机配置
 *
 **/
@ComponentScan(value = {"com.zhilian.statemachine"})
public class StateConfiguration {

    /**
     * 用于状态机持久化的mapper初始化为bean
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.zhilian.statemachine.mapper");
        return mapperScannerConfigurer;
    }
}
