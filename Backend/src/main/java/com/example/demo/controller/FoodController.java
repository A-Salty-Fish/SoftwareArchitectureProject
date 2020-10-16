package com.example.demo.controller;

import com.example.demo.other.SubPage;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.entity.Food;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @PostMapping(value = "/UpdateFood")
    @ResponseBody
    public Food UpdateFood(HttpServletRequest req){
        Food food = Food.ReqToFood(req);
        session.update("updateFood",food);
        session.commit();
        return food;
    }

    @GetMapping(value = "/GetFoodPage/{CurrentPage}/{PageSize}")
    @ResponseBody
    public List<Food> GetFoodPage(@PathVariable("CurrentPage") int CurrentPage,
                                  @PathVariable("PageSize") int PageSize){
        List<Food> foodList = session.selectList("getFoodPage",
                SubPage.SubPageMap(CurrentPage,PageSize));
        return foodList;
    }

}
