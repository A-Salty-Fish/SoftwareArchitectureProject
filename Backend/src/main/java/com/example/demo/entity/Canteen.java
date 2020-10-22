package com.example.demo.entity;

import com.example.demo.other.MyRequestUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canteen {
    private int id;
    private String name;
    private String position;

    public static Canteen ReqToCanteen(HttpServletRequest req){
        return MyRequestUtil.getParameterObject(req,Canteen.class);
    }
}
