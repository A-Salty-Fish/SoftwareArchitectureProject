package com.example.demo.entity;

import com.example.demo.other.MyRequestUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private int id;
    private String name;
    private String img_url;
    private String canteen;

    public static Food ReqToFood(HttpServletRequest req){
        return MyRequestUtil.getParameterObject(req,Food.class);
    }
}
