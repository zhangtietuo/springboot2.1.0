package com.ztt.config;

import com.ztt.domain.User;
import com.ztt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by zhangtietuo on 2018/4/17.
 * 路由器函数 配置
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet 请求接口：ServletRequest 或者 HttpServletRequest
     * spring5.0 请求接口: ServerRequest
     * 响应接口亦如此
     * 既可以支持servlet规范，也可以支持Netty 等
     * Flux 是0-N个对象集合
     * Mono是0-1个对象集合
     * Reactive中的Flux或者 Mono 都是异步处理(非阻塞)
     * 集合对象基本上是同步处理(阻塞)
     * Flux 或者Mono 都是Publisher(发布器)
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {//spring 4种注入方式？
        return RouterFunctions.route(RequestPredicates.GET("/person/findAll"),
                request ->{//lambda表达式
                    List<User> users = userRepository.findAll();//java collection集合接口？
                    Mono<ServerResponse> response = null;
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }
}
