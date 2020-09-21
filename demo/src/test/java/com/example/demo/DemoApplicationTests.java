package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    private JdbcTemplate jdbcTemplate;


    @Test
    public void contextLoads() {
        String sql = "select id,name,age from ay_user";
        List<AyUser> userList = (List<AyUser>) jdbcTemplate.query(sql,new RowMapper<AyUser>()
        {

            public AyUser mapRow(ResultSet rs, int rowNum)throws
                    SQLException {
                AyUser user = new AyUser();
                user.setId(rs.getString("id"));
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
        System.out.println("success");
        for(AyUser user : userList){
            System.out.println("id : " + user.getId() + "; name : " + user.getName());
        }
    }

}
