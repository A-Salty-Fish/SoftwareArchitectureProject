package com.example.demo.entity;

import javax.servlet.http.HttpServletRequest;

public class Food {
    private int id;
    private String name;
    private String img_url;
    private String canteen;

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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getCateen() {
        return canteen;
    }

    public void setCateen(String cateen) {
        this.canteen = cateen;
    }

    public static Food ReqToFood(HttpServletRequest req){
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String imgUrl = req.getParameter("img_url");
        String canteen = req.getParameter("canteen");
        Food food = new Food();
        food.setId(id);
        food.setName(name);
        food.setImg_url(imgUrl);
        food.setCateen(canteen);
        return food;
    }
}
