package com.example.demo.controller;
import com.example.demo.other.SubPage;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        List<User> userList = session.selectList("getUserPage",
                SubPage.SubPageMap(CurrentPage,PageSize));
        return userList;
    }
}
