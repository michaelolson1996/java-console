package edu.neumont.csc150.c.animals;

public class Snake extends Animal {

    public Snake() {}

    public Snake(boolean hasTail, int countLimbs, String name) {
        super(hasTail, countLimbs, name);
    }

    @Override
    public String speak() {
        return "Hisss";
    }
}
