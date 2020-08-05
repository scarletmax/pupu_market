package com.cykj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.cykj.marketuser"})
public class MarketuserApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketuserApplication.class, args);
    }

}
