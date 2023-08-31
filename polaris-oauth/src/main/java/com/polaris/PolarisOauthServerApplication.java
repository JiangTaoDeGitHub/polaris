package com.polaris;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


//对外开启暴露获取token的API接口
@MapperScan("com.polaris.mapper")
@EnableResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class PolarisOauthServerApplication {


    public static void main(String[] args) {

        SpringApplication.run(PolarisOauthServerApplication.class, args);
    }
}
