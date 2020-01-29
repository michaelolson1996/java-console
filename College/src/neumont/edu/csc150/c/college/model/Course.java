package neumont.edu.csc150.c.college.model;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private String description;
    private ArrayList<Faculty> instructors = new ArrayList<>();

    public Course() {}

    public Course(String courseName, String description) {
        setCourseName(courseName);
        setDescription(description);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Faculty> getInstructors() { return instructors; }

    public void setInstructors(ArrayList instructors) { this.instructors = instructors; }

    public void addInstructor(Faculty instructor) {
        this.instructors.add(instructor);
    }

    @Override
    public String toString() {
        return "\nCourse Name: " + getCourseName() + "\n" + "Course Description: " + getDescription();
    }
}
