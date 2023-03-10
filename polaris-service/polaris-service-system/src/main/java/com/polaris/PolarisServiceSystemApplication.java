package com.polaris;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan("com.polaris.*.*.mapper")
@SpringBootApplication
public class PolarisServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolarisServiceSystemApplication.class,args);
    }
}
