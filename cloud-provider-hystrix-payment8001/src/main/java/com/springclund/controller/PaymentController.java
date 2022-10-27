package com.springclund.controller;

import com.springclund.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;
    private Logger logger= LoggerFactory.getLogger(PaymentController.class);
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        logger.info("*******************result:" + result);
        return result;
    }
    @GetMapping("/payment/get/ok/{id}")
    public String get_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        logger.info("*******************result:" + result);
        return result;
    }
    @GetMapping("/payment/lb/ok/{id}")
    public String lb_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        logger.info("*******************result:" + result);
        return result;
    }
    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        logger.info("*********************result:" + result);
        return result;

    }
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }
}
