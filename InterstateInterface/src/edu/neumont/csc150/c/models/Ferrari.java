package edu.neumont.csc150.c.models;

import java.util.Objects;

public class Ferrari implements Vehicle {
    double speed;

    public Ferrari() {}

    public Ferrari(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Ferrari{" +
                "speed=" + speed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferrari ferrari = (Ferrari) o;
        return Double.compare(ferrari.speed, speed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed);
    }

    @Override
    public double accelerate() {
        this.speed += 10;
        return this.speed;
    }

    @Override
    public double brake() {
        if (this.speed - 10 <= 0)
            this.speed = 0;
        else
            this.speed -= 10;
        return this.speed;
    }
}
