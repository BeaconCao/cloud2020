package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;

public interface PaymentService {
    int save(Payment payment);

    Payment selectPaymentById(Long paymentId);
}
