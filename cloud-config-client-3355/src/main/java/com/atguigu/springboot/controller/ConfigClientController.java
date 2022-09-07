package com.atguigu.springboot.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //提供动态刷新
public class ConfigClientController {
    @Value("${config.info}")//将3344里获取git里面的配置文件的信息获取过来
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
