package com.example.demo1.service;

import com.example.demo1.pojo.AyUser;
//import com.example.demo1.pojo.Good;
import com.example.demo1.pojo.Orders;
import com.example.demo1.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Repository("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    public List<Orders> findAll(){ return  orderDao.findAll(); }
    public Optional<Orders> findById(String id){ return orderDao.findById(id); }
    public Orders save(Orders orders){ return orderDao.save(orders); }
    public void deleteById(String id){
        orderDao.deleteById(id);
    }

    //@Transactional
    public String buy(Orders orders, Model model, HttpSession session){
        //Order o = new Order();
        try {
            Orders o = (Orders)model.getAttribute("orders");
            assert o != null;
            String id = o.getBuyerId() + o.getId() + System.currentTimeMillis();
            System.out.println("id = " + id);
            o.setId(id);
            //o.setId("123456");
            System.out.println("address=" + o.getDestination());
            o.setLog("ready for sending");
            System.out.println("here end");
            orderDao.save(o);
        }catch (Exception e ){
            model.addAttribute("msg","出错啦，请重试");
            return "/buyer/searchGoods";
        }
        model.addAttribute("msg","购买成功");
        return "/buyer/searchGoods";
    }
    public String searchOrder(Model model, HttpSession session){
        List<Orders> ol = orderDao.searchOrder(((AyUser)session.getAttribute("ayuser")).getId());
        //List<Order> ol = orderDao.searchOrder(((AyUser)model.getAttribute("ayuser")).getId());
        if (ol.size() > 0){
            model.addAttribute("orderLists",ol);
            //session.setAttribute("orderLists",ol);
            return "/buyer/searchOrders";
        }
        model.addAttribute("msg","还没有订单，快去买点东西吧");
        return "/buyer/searchOrders";
    }

}
