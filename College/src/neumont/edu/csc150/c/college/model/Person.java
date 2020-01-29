package neumont.edu.csc150.c.college.model;

import java.time.LocalDate;

public class Person {
    protected String name;
    protected LocalDate birthday;

    public Person() {}

    public Person(String name, LocalDate birthday) {
        setName(name);
        setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nPerson Name: " + getName() + "\nBirthday: " + getBirthday();
    }
}
