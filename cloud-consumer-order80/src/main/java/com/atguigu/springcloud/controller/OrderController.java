package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Beaco
 */
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    /**负载均衡方式访问*/
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-PROVIDER";


    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/consumer/savePayment")
    public CommonResult<Payment> savePayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/savePayment", payment, CommonResult.class);
    }

    @GetMapping("/consumer/selectPaymentById/{id}")
    public CommonResult<Payment> selectPaymentById(@PathVariable("id") Long paymentId) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/selectPaymentById/" + paymentId, CommonResult.class);
    }
}
