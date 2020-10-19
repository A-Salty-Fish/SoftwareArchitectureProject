package com.example.demo.memory;

public class Memento {
    private SqlStep state;

    public Memento(SqlStep state){
        this.state = state;
    }

    public SqlStep getStep(){
        return state;
    }
}