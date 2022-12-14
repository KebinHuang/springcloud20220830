package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PamentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result =paymentService.paymentInfo_OK(id);
        return result;
    }
    @GetMapping("/payment/hystrix/TimeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result =paymentService.paymentInfo_TimeOut(id);
        return result;
    }
    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }
}
