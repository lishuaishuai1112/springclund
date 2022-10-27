package com.springclund.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

public class MyLogGatewatFilter2 implements GlobalFilter, Ordered {
   private static Logger logger= LoggerFactory.getLogger(MyLogGatewatFilter2.class);
    //你要访问我时候需要一个指定的用户名才能进行访问，
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("************come in MyLogGatewatFilter "+ new Date());
        String name=exchange.getRequest().getQueryParams().getFirst("name");
        if(name==null){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //合法用户进行下一个过滤链进行过滤验证
        return chain.filter(exchange);

    }
    //这个0数字代表加载过滤器的顺序，就是越小优先级越高，因为是全局的，所以必须是第一位的。
    @Override
    public int getOrder() {
        return 0;
    }
}
