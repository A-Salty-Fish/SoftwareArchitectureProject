package com.example.demo.controller;

import com.example.demo.config.SqlSessionFactoryUtil;
import com.example.demo.entity.Canteen;
import com.example.demo.entity.Food;
import com.example.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    static SqlSession session = SqlSessionFactoryUtil.openSqlSession();

    @GetMapping(value = "/GetFoodById/{id}")
    @ResponseBody
    public Food GetFoodById(@PathVariable("id") int id) {
        Food food = session.selectOne("getFood",id);
        return food;
    }
    
    @PostMapping(value = "/AddFood")
    @ResponseBody
    public Food AddFood(HttpServletRequest req){
        Food food = Food.ReqToFood(req);
        session.insert("addFood",food);
        session.commit();
        return food;
    }

    @DeleteMapping(value = "/DeleteFoodById/{id}")
    @ResponseBody
    public Food DeleteFoodById(@PathVariable("id") int id) {
        Food food = session.selectOne("getFood",id);
        session.delete("deleteFood",id);
        session.commit();
        return food;
    }
}
