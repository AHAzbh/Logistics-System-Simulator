package com.example.demo.controller;


import com.example.demo.pojo.Order;
import com.example.demo.service.GoodService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class BuyerController{
	
    @Resource
    private OrderService orderService;
    @Resource
    private GoodService goodService;
    @Resource
    private UserService userService;

    @GetMapping("/buyer/searchGoods")
    public String searchGoods(){
        return "/buyer/searchGoods";
    }

    
    @GetMapping("/buyer/searchGoodsById")
    public String searchGoodsById(@RequestParam(value="id") String s, Model model, HttpSession session){
        return goodService.searchGoodsById(s,model,session);
    }
    
    @GetMapping("/buyer/searchGoodsByName")
    public String searchGoodsByName(@RequestParam(value="name") String s,Model model, HttpSession session){
        return goodService.searchGoodsByName(s,model,session);
    }
    
    @GetMapping("/buyer/searchSeller")
    public String searchSeller(@RequestParam(value="seller_id") String s,Model model, HttpSession session){
        return goodService.searchSeller(s,model,session);
    }
    
    @PostMapping("/buyer/buy")
    public String buy(@ModelAttribute Order orders, Model model, HttpSession session){
        return orderService.buy(orders,model,session);
    }
    
    @GetMapping("/buyer/searchOrders")
    public String searchOrder(Model model, HttpSession session){
        return orderService.searchOrder(model,session);
    }
    
    @GetMapping("/buyer/delete_addr")
    public void deleteAddr(@RequestParam(value="id") String id, @RequestParam(value="address") String address){
        userService.deleteAddr(id, address);
    }
    
    @PostMapping("/buyer/add_addr")
    public void addAddr(@RequestParam(value="id") String id, @RequestParam(value="address") String address){
        userService.addAddr(id, address);
    }


}
