package com.polaris;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@MapperScan("com.polaris.*.*.mapper")
@EnableFeignClients(basePackages = "com.polaris")
@SpringBootApplication
public class PolarisServiceSystemOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolarisServiceSystemOneApplication.class,args);
    }
}
