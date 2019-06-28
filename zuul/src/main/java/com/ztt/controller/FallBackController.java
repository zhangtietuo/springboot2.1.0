package com.ztt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/6/28 10:24
 */
@RestController
public class FallBackController {
    @RequestMapping("/user/fallback")
    public Mono<String> fallback() {
        return Mono.just("service error, jump fallback");
    }
}
