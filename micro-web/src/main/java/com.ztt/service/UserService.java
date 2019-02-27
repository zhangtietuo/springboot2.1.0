package com.ztt.service;

import com.ztt.domain.User;

/**
 * Created by zhangtietuo on 2018/4/17.
 */
public interface UserService {

    User save(String name);

    User save(User user);
}
