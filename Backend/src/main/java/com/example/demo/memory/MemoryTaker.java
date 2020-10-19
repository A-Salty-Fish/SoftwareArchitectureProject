package com.example.demo.controller;
import org.apache.ibatis.session.SqlSession;
import com.example.demo.controller.SqlStateMemento;
import com.example.demo.controller.SqlStep;
import java.util.ArrayList;
import java.util.List;

public class MemoryTaker extends SqlStateMemento {
    private List<SqlStateMemento> mementoList = new ArrayList<SqlStateMemento>();

    public MemoryTaker(SqlStep state) {
        super(state);
    }

    public void addMemento(SqlStateMemento memento) {
        mementoList.add(memento);
    }
    public SqlStateMemento getMemento(int idx){
        return mementoList.get(idx);
    }
}
