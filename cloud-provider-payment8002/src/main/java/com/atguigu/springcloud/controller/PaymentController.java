package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/selectPaymentById/{paymentId}")
    public CommonResult<Payment> selectPaymentById(@PathVariable("paymentId") Long paymentId) {
        Payment payment = paymentService.selectPaymentById(paymentId);
        return new CommonResult<>(200, "ok,server port is " + serverPort, payment);
    }


    @PostMapping("/savePayment")
    public CommonResult savePayment(@RequestBody Payment payment) {
        int row = paymentService.save(payment);
        if (row == 1) {
            return new CommonResult<>(200, "插入数据库成功 server port is "+ serverPort);
        } else {
            return new CommonResult<>(400, "失败 server port is"+serverPort);
        }
    }
}
