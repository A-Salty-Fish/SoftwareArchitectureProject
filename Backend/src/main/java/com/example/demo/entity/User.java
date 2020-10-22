package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.ServletRequestDataBinder;

import javax.servlet.http.HttpServletRequest;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String headimg_url;
    private String faculty;
    private String school_num;
    private int author_level;

    public static User ReqToUser(HttpServletRequest req){
        User user = new User();
        ServletRequestDataBinder binder = new ServletRequestDataBinder(user);
        binder.bind(req);
        return user;
    }
}
