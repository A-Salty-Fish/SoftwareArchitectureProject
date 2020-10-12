package com.example.demo.controller;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.RowMapper;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class UserController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/test")
    public User testMysql() {
        String sql = "select * from user";
        List<User> userList = (List<User>) jdbcTemplate.query(
                sql, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user = new User();
                        user.setId(resultSet.getInt("id"));
                        user.setName(resultSet.getString("name"));
                        user.setHeadImgUrl(resultSet.getString("headimg_url"));
                        user.setFaculty(resultSet.getString("faculty"));
                        user.setSchoolNum(resultSet.getString("school_num"));
                        user.setAuthorLevel(resultSet.getInt("author_level"));
                        return user;
                    }
                }
        );
        System.out.println("查询成功");
        for (User user: userList){
            System.out.println("id:"+user.getId());
            System.out.println("name:"+user.getName());
            System.out.println("headimg_url:"+user.getHeadImgUrl());
            System.out.println("faculty:"+user.getFaculty());
            System.out.println("school_num:"+user.getSchoolNum());
            System.out.println("author_level:"+user.getAuthorLevel());
        }
        return userList.get(1);
    }
}
