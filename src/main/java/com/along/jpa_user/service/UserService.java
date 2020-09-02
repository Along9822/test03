package com.along.jpa_user.service;

import com.along.jpa_user.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {
    List<User> findAll();
    int insertUser(String name,int age);
    int deleteById(int id);
    int updateUser(int id,String name,int age);
}
