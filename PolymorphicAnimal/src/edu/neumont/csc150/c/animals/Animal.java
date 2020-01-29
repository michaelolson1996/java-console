package edu.neumont.csc150.c.animals;

abstract public class Animal {
    private boolean hasTail;
    private int countLimbs;
    private String name;

    public Animal() {}

    public Animal(boolean hasTail, int countLimbs, String name) {
        this.setHasTail(hasTail);
        this.setCountLimbs(countLimbs);
        this.setName(name);
    }

    public boolean isHasTail() {
        return hasTail;
    }

    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }

    public int getCountLimbs() {
        return countLimbs;
    }

    public void setCountLimbs(int countLimbs) {
        if (countLimbs < 0)
            throw new IllegalArgumentException("Count Limbs cannot be negative");
        this.countLimbs = countLimbs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    @Override
    public String toString() {
        String str =
                String.format("Name = %s \nCount Limbs = %d \nHas Tail = %s",
                        this.getName(), this.getCountLimbs(), this.isHasTail());
        return str;
    }

    abstract public String speak();
}
