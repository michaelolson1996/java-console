package edu.neumont.csc150.c.mutants.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class Mutant {
    public enum Affiliation {
        XMEN,
        BOEM
    }

    // polymorphism: poly = many, morph = change

    // protected allows for inheritance var access in children
    private String alias; // not null not empty
    private int health; // 0-100
    private double weight; // lbs
    private Affiliation affiliation; // null means solo
    private Random gen = new Random();
    private LocalDate birthday;

    public Mutant() {}

    public Mutant(String a, int h, double w, Affiliation af, LocalDate bd) {
        this.setAlias(a);
        this.setHealth(h);
        this.setWeight(w);
        this.setAffiliation(af);
        this.setBirthday(bd);
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        if (alias == null || alias.isEmpty())
            throw new IllegalArgumentException("Alias cannot be null or empty");
        this.alias = alias;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100)
            throw new IllegalArgumentException("Health must be between 0 and 100");
        this.health = health;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0)
            throw new IllegalArgumentException("Weight cannot be negative");
        this.weight = weight;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Name=" + this.getAlias() + " Health=" + this.getHealth() +
                " Weight=" + this.getWeight() + " Team=" + this.getAffiliation();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Mutant)) {
            return false;
        }
        Mutant other = (Mutant) obj;
        return this.getAlias().equals(other.getAlias()) && this.getHealth() == other.getHealth();
    }

    public String formattedBirthday() {
        return this.birthday.getMonthValue() + "/" +
                this.birthday.getDayOfMonth() + "/" +
                this.birthday.getYear();
    }

    // inferred method
    public int getAge() {
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthday, today);
        return age.getDays();
    }

    public void usePower() {
        System.out.println("I dont know my power");
    }

    protected void decreaseHealth(int min, int max) {
        int healthDecrease = gen.nextInt(max - min + 1) + min;
        this.setHealth(this.getHealth() - healthDecrease);
    }
}