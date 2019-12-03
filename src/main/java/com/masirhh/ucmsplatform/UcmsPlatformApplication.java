package com.masirhh.ucmsplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.masirhh.ucmsplatform.mapper")
@SpringBootApplication
public class UcmsPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcmsPlatformApplication.class, args);
    }

}
