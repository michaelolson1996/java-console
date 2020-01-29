package edu.neumont.csc150.c.mutants.model;

import java.time.LocalDate;
import java.util.Random;

public class QuickMutant extends Mutant {

    private double speed;

    public QuickMutant() {}

    public QuickMutant(String a, int h, double w, Affiliation af, LocalDate birthday, double speed) {
        super(a, h, w, af, birthday);
        this.setSpeed(speed);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.speed = speed;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Speed=" + this.getSpeed();
    }

    @Override
    public void usePower() {
        System.out.println("I'm running " + this.getSpeed() + " mph.");
        this.decreaseHealth(1, 4);
    }

    public void runSuperFast() {
        System.out.println("I'm running super fast (" + (this.getSpeed() * 2) + " mph.)");
        this.decreaseHealth(4, 16);
    }

}