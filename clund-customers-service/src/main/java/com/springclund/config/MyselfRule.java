package com.springclund.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义负载均衡算法
//启动类加注解@RibbonClient 指定负载均衡类
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        // 定义为随机
        return new RoundRobinRule();
    }
}
