package com.ztt.config;

import com.ztt.domain.User;
import com.ztt.repository.UserRepository;
import com.ztt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

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
     * 既可以支持servlet3.0规范，也可以支持Netty 等
     * Flux 是0-N个对象集合
     * Mono是0-1个对象集合
     * Reactive中的Flux或者 Mono 都是异步处理(非阻塞)
     * 集合对象基本上是同步处理(阻塞)
     * Flux 或者Mono 都是Publisher(发布器)
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> persons(UserService userService, UserRepository userRepository) {//spring 4种注入方式？
        RouterFunctionConfiguration handler = new RouterFunctionConfiguration();
        return route(RequestPredicates.GET("/persons"),
                    request ->{//lambda表达式
                        List<User> users = userRepository.findAll();
                        //Stream<User> userStream = users.stream();
                        //Flux<User> userFlux = Flux.fromStream(userStream);
                        Flux<User> userFlux = Flux.fromIterable(users);
                        return ServerResponse.ok().body(userFlux, User.class);
                    }).and(
                        route(RequestPredicates.GET("/persons/{uid}"),
                            request ->{//lambda表达式
                                String uid = request.pathVariable("uid");
                                //request.queryParam("uid");
                                User user = userRepository.findById(Long.valueOf(uid));
                                Mono<User> userMono = Mono.just(user);
                                return ServerResponse.ok().body(userMono, User.class);
                        })
                    ).and(
                        route(RequestPredicates.DELETE("/persons/{uid}"),
                            request ->{//lambda表达式
                                String uid = request.pathVariable("uid");
                                //request.queryParam("uid");
                                User user = userRepository.delById(Long.valueOf(uid));
                                return ServerResponse.ok().body(Mono.just(user), User.class);
                        })
                    ).and( //未实现
                        route(RequestPredicates.PUT("/persons/{uid}"),
                                request ->{//lambda表达式
                                    String uid = request.pathVariable("uid");
                                    //request.queryParam("uid");
                                    User user = userRepository.update(Long.valueOf(uid));
                                    return ServerResponse.ok().body(Mono.just(user), User.class);
                                })
                    ).and( //未实现
                        route(POST("/persons").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                                request ->{//lambda表达式
                                    Mono<User> addUser = request.bodyToMono(User.class);
                                    User user = userService.save(addUser.block().getName());
                                    return ServerResponse.ok().body(Mono.just(user), User.class);
                                })
                    ).filter((request, next) -> {
                        System.out.println("Before handler invocation: " + request.path());
                        Mono<ServerResponse> response = next.handle(request);
                        System.out.println("After handler invocation: " + response);
                        return response;
                    });
    }

}
