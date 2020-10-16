package com.example.demo.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubPage {
    public static <T> List<T> GetSubPage(List<T> list, int CurrentPage, int PageSize){
        if ((CurrentPage-1)*PageSize > list.size() - 1 ) return null;
        else if (CurrentPage*PageSize > list.size())
            return list.subList((CurrentPage-1)*PageSize,list.size());
        return list.subList((CurrentPage-1)*PageSize,CurrentPage*PageSize);
    }
    public static Map<String,Integer> SubPageMap(int CurrentPage,int PageSize){
        Map<String,Integer> map = new HashMap<>();
        map.put("CurrentPage",PageSize * (CurrentPage - 1));
        map.put("PageSize",PageSize);
        return map;
    }
}
