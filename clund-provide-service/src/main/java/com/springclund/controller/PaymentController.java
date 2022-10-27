package com.springclund.controller;

import com.springclund.pojo.CommonResult;
import com.springclund.pojo.Payment;
import com.springclund.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    //注入服务发现的注解
    @Autowired
    private DiscoveryClient discoveryClient;
    private static Logger logger= LoggerFactory.getLogger(PaymentController.class);
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment dept){
        int i = paymentService.create(dept);
        logger.info("***************插入成功*******"+i);
        if(i>0){
            CommonResult commonResult=new CommonResult<>(200,"",null);
            return new CommonResult<>(200,"插入数据库成功",i);
        }else{
            return new CommonResult(201,"插入数据库失败",null);
        }
    }
    @GetMapping("/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        List<String>lists=discoveryClient.getServices();
        for(String services:lists){
            logger.info("********注册到eureka中的服务中有:"+services);
        }
        List<ServiceInstance> serviceInstanceList=discoveryClient.getInstances("mcroserviceprovide");
        for(ServiceInstance serviceInstance:serviceInstanceList){
            logger.info("当前服务实例有"+serviceInstance.getInstanceId()+"域名"+serviceInstance.getHost()+"端口"+serviceInstance.getPort());
        }
        logger.info("");
        logger.info("***************查询成功*********"+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(444,"查询失败",null);
        }
    }
}
