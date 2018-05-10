package com.ztt.controller;

import com.ztt.domain.User;
import com.ztt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by zhangtietuo on 2018/4/17.
 */
@RestController
public class UserController {

    @Value("${manSize}")
    private Integer manSize;

    @Value("${manAge}")
    private Integer manAge;

    @Value("${content}")
    private String content;

    @Value("${user.id}")
    private Integer id;

    @Value("${user.nickname}")
    private String nickname;

    @Value("${user.name}")
    private String name;

    @Autowired
    User user;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping("/persons")
    public User save(@RequestParam String username) {
        log.info("RequestParam");
        log.info("{},{},{},{},{},{}", manSize, manAge, content, id, nickname, name);
        log.info("user.id:{},user.name:{}", user.getId(), user.getName());
        log.info("当前时间为：{}", new Date());
        return userService.save(username);
    }

    @PostMapping("/persons1")
    public User save(@RequestBody User user) {
        log.info("RequestBody");
        log.info("{},{},{},{},{},{}", manSize, manAge, content, id, nickname, name);
        log.info("user.id:{},user.name:{}", user.getId(), user.getName());
        log.info("当前时间为：{}", new Date());
        return userService.save(user);
    }

}
