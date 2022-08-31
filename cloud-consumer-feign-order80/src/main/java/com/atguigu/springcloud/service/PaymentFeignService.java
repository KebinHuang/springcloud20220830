package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//通过服务名去调用相对于的服务
public interface PaymentFeignService {
    //从80的服务跳转到调用CLOUD-PAYMENT-SERVICE服务名的服务
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
    //暂停几秒服务
    @GetMapping("/payment/fegin/timeout")
    public String paymentFeignTimeout();


}
