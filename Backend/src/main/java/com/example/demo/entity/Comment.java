package com.example.demo.entity;

import javax.servlet.http.HttpServletRequest;

public class Comment {
    private int id;
    private String content;
    private int user_id;
    private String food_name;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
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
        int userId = Integer.parseInt(req.getParameter("user_id"));
        String foodName = req.getParameter("food_name");
        String canteen = req.getParameter("canteen");
        int stars = Integer.parseInt(req.getParameter("stars"));
        Comment comment = new Comment();
        comment.setId(id);
        comment.setContent(content);
        comment.setUser_id(userId);
        comment.setFood_name(foodName);
        comment.setCanteen(canteen);
        comment.setStars(stars);
        return comment;
    }
}
