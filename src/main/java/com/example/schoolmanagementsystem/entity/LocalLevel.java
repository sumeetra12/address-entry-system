package com.example.schoolmanagementsystem.entity;

public class LocalLevel {
    private int id;
    private String name;
    private State state;

    public LocalLevel(){

    }
    public LocalLevel(int id, String name, int stateId){
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
