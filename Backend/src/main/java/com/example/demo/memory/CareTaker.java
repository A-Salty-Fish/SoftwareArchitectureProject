package com.example.demo.memory;


import java.util.Stack;

public class CareTaker {
    private Stack<Memento> mementoStack = new Stack<>();

    public void add(Memento state){
        mementoStack.push(state);
    }

    public Memento get(){
        return mementoStack.pop();
    }
}