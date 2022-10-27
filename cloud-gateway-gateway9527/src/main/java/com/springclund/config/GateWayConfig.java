package com.springclund.config;

import com.springclund.filter.MyLogGatewatFilter2;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置了一个id为routr-name的路由规则
 * 当访问地址http://localhost:9527/guonei时会自动转发到http://news.baidu.com/guonei
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("patn_route_buba", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("patn_route_taobao", r -> r.path("/taobao").uri("http://www.taobao.com"));
        return routes.build();
    }

    @Bean
    public MyLogGatewatFilter2 MyLogGatewatFilter() {
        return new MyLogGatewatFilter2();
    }
}
