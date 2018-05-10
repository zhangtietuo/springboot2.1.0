package com.ztt.service.impl;

import com.ztt.domain.User;
import com.ztt.repository.UserRepository;
import com.ztt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zhangtietuo on 2018/4/17.
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(String name) {
        User user = new User();
        user.setName(name);
        user.setCreateDate(new Date());
        if(userRepository.save(user)) {
            log.info("用户保存成功,{}", user);
        } else {
            log.error("用户保存失败{}", user);
        }

        return user;
    }

    @Override
    public User save(User user) {
        user.setCreateDate(new Date());
        if(userRepository.save(user)) {
            log.info("用户保存成功,{}", user);
        } else {
            log.error("用户保存失败{}", user);
        }

        return user;
    }
}
