package com.ztt.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/28 10:58
 */
@Component
public class CustomerGatewayFilterFactory extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        System.out.println("asdsadsadsad");
        return null;
    }
}
