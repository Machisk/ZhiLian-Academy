package com.zhilian.customer;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@Slf4j
@EnableCaching
@MapperScan("com.zhilian.customer.mapper")
public class CustomerApplicaiton {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CustomerApplicaiton.class)
                .build(args)
                .run(args);
        log.info("智联学堂-客户中心启动");
    }
}
