package edu.neumont.csc150.c.fruit.model;

public class Apple extends Fruit {
    private boolean isFiji;

    public Apple() {}

    public Apple(String name, double weight, String color, boolean isJuicy, int numOfSeeds, boolean isFiji) {
        super(name, weight, color, isJuicy, numOfSeeds);
        setFiji(isFiji);
    }

    public boolean getFiji() {
        return isFiji;
    }

    public void setFiji(boolean fiji) {
        isFiji = fiji;
    }

    public void clean() {
        this.eliminateSeeds();
    }

    @Override
    public String toString() {
        return super.toString() + "Is Fiji: " + getFiji();
    }
}