package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;//实现对象对rest风格的调用方法

    //public static final String PAYMENT_URL = "http://localhost:8001/";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

//    @GetMapping("/consumer/payment/create")
//    public CommonResult<Payment> create(Payment payment){
//        //通过请求调用8001端口的请求
//        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
//    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        //forObject返回的是json字符串
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        //ForEntity返回的是CommonResult的结果集
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();//获取forEntity的详细信息
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

}
