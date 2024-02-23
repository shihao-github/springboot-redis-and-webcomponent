package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    //@Resource
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;
    //private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<User> findAll() {
        // redis的key
        String key = "alluser";
        // 先查询redis中是否有数据，如果有直接返回redis的数据
        List<User> users = (List<User>)redisTemplate.boundValueOps(key).get();
        if (users != null){
            System.out.println("从Redis中获取缓存数据=" + users);
            return users;
        }

        // 如果没有，查询数据库
        users = userDao.findAll();
        if (users != null && users.size() > 0){
            // 将数据库数据存入到redis中
            System.out.println("从数据库中获取数据存放到Redis缓存=" + users);
            redisTemplate.boundValueOps(key).set(users);
        }
        return users;
    }
}
