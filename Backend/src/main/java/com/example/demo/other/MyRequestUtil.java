package com.example.demo.other;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.ServletRequestDataBinder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class MyRequestUtil {
    public static <T> T getParameterObject(HttpServletRequest request,Class<T> tClass){
        try{
            T result = tClass.newInstance();
            ServletRequestDataBinder binder = new ServletRequestDataBinder(result);
            binder.bind(request);
            return result;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
