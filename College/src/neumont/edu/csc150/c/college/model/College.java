package neumont.edu.csc150.c.college.model;

import java.util.ArrayList;

public class College {
    protected String name;
    protected ArrayList<Student> students = new ArrayList();
    protected ArrayList<Faculty> faculty = new ArrayList();
    protected ArrayList<Staff> staff = new ArrayList();

    public College() {}

    public College(String name, ArrayList students, ArrayList faculty, ArrayList staff) {
        setName(name);
        setStudents(students);
        setFaculty(faculty);
        setStaff(staff);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getStudents() {
        return students;
    }

    public void setStudents(ArrayList students) {
        this.students = students;
    }

    public ArrayList getFaculty() {
        return faculty;
    }

    public void setFaculty(ArrayList faculty) {
        this.faculty = faculty;
    }

    public ArrayList getStaff() {
        return staff;
    }

    public void setStaff(ArrayList staff) {
        this.staff = staff;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addFaculty(Faculty faculty) {
        this.faculty.add(faculty);
    }

    public void addStaff(Staff staff) {
        this.staff.add(staff);
    }

    public String listStudents() {
        String studentStr = "";
        for (int i = 0; i < this.students.size(); i++) {
            studentStr += "\n";
            studentStr += this.students.get(i).getName();
        }
        return studentStr;
    }

    public String listFaculty() {
        String facultyStr = "";
        for (int i = 0; i < this.faculty.size(); i++) {
            facultyStr += "\n";
            facultyStr += this.faculty.get(i).getName();
        }
        return facultyStr;
    }

    public String listStaff() {
        String staffStr = "";
        for (int i = 0; i < this.staff.size(); i++) {
            staffStr += "\n";
            staffStr += this.staff.get(i).getName();
        }
        return staffStr;
    }

    public void removeStudent(String student) {
        for(int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getName().equals(student)) {
                System.out.println("they matched");
                this.students.remove(i);
            }
        }
    }

    public void removeFaculty(String faculty) {
        for(int i = 0; i < this.faculty.size(); i++) {
            if (this.faculty.get(i).getName().equals(faculty)) {
                this.faculty.remove(i);
            }
        }
    }

    public void removeStaff(String staff) {
        for(int i = 0; i < this.staff.size(); i++) {
            if (this.staff.get(i).getName().equals(staff)) {
                this.staff.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "\nStudents: " + listStudents() + "\n\nFaculty: " + listFaculty() + "\n\nStaff: " + listStaff() + "\n";
    }
}
