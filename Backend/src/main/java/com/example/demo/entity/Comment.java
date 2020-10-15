package com.example.demo.entity;

import javax.servlet.http.HttpServletRequest;

public class Comment {
    private int id;
    private String content;
    private int userId;
    private String foodName;
    private String canteen;
    private int stars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCanteen() {
        return canteen;
    }

    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public static Comment ReqToComment(HttpServletRequest req){
        int id = Integer.parseInt(req.getParameter("id"));
        String content = req.getParameter("content");
        int userId = Integer.parseInt(req.getParameter("userId"));
        String foodName = req.getParameter("foodName");
        String canteen = req.getParameter("canteen");
        int stars = Integer.parseInt(req.getParameter("stars"));
        Comment comment = new Comment();
        comment.setId(id);
        comment.setContent(content);
        comment.setUserId(userId);
        comment.setFoodName(foodName);
        comment.setCanteen(canteen);
        comment.setStars(stars);
        return comment;
    }
}
