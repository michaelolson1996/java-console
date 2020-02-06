package edu.neumont.csc150.c.models;

import java.util.Objects;

public class Jeep implements Vehicle {
    double speed;

    public Jeep() {}

    public Jeep(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double accelerate() {
        this.speed += 5;
        return this.speed;
    }

    @Override
    public double brake() {
        if (this.speed - 5 <= 0)
            this.speed = 0;
        else
            this.speed -= 5;
        return this.speed;
    }

    @Override
    public String toString() {
        return "Jeep{" +
                "speed=" + speed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jeep jeep = (Jeep) o;
        return Double.compare(jeep.speed, speed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed);
    }
}
