package com.ztt.repository;

import org.springframework.stereotype.Repository;
import com.ztt.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhangtietuo on 2018/4/17.
 */
@Repository
public class UserRepository {

    /**
     * map方式存储对象 ConcurrentMap为高并发安全的map
     * final确保一致性
     */
    private final ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();

   private final static AtomicLong idGenerator = new AtomicLong();

    public boolean save(User user) {
        Long id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for(Map.Entry<Long, User> entry: repository.entrySet()) {
            users.add(entry.getValue());
        }
        return users;
    }
}
