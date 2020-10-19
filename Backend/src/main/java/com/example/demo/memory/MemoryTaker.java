package com.example.demo.memory;
import com.example.demo.memory.SqlStep;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MemoryTaker extends SqlStateMemento {
    private Stack<SqlStateMemento> mementoStack = new Stack<>();

    public MemoryTaker(SqlStep state) {
        super(state);
    }

    public void addMemento(SqlStateMemento memento) {
        mementoStack.push(memento);
    }
    public SqlStateMemento getMemento(int idx){
        return mementoStack.pop();
    }
}
