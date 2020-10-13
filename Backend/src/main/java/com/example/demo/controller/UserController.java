package com.example.demo.controller;
import com.example.demo.entity.User;
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
@RestController
public class UserController {
    
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
    User ReqToUser(HttpServletRequest req){
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String headImgUrl = req.getParameter("headImgUrl");
        String faculty = req.getParameter("faculty");
        String schoolNum = req.getParameter("schoolNum");
        int authorLevel = Integer.parseInt(req.getParameter("authorLevel"));
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setHeadImgUrl(headImgUrl);
        user.setFaculty(faculty);
        user.setSchoolNum(schoolNum);
        user.setAuthorLevel(authorLevel);
        return user;
    }
    @RequestMapping("/test")
    public User testMysql() throws IOException {
        List<User> listUser = session.selectList("listUser");
        return listUser.get(1);
    }
    @GetMapping(value = "/GetUserById/{id}")
    @ResponseBody
    public User GetUserById(@PathVariable("id") int id) {
        User user = session.selectOne("getUser",id);
        return user;
    }
    @GetMapping(value = "/DeleteUserById/{id}")
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
    @PostMapping(value = "/AddUser")
    @ResponseBody
    public User AddUser(HttpServletRequest req){
        User user = ReqToUser(req);
        session.insert("addUser",user);
        session.commit();
        return user;
    }
    @PostMapping(value = "/UpdateUser")
    @ResponseBody
    public User UpdateUser(HttpServletRequest req){
        User user = ReqToUser(req);
        session.update("updateUser",user);
        session.commit();
        return user;
    }
}
