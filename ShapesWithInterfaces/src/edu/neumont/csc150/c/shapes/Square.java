package edu.neumont.csc150.c.shapes;

import java.util.Objects;

public class Square implements Areable, Perimiterable {
    private double sideLength;

    public Square() {};

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return this.sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength);
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }
}
