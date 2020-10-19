package com.example.demo.memory;

public class SqlStateOriginator extends SqlStateMemento {
    private SqlStep state;

    public SqlStateOriginator(SqlStep state, SqlStep state1) {
        super(state);
        this.state = state1;
    }

    @Override
    public SqlStep getState() {
        return state;
    }

    public void setState(SqlStep state) {
        this.state = state;
    }

    public SqlStateMemento saveStateToMemento(){
        return new SqlStateMemento(state);
    }
    public void getStateFromMemento(SqlStateMemento State) {
        state = State.getState();
    }
}
