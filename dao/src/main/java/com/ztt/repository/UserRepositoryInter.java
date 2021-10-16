package com.ztt.repository;

import com.ztt.domain.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhangtietuo on 2018/4/17.
 */
public interface UserRepositoryInter {

    /**
     * map方式存储对象 ConcurrentMap为高并发安全的map
     * final确保一致性
     */
    public final ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();

    public final static AtomicLong idGenerator = new AtomicLong();

    public boolean save(User user);

    //@Select("select * from user")
    public List<User> findAll();

    public User findById(Long uid);

    public User update(Long uid);


    public User delById(Long uid);


}
