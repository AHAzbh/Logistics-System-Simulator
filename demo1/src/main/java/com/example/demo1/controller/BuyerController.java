package com.example.demo1.controller;


import com.example.demo1.pojo.Orders;
import com.example.demo1.service.GoodService;
import com.example.demo1.service.OrderService;
import com.example.demo1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class BuyerController extends AdminController {
    @Resource
    private OrderService orderService;
    @Resource
    private GoodService goodService;
    @Resource
    private UserService userService;

    @RequestMapping("/buyer/searchGoods")
    public String searchGoods(){
        return "/buyer/searchGoods";
    }
    //@RequestMapping("/buyer/address")
    //public String address(){
        //return "/buyer/address";
    //}
    @RequestMapping("/buyer/address")
    public String addresses(Model model ,HttpSession session){
        return userService.addresses(model,session);
    }
    @RequestMapping("/buyer/searchGoodsById")
    public String searchGoodsById(@RequestParam(value="id") String s, Model model, HttpSession session){
        return goodService.searchGoodsById(s,model,session);
    }
    @RequestMapping("/buyer/searchGoodsByName")
    public String searchGoodsByName(@RequestParam(value="name") String s,Model model, HttpSession session){
        return goodService.searchGoodsByName(s,model,session);
    }
    @RequestMapping("/buyer/searchSeller")
    public String searchSeller(@RequestParam(value="seller_id") String s,Model model, HttpSession session){
        return goodService.searchSeller(s,model,session);
    }
    @RequestMapping("/buyer/buy")
    public String buy(@ModelAttribute Orders orders, Model model, HttpSession session){
        return orderService.buy(orders,model,session);
    }
    @RequestMapping("/buyer/searchOrders")
    public String searchOrder(Model model, HttpSession session){
        return orderService.searchOrder(model,session);
    }
    @RequestMapping("/buyer/delete_addr")
    public String deleteAddr(@RequestParam(value="address") String s,Model model,HttpSession session){
        return userService.deleteAddr(s,model,session);
    }
    @RequestMapping("/buyer/add_addr")
    public String addAddr(@RequestParam(value="address") String s,Model model,HttpSession session){
        return userService.addAddr(s,model,session);
    }




}
