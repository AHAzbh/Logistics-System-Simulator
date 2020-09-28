package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.AyUser;
import com.example.demo.service.TokenService;
import com.example.demo.service.UserService;
import com.example.demo.util.UserLoginToken;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
//import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class AyUserBeforeController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private HttpServletRequest httpServletRequest;

    @PostMapping("/ayuser/register")
    public String register(@RequestBody AyUser ayUser){
    	userService.save(ayUser);
    	log.info("添加用户参数: {}", ayUser);
        return "register";
    }

    @PostMapping("/ayuser/login")
    public Object login(@RequestParam("id") String id, @RequestParam("password") String password){
        JSONObject jsonObject=new JSONObject();
        AyUser userForBase=userService.findById(id).get();
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(password)){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                log.info("login user: {}", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/ayuser/hello")
    public String hello(){
    	AyUser user = (AyUser)httpServletRequest.getAttribute("currentUser");
    	log.info("hello user: {}", user);
        return "hello" + " " + user.getId();
    }



}
