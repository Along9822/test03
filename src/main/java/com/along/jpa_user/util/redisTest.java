package com.along.jpa_user.util;
import com.along.jpa_user.dao.UserDao;
import com.along.jpa_user.entity.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

public class redisTest{
    /**
     *使用redis自带的工具类
     *也可以自己写一个redis工具类（不推荐）
     */
    @Autowired
    private RedisTemplate<String ,Object> redisTemplate;

    @Autowired
    private UserDao userDao;

    public void studentsRedis() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        User user = new User();
        List<User> list = userDao.findAll();
        //将Students转换为json格式
        JSONObject jsonObject = (JSONObject) JSONObject.wrap(user);
        //将json转换为json字符串
        String str = jsonObject.toString();
        //吧Students这个对象存放到redis中
        operations.set("key", str);
    }
}
