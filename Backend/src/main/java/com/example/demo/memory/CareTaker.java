package com.example.demo.memory;


import com.example.demo.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Stack;

public class CareTaker<T> {
    private Stack<Memento> mementoStack = new Stack<>();
    private Stack<T> dataStack = new Stack<T>();

    public void addState(Memento state){
        //将最新状态入栈
        mementoStack.push(state);
    }

    public Memento getState(){
        //出栈
        if (!mementoStack.empty())
            return mementoStack.pop();
        //栈为空返回空状态 空状态由配置文件定义
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SqlStep defaultSqlStep = (SqlStep)context.getBean("DefaultSqlStep");
        return new Memento(defaultSqlStep);
    }

    public void addData(T data){
        dataStack.push(data);
    }

    public T getData()
    {
        if (!dataStack.empty())
            return dataStack.pop();
        return null;
    }

}