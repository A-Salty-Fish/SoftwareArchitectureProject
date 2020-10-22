package com.example.demo.Impl;

import com.example.demo.Imp.IFoodService;
import com.example.demo.entity.Food;
import com.example.demo.entity.User;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.other.SubPage;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service("foodService")
public class FoodServiceImpl implements IFoodService {

    static SqlSession session = SqlSessionFactoryUtil.openSqlSession();

    @Override
    public Food GetFoodById(int id) {
        Food food = session.selectOne("getFood",id);
        return food;
    }

    @Override
    public Food AddFood(HttpServletRequest req) {
        Food food = Food.ReqToFood(req);
        session.insert("addFood",food);
        session.commit();
        return food;
    }

    @Override
    public Food DeleteFoodById(int id) {
        Food food = session.selectOne("getFood",id);
        session.delete("deleteFood",id);
        session.commit();
        return food;
    }

    @Override
    public Food UpdateFood(HttpServletRequest req) {
        Food food = Food.ReqToFood(req);
        session.update("updateFood",food);
        session.commit();
        return food;
    }

    @Override
    public List<Food> GetFoodPage(int CurrentPage, int PageSize) {
        List<Food> foodList = session.selectList("getFoodPage",
                SubPage.SubPageMap(CurrentPage,PageSize));
        return foodList;
    }

    @Override
    public List<Food> GetFoodByName(String name) {
        List<Food> foodList = session.selectList("getFoodByLikeName","%"+name+"%");
        return foodList;
    }
}
