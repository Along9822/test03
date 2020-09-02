package com.along.jpa_user.dao;

import com.along.jpa_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    List<User> findAll();

    @Modifying
    @Transactional
    @Query(value = "insert into t_user(name,age) values (?,?)", nativeQuery = true)
    int insertUser(@Param("name")String name,@Param("age")int age);

    @Modifying
    @Transactional
    @Query(value = "delete from t_user where id=:id")
    int deleteById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update t_user t set t.name=:name,t.age=:age where t.id=:id")
    int updateUser(@Param("id") int id,@Param("name") String name,@Param("age") int age);

}
