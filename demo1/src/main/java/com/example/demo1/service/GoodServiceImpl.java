package com.example.demo1.service;

import com.example.demo1.dao.GoodDao;
import com.example.demo1.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
@Repository("goodService")
public class GoodServiceImpl implements  GoodService{
    @Autowired
    private GoodDao goodDao;

    public List<Good> findAll() {
        return goodDao.findAll();
    }
    public Optional<Good> findById(String id){
        return goodDao.findById(id);
    }
    public Good save(Good good){
        return goodDao.save(good);
    }
    public void deleteById(String id){
        goodDao.deleteById(id);
    }
    public String searchGoodsById(String s, Model model, HttpSession session){
        Optional<Good> good = goodDao.findById(s);
        if(good.isEmpty()){
            model.addAttribute("msg","没找到对应的货品");
            return "/buyer/searchGoods";
        }
        model.addAttribute("msg","找到以下商品");
        model.addAttribute("goods",good.get());
        //session.setAttribute("good",good);
        return "/buyer/searchGoods";
    }
    public String searchGoodsByName(String s,Model model, HttpSession session){
        List<Good> goods = goodDao.searchGoodsByName(s);
        if(goods.size() > 0){
            model.addAttribute("msg","找到以下商品");
            model.addAttribute("goods",goods);
            //session.setAttribute("goods",goods);
            return "/buyer/searchGoods";
        }
        model.addAttribute("msg","没找到对应的货品");
        return "/buyer/searchGoods";
    }
    public String searchSeller(String s,Model model, HttpSession session){
        List<Good> goods = goodDao.searchSeller(s);
        if(goods.size() > 0){
            model.addAttribute("msg","找到以下商品");
            model.addAttribute("goods",goods);
            //session.setAttribute("goods",goods);
            return "/buyer/searchGoods";
        }
        model.addAttribute("msg","没找到对应的货品");
        return "/buyer/searchGoods";
    }
}
