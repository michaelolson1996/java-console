package edu.neumont.csc150.c.animals;

public class Hedgehog extends Animal {

    public Hedgehog() {}

    public Hedgehog(boolean hasTail, int countLimbs, String name) {
        super(hasTail, countLimbs, name);
    }

    @Override
    public String speak() {
        return "chchchch";
    }
}
