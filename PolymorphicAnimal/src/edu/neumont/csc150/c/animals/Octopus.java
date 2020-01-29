package edu.neumont.csc150.c.animals;

public class Octopus extends Animal {

    public Octopus() {}

    public Octopus(boolean hasTail, int countLimbs, String name) {
        super(hasTail, countLimbs, name);
    }

    @Override
    public String speak() {
        return "blop blop";
    }
}
