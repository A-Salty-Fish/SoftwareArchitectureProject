package com.example.demo.controller;
import com.example.demo.Impl.UserServiceImpl;
import com.example.demo.memory.CareTaker;
import com.example.demo.memory.Originator;
import com.example.demo.memory.SqlStep;
import com.example.demo.other.SubPage;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api("User控制类")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/GetUserById/{id}")
    @ResponseBody
    public User GetUserById(@PathVariable("id") int id) {
        return userService.GetUserById(id);
    }

    @DeleteMapping(value = "/DeleteUserById/{id}")
    @ResponseBody
    public User DeleteUserById(@PathVariable("id") int id) {
        return userService.DeleteUserById(id);
    }

    @GetMapping(value = "Redo")
    @ResponseBody
    public String RedoUser(){
        return userService.RedoUser();
    }

    @PostMapping(value = "/AddUser")
    @ResponseBody
    public User AddUser(HttpServletRequest req){
        return userService.AddUser(req);
    }

    @PostMapping(value = "/UpdateUser")
    @ResponseBody
    public User UpdateUser(HttpServletRequest req){
        return userService.UpdateUser(req);
    }

    @GetMapping(value = "/GetUserPage/{CurrentPage}/{PageSize}")
    @ResponseBody
    public List<User> GetUserPage(@PathVariable("CurrentPage") int CurrentPage,
                                  @PathVariable("PageSize") int PageSize){
        return userService.GetUserPage(CurrentPage,PageSize);
    }
}
