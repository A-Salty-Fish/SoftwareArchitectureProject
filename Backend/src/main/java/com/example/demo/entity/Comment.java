package com.example.demo.entity;

import com.example.demo.other.MyRequestUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int id;
    private String content;
    private int user_id;
    private String food_name;
    private String canteen;
    private int stars;
    public static Comment ReqToComment(HttpServletRequest req){
        return MyRequestUtil.getParameterObject(req,Comment.class);
    }
}
