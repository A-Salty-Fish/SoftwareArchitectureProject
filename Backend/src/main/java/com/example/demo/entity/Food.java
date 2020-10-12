package com.example.demo.entity;

public class Food {
    private int id;
    private String name;
    private String imgUrl;
    private String cateen;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCateen() {
        return cateen;
    }

    public void setCateen(String cateen) {
        this.cateen = cateen;
    }
}
