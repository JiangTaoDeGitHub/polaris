package com.polaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PolarisGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PolarisGatewayApplication.class,args);
    }
}
