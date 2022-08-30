package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    //引入RestTemplate对象，来实现httpclient作用的连接
    @Bean
    @LoadBalanced //开启负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
