package neumont.edu.csc150.c.college.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Staff extends Person {
    private String jobTitle;
    private ArrayList<Student> advisees = new ArrayList<>();

    public Staff() {}

    public Staff(String name, LocalDate birthday, String jobTitle) {
        super(name, birthday);
        setJobTitle(jobTitle);
    }

//    public String getName() { return name; }
//
//    public void setName(String name) { this.name = name; }

    public ArrayList<Student> getAdvisees() { return advisees; }

    public void setAdvisees(ArrayList<Student> advisees) { this.advisees = advisees; }

    public String getJobTitle() { return jobTitle; }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void assignToStudent(Student student) {
        advisees.add(student);
    }

    public String listStudents() {
        String studentListStr = "";
        for(int i = 0; i < this.advisees.size(); i++) {
            studentListStr += "\n";
            studentListStr += this.advisees.get(i).getName();
        }
        return studentListStr;
    }

    @Override
    public String toString() {
        return super.toString() + "\nJob Title: " + getJobTitle() + "\nAdvisees: " + listStudents();
    }
}
