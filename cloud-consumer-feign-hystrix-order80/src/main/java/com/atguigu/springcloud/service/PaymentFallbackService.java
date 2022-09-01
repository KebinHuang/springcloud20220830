package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "Ok挂了";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "TimeOut挂了";
    }
}
