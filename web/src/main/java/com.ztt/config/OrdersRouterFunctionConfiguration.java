package com.ztt.config;

import com.ztt.domain.Orders;
import com.ztt.domain.User;
import com.ztt.repository.UserRepository;
import com.ztt.service.OrdersService;
import com.ztt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by zhangtietuo on 2018/4/17.
 * 路由器函数 配置
 */
@Configuration
public class OrdersRouterFunctionConfiguration {

    /**
     * Servlet 请求接口：ServletRequest 或者 HttpServletRequest
     * spring5.0 请求接口: ServerRequest
     * 响应接口亦如此
     * 既可以支持servlet3.0规范，也可以支持Netty 等
     * Flux 是0-N个对象集合
     * Mono是0-1个对象集合
     * Reactive中的Flux或者 Mono 都是异步处理(非阻塞)
     * 集合对象基本上是同步处理(阻塞)
     * Flux 或者Mono 都是Publisher(发布器)
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> orders(OrdersService ordersService) {//spring 4种注入方式？
        OrdersRouterFunctionConfiguration handler = new OrdersRouterFunctionConfiguration();
        return route(RequestPredicates.GET("/orders"),
                    request ->{//lambda表达式
                        List<Orders> orders = ordersService.findAll();
                        //Stream<User> userStream = users.stream();
                        //Flux<User> userFlux = Flux.fromStream(userStream);
                        Flux<Orders> ordersFlux = Flux.fromIterable(orders);
                        return ServerResponse.ok().body(ordersFlux, Orders.class);
                    });
    }

}
