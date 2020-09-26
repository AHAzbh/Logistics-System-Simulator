package com.example.demo1.controller;

import com.example.demo1.pojo.AyUser;
import com.example.demo1.service.UserService;
//import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class AyUserBeforeController {
    @Resource
    private UserService userService;


    @RequestMapping("/ayUser")
    public String ayUser(){
        return "ayUser";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/register1")
    public String register1(@ModelAttribute AyUser ayUser,Model model, HttpSession session){
        userService.save(ayUser);
        System.out.println(userService.findAll().toString());
        return "ayUser";

    }
    @RequestMapping("/login")
    public String login(@ModelAttribute AyUser ayUser, Model model,HttpSession session){
        return userService.login(ayUser,model,session);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }



}
