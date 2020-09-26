package com.example.demo1.service;

import com.example.demo1.pojo.AyUser;
import com.example.demo1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Repository("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public List<AyUser> findAll(){ return  userDao.findAll(); }
    public Optional<AyUser> findById(String id){ return userDao.findById(id); }
    public AyUser save(AyUser ayUser){
        return userDao.save(ayUser);
    }
    public void deleteById(String id){
        userDao.deleteById(id);
    }
    public String login(AyUser ayUser, Model model, HttpSession session){
        AyUser ayUser1 = userDao.login(ayUser.getId(),ayUser.getPassword());
        if(ayUser1 != null){
            session.setAttribute("ayuser",ayUser1);
            if(ayUser1.getType().equals("buyer")){
                System.out.println("address" + userDao.addresses(ayUser1.getId()).toString());
                session.setAttribute("addresses",userDao.addresses(ayUser1.getId()));
                model.addAttribute("addresses",userDao.addresses(ayUser1.getId()));
            }
            model.addAttribute("ayuser",ayUser1);
            return ayUser1.getType() + "/main";
        }
        model.addAttribute("msg","用户名或者密码错误");
        return "ayUser";
    }
    @Transactional
    public String deleteAddr(String s,Model model,HttpSession session){
        userDao.deleteAddr(s,((AyUser)session.getAttribute("ayuser")).getId());
        return "/buyer/address";
    }
    @Transactional
    public String addAddr(String s,Model model,HttpSession session){
        userDao.addAddr(((AyUser)session.getAttribute("ayuser")).getId(),s);
        return "/buyer/address";
    }
    public String addresses(Model model,HttpSession session){
        model.addAttribute("addresses", userDao.addresses(((AyUser)session.getAttribute("ayuser")).getId()));
        return "/buyer/address";
    }

}
