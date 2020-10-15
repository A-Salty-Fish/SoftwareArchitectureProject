package com.example.demo.controller;
import com.example.demo.Imp.SubPage;
import com.example.demo.config.SqlSessionFactoryUtil;
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

    static SqlSession session = SqlSessionFactoryUtil.openSqlSession();

    @GetMapping(value = "/GetUserById/{id}")
    @ResponseBody
    public User GetUserById(@PathVariable("id") int id) {
        User user = session.selectOne("getUser",id);
        return user;
    }

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

    @PostMapping(value = "/AddUser")
    @ResponseBody
    public User AddUser(HttpServletRequest req){
        User user = User.ReqToUser(req);
        session.insert("addUser",user);
        session.commit();
        return user;
    }

    @PostMapping(value = "/UpdateUser")
    @ResponseBody
    public User UpdateUser(HttpServletRequest req){
        User user = User.ReqToUser(req);
        session.update("updateUser",user);
        session.commit();
        return user;
    }

    @GetMapping(value = "/GetUserPage/{CurrentPage}/{PageSize}")
    @ResponseBody
    public List<User> GetUserPage(@PathVariable("CurrentPage") int CurrentPage,
                                  @PathVariable("PageSize") int PageSize){
        List<User> userList = session.selectList("listUser");
        return SubPage.GetSubPage(userList,CurrentPage,PageSize);
    }
}
