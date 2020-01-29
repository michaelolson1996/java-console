package neumont.edu.csc150.c.college.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends PersonWithCourses {
    private Staff advocate;
    private double gpa;

    public Student() {}

    public Student(String name, LocalDate birthday, ArrayList courses, double gpa, Staff advocate) {
        super(name, birthday, courses);
        setAdvocate(advocate);
        setGpa(gpa);
    }

    public Staff getAdvocate() {
        return advocate;
    }

    public void setAdvocate(Staff advocate) {
        this.advocate = advocate;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + "Advocate: " + getAdvocate().getName() + "\ngpa: " + getGpa();
    }
}
