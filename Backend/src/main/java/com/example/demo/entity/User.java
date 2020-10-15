package com.example.demo.entity;

import javax.servlet.http.HttpServletRequest;
public class User {
    private int id;
    private String name;
    private String headimg_url;
    private String faculty;
    private String school_num;
    private int author_level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadimg_url() {
        return headimg_url;
    }

    public void setHeadimg_url(String headimg_url) {
        this.headimg_url = headimg_url;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSchool_num() {
        return school_num;
    }

    public void setSchool_num(String school_num) {
        this.school_num = school_num;
    }

    public int getAuthor_level() {
        return author_level;
    }

    public void setAuthor_level(int author_level) {
        this.author_level = author_level;
    }

    public static User ReqToUser(HttpServletRequest req){
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String headImgUrl = req.getParameter("headimg_url");
        String faculty = req.getParameter("faculty");
        String schoolNum = req.getParameter("school_num");
        int authorLevel = Integer.parseInt(req.getParameter("author_level"));
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setHeadimg_url(headImgUrl);
        user.setFaculty(faculty);
        user.setSchool_num(schoolNum);
        user.setAuthor_level(authorLevel);
        return user;
    }
}
