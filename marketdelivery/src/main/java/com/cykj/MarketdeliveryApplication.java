package com.cykj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.Executors;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.cykj.marketdelivery"})
public class MarketdeliveryApplication {


    public static void main(String[] args) {
        SpringApplication.run(MarketdeliveryApplication.class, args);
    }

}
