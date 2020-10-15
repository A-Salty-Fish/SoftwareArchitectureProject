package com.example.demo.controller;

import com.example.demo.Imp.SubPage;
import com.example.demo.config.SqlSessionFactoryUtil;
import com.example.demo.entity.Canteen;
import com.example.demo.entity.Food;
import com.example.demo.entity.User;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(value = "/canteen")
public class CanteenController {

    static SqlSession session = SqlSessionFactoryUtil.openSqlSession();

    @GetMapping("/GetCanteenById/{id}")
    @ResponseBody
    public Canteen GetCanteenById(@PathVariable("id") int id){
        Canteen canteen = session.selectOne("getCanteenById", id);
        return canteen;
    }

    @DeleteMapping("/DeleteCanteenById/{id}")
    @ResponseBody
    public Canteen DeleteCanteenById(@PathVariable("id") int id){
        Canteen canteen = session.selectOne("getCanteenById", id);
        if (canteen != null)
        {
            session.delete("deleteCanteenById",id);
            session.commit();
        }
        return canteen;
    }

    @PostMapping(value = "/AddCanteen")
    @ResponseBody
    public Canteen AddCanteen(HttpServletRequest req){
        Canteen canteen = Canteen.ReqToCanteen(req);
        session.insert("addCanteen",canteen);
        session.commit();
        return canteen;
    }

    @PostMapping(value = "/UpdateCanteen")
    @ResponseBody
    public Canteen UpdateCanteen(HttpServletRequest req){
        Canteen canteen = Canteen.ReqToCanteen(req);
        session.update("updateCanteen",canteen);
        session.commit();
        return canteen;
    }

    @GetMapping(value = "/GetCanteenPage/{CurrentPage}/{PageSize}")
    @ResponseBody
    public List<Canteen> GetCanteenPage(@PathVariable("CurrentPage") int CurrentPage,
                                  @PathVariable("PageSize") int PageSize){
        List<Canteen> canteenList = session.selectList("listCanteen");
        return SubPage.GetSubPage(canteenList,CurrentPage,PageSize);
    }
}
