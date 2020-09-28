package com.example.demo.controller;


import com.example.demo.exception.AdminLoginNoException;
import com.example.demo.exception.UserLoginNoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
//
//    @ModelAttribute
//    public void isLogin(HttpSession session, HttpServletRequest request)
//    throws UserLoginNoException {
//        if(session.getAttribute("ayuser") == null){
//            throw new UserLoginNoException("没有登录");
//        }
//    }

}
