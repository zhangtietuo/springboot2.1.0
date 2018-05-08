package com.ztt.controller;

import com.ztt.domain.User;
import com.ztt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangtietuo on 2018/4/17.
 */
@RestController
public class UserController {

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @PostMapping("/person/save")
    public User save(@RequestParam String name) {
        return userService.save(name);
    }

}
