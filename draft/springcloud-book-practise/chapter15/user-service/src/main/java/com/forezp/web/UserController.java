package com.forezp.web;

import com.forezp.client.TestFiengClient;
import com.forezp.dto.UserLoginDTO;
import com.forezp.entity.User;
import com.forezp.service.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fangzhipeng on 2017/6/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceDetail userServiceDetail;

    @Autowired
    TestFiengClient client;

    @PostMapping("/register")
    public User postUser(@RequestParam("username") String username ,@RequestParam("password") String password){
        //参数判断，省略
       return userServiceDetail.insertUser(username,password);
    }

    @PostMapping("/login")
    public UserLoginDTO login(@RequestParam("username") String username , @RequestParam("password") String password){
        //参数判断，省略
        return userServiceDetail.login(username,password);
    }

    @GetMapping("/test")
    public String test(){
        String result =  client.testFiegn();
        if (result == null){
            return "调用失败";
        }
        return result;
    }
}
