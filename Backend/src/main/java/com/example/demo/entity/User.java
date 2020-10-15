package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.servlet.http.HttpServletRequest;
public class User {
    private int id;
    private String name;
    private String headImgUrl;
    private String faculty;
    private String schoolNum;
    private int AuthorLevel;

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

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSchoolNum() {
        return schoolNum;
    }

    public void setSchoolNum(String schoolNum) {
        this.schoolNum = schoolNum;
    }

    public int getAuthorLevel() {
        return AuthorLevel;
    }

    public void setAuthorLevel(int authorLevel) {
        AuthorLevel = authorLevel;
    }

    public static User ReqToUser(HttpServletRequest req){
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
}
