package com.polaris;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@MapperScan("com.polaris.*.*.mapper")
@SpringBootApplication
public class PolarisServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolarisServiceSystemApplication.class,args);
    }
}
