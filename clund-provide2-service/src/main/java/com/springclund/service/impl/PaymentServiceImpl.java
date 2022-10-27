package com.springclund.service.impl;

import com.springclund.mapper.PaymentMapper;
import com.springclund.pojo.Payment;
import com.springclund.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment queryById(long id) {
        return paymentMapper.queryById(id);
    }
}
