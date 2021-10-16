package com.ztt.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/28 10:45
 */
@Component
public class CustomerGlobalGatewayFilter implements GlobalFilter, Ordered {

    static Logger log = LoggerFactory.getLogger(CustomerGlobalGatewayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("======================进入CustomerGlobalGatewayFilter======================{}", exchange.getRequest().getURI());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
