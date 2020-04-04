package edu.neumont.csc150.c.models;

public class Piece {

    private String color;

    public Piece() {}

    public Piece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "color='" + color + '\'' +
                '}';
    }
}
