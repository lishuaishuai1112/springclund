package com.springclund.service;

import com.springclund.pojo.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment queryById(long id);
}
