package com.example.demo.controller;

import com.example.demo.Imp.IFoodService;
import com.example.demo.other.SubPage;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.entity.Food;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    IFoodService foodService;

    @GetMapping(value = "/GetFoodById/{id}")
    @ResponseBody
    public Food GetFoodById(@PathVariable("id") int id) {
        return foodService.GetFoodById(id);
    }
    
    @PostMapping(value = "/AddFood")
    @ResponseBody
    public Food AddFood(HttpServletRequest req){
        return foodService.AddFood(req);
    }

    @DeleteMapping(value = "/DeleteFoodById/{id}")
    @ResponseBody
    public Food DeleteFoodById(@PathVariable("id") int id) {
        return foodService.DeleteFoodById(id);
    }

    @PostMapping(value = "/UpdateFood")
    @ResponseBody
    public Food UpdateFood(HttpServletRequest req){
        return foodService.UpdateFood(req);
    }

    @GetMapping(value = "/GetFoodPage/{CurrentPage}/{PageSize}")
    @ResponseBody
    public List<Food> GetFoodPage(@PathVariable("CurrentPage") int CurrentPage,
                                  @PathVariable("PageSize") int PageSize){
        return foodService.GetFoodPage(CurrentPage,PageSize);
    }

    @GetMapping(value = "GetFoodByName/{name}")
    @ResponseBody
    public List<Food> GetFoodByName(@PathVariable("name") String name){
        return foodService.GetFoodByName(name);
    }
}
