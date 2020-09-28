package com.example.demo.service;

import com.example.demo.pojo.AyUser;
import com.example.demo.pojo.Good;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface GoodService {
    
	public List<Good> findAll();
    
	public Optional<Good> findById(String id);
    
	public Good save(Good good);
    
	public void deleteById(String id);
    
	public String searchGoodsById(String s, Model model, HttpSession session);
    
	public String searchGoodsByName(String s,Model model, HttpSession session);
    
	public String searchSeller(String s,Model model, HttpSession session);
}
