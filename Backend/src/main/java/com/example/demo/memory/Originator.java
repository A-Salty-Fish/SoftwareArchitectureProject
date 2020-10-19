package com.example.demo.memory;

public class Originator {
    private SqlStep state;

    public void setState(SqlStep state){
        this.state = state;
    }

    public SqlStep getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}