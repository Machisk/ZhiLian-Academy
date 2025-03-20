package com.zhilian.trade;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@MapperScan("com.zhilian.trade.mapper")
@SpringBootApplication
public class TradeApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TradeApplication.class)
                .build(args)
                .run(args);
        log.info("智联学堂-支付服务启动");
    }
}
