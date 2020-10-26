package com.example.demo.Imp;

import com.example.demo.entity.Canteen;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ICanteenService {
    public abstract Canteen GetCanteenById(int id);
    public Canteen DeleteCanteenById(int id);
    public Canteen AddCanteen(HttpServletRequest req);
    public Canteen UpdateCanteen(HttpServletRequest req);
    public List<Canteen> GetCanteenPage(int CurrentPage,
                                        int PageSize);
    public List<Canteen> GetCanteenByName(String name);
    public List<Canteen> GetAllCanteen();
}
