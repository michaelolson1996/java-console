package edu.neumont.csc150.c.fruit.model;

public class Orange extends Fruit {
    private double peelThickness;

    public Orange() {}

    public Orange(String name, double weight, String color, boolean isJuicy, int numOfSeeds, double peelThickness) {
        super(name, weight, color, isJuicy, numOfSeeds);
        setPeelThickness(peelThickness);
    }

    public double getPeelThickness() {
        return peelThickness;
    }

    public void setPeelThickness(double peelThickness) {
        this.peelThickness = peelThickness;
    }

    public void clean() {
        this.eliminateSeeds();
    }

    @Override
    public String toString() {
        return super.toString() + "Peel Thickness: " + getPeelThickness();
    }
}
