package com.example.demo.controller;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.example.demo.controller.SqlStep;
public class SqlStateMemento {
    private SqlStep state;

    public SqlStateMemento(SqlStep state) {
        this.state = state;
    }
    public SqlStep getState() {return state;}
}
