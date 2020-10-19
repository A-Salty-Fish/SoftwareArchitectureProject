package com.example.demo.memory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SqlStateMemento {
    private SqlStep state;

    public SqlStateMemento(SqlStep state) {
        this.state = state;
    }
    public SqlStep getState() {return state;}
}
