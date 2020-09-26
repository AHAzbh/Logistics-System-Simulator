package com.example.demo1.dao;

import com.example.demo1.pojo.AyUser;
import com.example.demo1.pojo.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Repository
public interface GoodDao extends JpaRepository<Good,String> {
    @Query(value="select a from Good a where a.name=?1")
    List<Good> searchGoodsByName(String s);
    @Query(value="select a from Good a where a.seller_id=?1")
    List<Good> searchSeller(String s);
}
