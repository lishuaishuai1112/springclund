package com.springclund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class Payments2Main {
    public static void main(String[] args) {
        SpringApplication.run(Payments2Main.class,args);
    }
}
