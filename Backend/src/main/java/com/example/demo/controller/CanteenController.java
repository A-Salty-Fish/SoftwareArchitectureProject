package com.example.demo.controller;

import com.example.demo.Imp.ICanteenService;
import com.example.demo.other.SubPage;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.entity.Canteen;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/canteen")
public class CanteenController {

    static SqlSession session = SqlSessionFactoryUtil.openSqlSession();

    @Autowired
    private ICanteenService canteenService;

    @GetMapping("/GetCanteenById/{id}")
    @ResponseBody
    public Canteen GetCanteenById(@PathVariable("id") int id){
        return canteenService.GetCanteenById(id);
    }

    @DeleteMapping("/DeleteCanteenById/{id}")
    @ResponseBody
    public Canteen DeleteCanteenById(@PathVariable("id") int id){
        return canteenService.DeleteCanteenById(id);
    }

    @PostMapping(value = "/AddCanteen")
    @ResponseBody
    public Canteen AddCanteen(HttpServletRequest req){
        return canteenService.AddCanteen(req);
    }

    @PostMapping(value = "/UpdateCanteen")
    @ResponseBody
    public Canteen UpdateCanteen(HttpServletRequest req){
        return canteenService.UpdateCanteen(req);
    }

    @GetMapping(value = "/GetCanteenPage/{CurrentPage}/{PageSize}")
    @ResponseBody
    public List<Canteen> GetCanteenPage(@PathVariable("CurrentPage") int CurrentPage,
                                  @PathVariable("PageSize") int PageSize){
        return canteenService.GetCanteenPage(CurrentPage,PageSize);
    }
}
