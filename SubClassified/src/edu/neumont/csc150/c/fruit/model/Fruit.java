package edu.neumont.csc150.c.fruit.model;

public class Fruit {
    protected String name;
    protected double weight;
    protected String color;
    protected boolean isJuicy;
    protected int numOfSeeds;

    public Fruit() {}

    public Fruit(String name, double weight, String color, boolean isJuicy, int numOfSeeds) {
        setName(name);
        setWeight(weight);
        setColor(color);
        setJuicy(isJuicy);
        setNumOfSeeds(numOfSeeds);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isJuicy() {
        return isJuicy;
    }

    public void setJuicy(boolean juicy) {
        isJuicy = juicy;
    }

    public int getNumOfSeeds() {
        return numOfSeeds;
    }

    public void setNumOfSeeds(int numOfSeeds) {
        this.numOfSeeds = numOfSeeds;
    }

    protected void eliminateSeeds() {
        if (numOfSeeds > 0) {
            numOfSeeds = 0;
            System.out.println("The seeds have been eliminated");
        } else {
            System.out.println("No seeds to eliminate");
        }
    }

    @Override
    public String toString() {
        return "Fruit Name: " + getName() + "\nFruit Color: " + getColor() + "\nFruit Weight: " + getWeight() +
                "\nFruit Seeds Count: " + getNumOfSeeds() + "\nFruit is Juicy: " + isJuicy() + "\n";
    }
}
