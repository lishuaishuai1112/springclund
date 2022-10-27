package com.springclund.controller;

import com.springclund.pojo.CommonResult;
import com.springclund.pojo.Payment;
import com.springclund.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/customer")
@RestController
public class CustomerController {
    @Value("${spring.application.name}")
    private String applicationName;
    //调用支付订单服务端的ip+端口号
    //public static final  String PAYMENT_URL = "http://localhost:8084/boc-provide-api";
    @Autowired
    private CustomerService customerService;
    @GetMapping("/queryCountCustomer")
    public String queryCountCustomer(){
        return ""+customerService.queryCustomer();
    }
    @Autowired
    private RestTemplate restTemplate;
    //创建支付订单的接口
    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        ///payment/get/
 return restTemplate.getForObject("http://mcroserviceprovide/payment/get/"+2,CommonResult.class);
     //  return restTemplate.postForObject("http://mcroserviceprovide/payment/create/",payment, CommonResult.class);
    }
    //获取id获取支付订单
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://mcroserviceprovide-PROVIDE/payment/get/"+id,CommonResult.class);
    }
}
