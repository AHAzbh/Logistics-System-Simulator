package com.example.demo1.exception;

import com.example.demo1.pojo.AyUser;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MyHandlerExceptionResolver  implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,Object obj,Exception e){
        Map<String,Object> model=new HashMap<String,Object>();
        model.put("ex",e.toString());
        /*if(e instanceof AdminLoginNoException){
            request.setAttribute("ayuser",new AyUser());
            request.setAttribute("msg","没有登录，请登录!");
            return new ModelAndView("/admin/login",model);
        } else */
        if(e instanceof UserLoginNoException){
            request.setAttribute("ayuser",new AyUser());
            request.setAttribute("msg","没有登录，请登录!");
            return new ModelAndView("/ayUser",model);
        } else{
            return new ModelAndView("/error/error",model);
        }
    }
}
