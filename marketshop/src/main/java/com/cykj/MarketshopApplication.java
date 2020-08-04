package com.cykj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
public class MarketshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketshopApplication.class, args);
    }

}
