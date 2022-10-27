package com.springclund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain04 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain04.class,args);
    }
}
