package com.zyf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.zyf.dao")
@EnableCaching //开启redis缓存
public class ZyfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZyfApplication.class, args);
    }

}
