package com.polaris.controller;

import com.polaris.mapper.UserMapper;
import com.polaris.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserMapper userMapper;


    @GetMapping("getByName")
    public User getByName(){
        BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
        String app = passwordEncoder.encode("app");
        System.out.println("加密后：" + app);
        boolean isMatch = passwordEncoder.matches("app", app); // 使用matches方法进行密码匹配

        if (isMatch) {
            System.out.println("密码正确");
        } else {
            System.out.println("密码错误");
        }
        return userMapper.selectByUserName("zhangjian");
    }

    /**
     * 获取授权的用户信息
     * @param principal 当前用户
     * @return 授权信息
     */
    @GetMapping("current/get")
    public Principal user(Principal principal){
        return principal;
    }
}
