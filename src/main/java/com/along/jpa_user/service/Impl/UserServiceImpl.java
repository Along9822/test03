package com.along.jpa_user.service.Impl;

import com.along.jpa_user.dao.UserDao;
import com.along.jpa_user.entity.User;
import com.along.jpa_user.service.UserService;
import com.along.jpa_user.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<User> findAll() {
//        redisUtil.set("redisAll",userDao.findAll());
//        System.out.println(redisUtil.get("redisAll"));
        redisUtil.get("all");
        return userDao.findAll();
    }

    @Override
    public int insertUser(String name, int age) {
        return userDao.insertUser(name,age);
    }

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int updateUser(int id, String name, int age) {
        return userDao.updateUser(id,name,age);
    }

    public User save(User user){
        return userDao.save(user);
    }

    public int delete(int id){
        return userDao.deleteById(id);
    }

    public User update(User user){
        return userDao.save(user);
    }


}
