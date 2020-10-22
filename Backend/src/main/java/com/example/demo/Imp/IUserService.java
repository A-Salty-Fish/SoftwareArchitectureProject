package com.example.demo.Imp;

import com.example.demo.entity.User;
import com.example.demo.memory.CareTaker;
import com.example.demo.memory.Originator;
import com.example.demo.memory.SqlStep;
import com.example.demo.other.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserService {
    public User GetUserById(int id);
    public User DeleteUserById(int id);
    public User AddUser(HttpServletRequest req);
    public User UpdateUser(HttpServletRequest req);
    public List<User> GetUserPage(int CurrentPage,
                                  int PageSize);
}
