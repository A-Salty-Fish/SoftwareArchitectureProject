package com.example.demo.Imp;

import com.example.demo.entity.Food;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IFoodService {
    public Food GetFoodById(int id);
    public Food AddFood(HttpServletRequest req);
    public Food DeleteFoodById(int id);
    public Food UpdateFood(HttpServletRequest req);
    public List<Food> GetFoodPage(int CurrentPage,
                                  int PageSize);
}
