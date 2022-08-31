package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentFeignService  paymentFeignServicel;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        //通过消费者的http请求，来调用Feign接口，再跳转到Feign接口的服务名相对应的服务
        return paymentFeignServicel.getPaymentById(id);
    }
    @GetMapping("/consumer/payment/fegin/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignServicel.paymentFeignTimeout();
    }
}
