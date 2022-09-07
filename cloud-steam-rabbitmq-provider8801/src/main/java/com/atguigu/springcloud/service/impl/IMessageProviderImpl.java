package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class) //定义消息推送的通道
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output; //消息发送的通道

    @Override
    public String Send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());//将消息发送通道
        System.out.println(serial);
        return null;
    }
}
