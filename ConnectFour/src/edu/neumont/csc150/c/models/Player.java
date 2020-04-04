package edu.neumont.csc150.c.models;

public class Player {
    private String name;

    public Player() {}

    public Player(String n) {
        setName(n);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}