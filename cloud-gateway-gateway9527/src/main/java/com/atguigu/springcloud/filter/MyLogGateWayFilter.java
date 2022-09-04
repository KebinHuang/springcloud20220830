package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //exchange表示对象，chain表示放行
        log.info("come in MyLogGateWayFilter"+new Date());//获取现在的时间
        //getRequest:获取请求头的信息,getQueryParams:获取请求参数,getFirst:获取请求的第一个Key
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if(name==null){
            log.info("非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//返回响应信息
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);//放行exchange对象
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
