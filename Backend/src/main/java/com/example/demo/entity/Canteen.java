package com.example.demo.entity;

import javax.servlet.http.HttpServletRequest;

public class Canteen {
    private int id;
    private String name;
    private String position;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static Canteen ReqToCanteen(HttpServletRequest req){
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String position = req.getParameter("position");
        Canteen canteen = new Canteen();
        canteen.setId(id);
        canteen.setName(name);
        canteen.setPosition(position);
        return canteen;
    }
}
