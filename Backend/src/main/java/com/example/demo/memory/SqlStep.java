package com.example.demo.memory;

public class SqlStep {
    private String cmd;
    private int id;

    public SqlStep(String cmd, int id) {
        this.cmd = cmd;
        this.id = id;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
