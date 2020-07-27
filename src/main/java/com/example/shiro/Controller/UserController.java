package com.example.shiro.Controller;

import com.example.shiro.entity.User;
import com.example.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: shiro
 * @description:
 * @author: yetin
 * @create: 2020-07-27 11:27
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public User user(){
        User user = userService.findAllUserInfoByUsername("大当家");
        return user;
    }
}
