package edu.neumont.csc150.c.animals;

public class Giraffe extends Animal {

    public Giraffe() {};

    public Giraffe(boolean hasTail, int countLimbs, String name) {
        super(hasTail, countLimbs, name);
    }

    @Override
    public String speak() {
        return "Rawr";
    }
}
