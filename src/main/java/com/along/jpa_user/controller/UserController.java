package com.along.jpa_user.controller;

import com.along.jpa_user.entity.User;
import com.along.jpa_user.service.Impl.UserServiceImpl;
import com.along.jpa_user.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;
    //RedisTemplate redisTemplate;


    RedisUtil redisUtil;

    @GetMapping("/insert")
    public String insert(@RequestParam("name") String name,@RequestParam("age") int age){
        int result=userService.insertUser(name,age);
        if(result>=1){
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")int id){
        int result=userService.deleteById(id);
        if(result>=1){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("id")int id,@RequestParam("name")String name,@RequestParam("age")int age){
        int result=userService.updateUser(id, name, age);
        if(result>=1){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

//    @GetMapping("/findAll")
//    public List<User> findAll(){
//        return userService.findAll();
//    }
    @PostMapping("/save")
    public User save(User user){
        return userService.save(user);
    }
    @DeleteMapping("/deleteById")
    public String deleteById(int id){
        int result=userService.delete(id);
        if(result>=1){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
    @PutMapping("/updateById")
    public User updateById(User user){
        return userService.update(user);
    }

    //@PutMapping
    //@DeleteMapping
    //@Mapp
    //ResponseEntity

//    @GetMapping("/redisAll")
//    public List<User> RedisAll() throws JsonProcessingException {
//        List<User> users =null;
//        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
//        //吧json字符串转换成json
//        String str = (String) operations.get("key");
//        //吧json转换成对象
//        ObjectMapper mapper = new ObjectMapper();
//        User user = mapper.readValue(str ,User.class);
//        return (List<User>) user;
//    }

    @GetMapping("/redisAll")
    public List<User> RedisAll(){
        redisUtil.set("all", userService.findAll().toString());
        return userService.findAll();
    }

//    @Cacheable
//    public int RedisUpdate(){
//        return 1;
//    }

    @GetMapping("all")
    public ResponseEntity<List> All(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/customHeader")
    public ResponseEntity<String> customHeader(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("Custom-Header","foo");
        return new ResponseEntity<>("hello word!", headers,HttpStatus.OK);
    }

}
