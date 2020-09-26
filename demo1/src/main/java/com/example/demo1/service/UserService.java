package com.example.demo1.service;

import com.example.demo1.pojo.AyUser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<AyUser> findAll();
    public Optional<AyUser> findById(String id);
    public AyUser save(AyUser ayUser);
    public void deleteById(String id);
    public String login(AyUser ayUser, Model model, HttpSession session);
    public String addresses(Model model,HttpSession session);
    public String deleteAddr(String s,Model model,HttpSession session);
    public String addAddr(String s,Model model,HttpSession session);
}






