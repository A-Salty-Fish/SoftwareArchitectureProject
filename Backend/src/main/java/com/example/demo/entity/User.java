package com.example.demo.entity;

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
}
