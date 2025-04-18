package com.zhilian.publics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 通用服务启动类
 *
 **/
@Slf4j
@SpringBootApplication
public class PublicsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PublicsApplication.class)
                .build(args)
                .run(args);
        log.info("智联学堂-通用服务启动");
    }
}
