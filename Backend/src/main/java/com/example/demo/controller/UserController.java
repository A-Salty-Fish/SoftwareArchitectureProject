package com.example.demo.controller;
import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.RowMapper;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Api("User控制类")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    /**
     * 静态Mybatis成员
     */
    static String resource = "mybatis-config.xml";
    static InputStream inputStream;
    static {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    static SqlSession session = sqlSessionFactory.openSession();

    @GetMapping(value = "/GetUserById/{id}")
    @ResponseBody
    public User GetUserById(@PathVariable("id") int id) {
        User user = session.selectOne("getUser",id);
        return user;
    }
    /**
     *
     * @param id 要删除的用户id
     * @return
     */
    @DeleteMapping(value = "/DeleteUserById/{id}")
    @ResponseBody
    public User DeleteUserById(@PathVariable("id") int id) {
        User user = session.selectOne("getUser",id);
        if (user != null)
        {
            session.delete("deleteUser",id);
            session.commit();
            return user;
        }
        return null;
    }

    /**
     *
     * @param req 添加用户的post请求body
     * @return
     */
    @PostMapping(value = "/AddUser")
    @ResponseBody
    public User AddUser(HttpServletRequest req){
        User user = User.ReqToUser(req);
        session.insert("addUser",user);
        session.commit();
        return user;
    }

    /**
     *
     * @param req 修改用户的post请求body
     * @return
     */
    @PostMapping(value = "/UpdateUser")
    @ResponseBody
    public User UpdateUser(HttpServletRequest req){
        User user = User.ReqToUser(req);
        session.update("updateUser",user);
        session.commit();
        return user;
    }
}
