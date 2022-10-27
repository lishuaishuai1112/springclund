package com.springclund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerMain02 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain02.class,args);
    }
}
