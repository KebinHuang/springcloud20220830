package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@DefaultProperties(defaultFallback = "Global_paymentInfo_TimeOutHandler")
public class OrderHystrixController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/hystrix/OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_OK(id);
    }


    @GetMapping("/consumer/payment/hystrix/TimeOut/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })//服务降级机制,当服务超出预期时间的时候,会跳转到指定的方法
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
//        int a = 10/0;//2.设置计算情况
        String result = paymentFeignService.paymentInfo_TimeOut(id);

        return result;
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "woshi消费者80:连接超时";
    }
    public String Global_paymentInfo_TimeOutHandler(){
        return "全局超时";
    }
}
