package neumont.edu.csc150.c.college.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class PersonWithCourses extends Person {
    protected ArrayList<Course> courses = new ArrayList();

    public PersonWithCourses() {}

    public PersonWithCourses(String name, LocalDate birthday, ArrayList courses) {
        super(name, birthday);
        setCourses(courses);
    }

    public ArrayList getCourses() {
        return this.courses;
    }

    public void setCourses(ArrayList courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void deleteCourse(Course course) {
        for(int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).getCourseName().equals(course.getCourseName())) {
                this.courses.remove(i);
            }
        }
    }

    public String listCourses() {
        String courseStr = "";
        for(int i = 0; i < courses.size(); i ++) {
            courseStr += courses.get(i).getCourseName();
            courseStr += "\n";
        }
        return courseStr;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCourses: " + listCourses();
    }
}
