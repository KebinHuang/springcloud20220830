package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;//配置文件获取端口号

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){//@RequestBody 用来接收前端传递给后端的json字符串中的数据
        //插入成功返回int类型
        int result = paymentService.create(payment);
        log.info("*********插入数据:"+result);
        //返回CommonResult数据类型
        if(result>0){
            return new CommonResult(200,"插入成功,返回结果"+result+"服务端口为:"+serverPort,payment);
        }else{
            return new CommonResult(201,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);

        //返回CommonResult数据类型
        if(paymentById!=null){
            return new CommonResult(200,"查询成功,服务端口为:"+serverPort,paymentById);
        }else{
            return new CommonResult(201,"没有对应记录,查询ID"+id,null);
        }
    }
}
