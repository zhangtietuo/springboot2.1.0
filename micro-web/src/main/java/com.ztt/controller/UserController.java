package com.ztt.controller;

import com.ztt.domain.User;
import com.ztt.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.UUID;

/**
 * Created by zhangtietuo on 2018/4/17.
 */
@RestController
public class UserController implements InitializingBean, BeanFactoryAware {

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

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    @Autowired
    User user;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String index() {
        Jedis jedis = new Jedis("localhost", 6379);
        //jedis.auth("");
        jedis.select(15);
        String value = jedis.set("aaa", UUID.randomUUID().toString(), SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 10000);
        return "你好,docker";
    }

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
        log.debug("RequestBody");
        log.info("{},{},{},{},{},{}", manSize, manAge, content, id, nickname, name);
        log.info("user.id:{},user.name:{}", user.getId(), user.getName());
        log.info("当前时间为：{}", new Date());
        return userService.save(user);
    }

    @PostMapping("/dologin")
    public String dologin(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        if (subject.hasRole("admin")) {
            return "admin";
        }


        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
