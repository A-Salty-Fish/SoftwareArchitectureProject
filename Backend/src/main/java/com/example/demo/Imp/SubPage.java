package com.example.demo.Imp;

import java.util.List;

public class SubPage {
    public static <T> List<T> GetSubPage(List<T> list, int CurrentPage, int PageSize){
        if ((CurrentPage-1)*PageSize > list.size() - 1 ) return null;
        else if (CurrentPage*PageSize > list.size())
            return list.subList((CurrentPage-1)*PageSize,list.size());
        return list.subList((CurrentPage-1)*PageSize,CurrentPage*PageSize);
    }
}
