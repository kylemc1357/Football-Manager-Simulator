package com.simulator.entity;

public class Player extends Entity{
    private String position;

    public Player(String name, String position){
        super(name);
        this.position = position;
    }
}
