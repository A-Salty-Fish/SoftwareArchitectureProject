package com.example.demo.entity;

import javax.servlet.http.HttpServletRequest;

public class Food {
    private int id;
    private String name;
    private String imgUrl;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
        String imgUrl = req.getParameter("imgUrl");
        String canteen = req.getParameter("Food");
        Food food = new Food();
        food.setId(id);
        food.setName(name);
        food.setImgUrl(imgUrl);
        food.setCateen(canteen);
        return food;
    }
}
