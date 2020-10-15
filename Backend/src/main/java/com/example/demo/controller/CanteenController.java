package com.example.demo.controller;

import com.example.demo.entity.Canteen;
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

@RestController
@RequestMapping(value = "/canteen")
public class CanteenController {
    /**
     * 静态Mybatis成员
     */
    static String resource = "mybatis-config.xml";
    static InputStream inputStream;
    static {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    static SqlSession session = sqlSessionFactory.openSession();

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
}
