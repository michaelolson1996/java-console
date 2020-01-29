package neumont.edu.csc150.c.college;

import neumont.edu.csc150.c.college.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CollegeCreator {

    private CollegeCreatorUI ui = new CollegeCreatorUI();
    private College college = new College();

    public void run() throws IOException {
        boolean userRequestedExit = false;
        while (!userRequestedExit) {
            ui.displayMainMenu();
            int selection = ui.getUserSelection(0, 6);

            switch(selection) {
                case 0:
                    System.out.println("Good bye");
                    userRequestedExit = true;
                    break;
                case 1:
                    renameCollege();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    addStaffMember();
                    break;
                case 4:
                    addFacultyMember();
                    break;
                case 5:
                    viewStudents();
                    break;
                case 6:
                    viewStaffMembers();
                    break;
                case 7:
                    viewFaculty();
                    break;
                case 8:
                    viewNames();
                    break;
                case 9:
                    deleteStudents();
                    break;
                case 10:
                    deleteStaff();
                    break;
                case 11:
                    deleteFaculty();
                    break;
                default:
                    System.out.println("I was not expecting this number");
                    break;
            }
        }
    }

    private void renameCollege() throws IOException {
        ui.displayPrompt("Enter a new College name");
        String newName = ui.getStringInput();
        this.college.setName(newName);
        ui.displayPrompt("College name now '" + this.college.getName() + "'");
    }

    private void addStudent() {
        try {
            ui.displayPrompt("Enter a name for the student");
            String name = ui.getStringInput();
            ui.displayPrompt("Enter in the current gpa of the student");
            double gpa = Double.parseDouble(ui.getStringInput());
            Student newStudent = new Student(name, LocalDate.now(), new ArrayList<Course>(), gpa, new Staff());
            this.college.getStudents().add(newStudent);
        } catch(Exception err) {
            System.out.println("There was an error, please try again :)");
        }
    }

    private void addStaffMember() throws IOException {
        ui.displayPrompt("Enter a name for the staff member");
        String name = ui.getStringInput();
        ui.displayPrompt("Enter a job title");
        String jobTitle = ui.getStringInput();
        Staff newStaffMember = new Staff(name, null, jobTitle);
        this.college.getStaff().add(newStaffMember);
    }

    private void addFacultyMember() {
        try {
            ui.displayPrompt("Enter a name for the faculty member");
            String name = ui.getStringInput();
//        ui.displayPrompt("Enter a birth date in this format: MM/DD/YYYY");
//        String birthday = ui.getStringInput();
            ui.displayPrompt("Enter in Office Number for faculty member");
            int officeNum = Integer.parseInt(ui.getStringInput());
            ui.displayPrompt("Please enter office hours for faculty member");
            String officeHours = ui.getStringInput();
            ui.displayPrompt("Is this faculty member full-time?\n0 : no\n1 : yes");
            boolean isFulltime = Integer.parseInt(ui.getStringInput()) == 0 ? false : true;
            Faculty newFaculty = new Faculty(name, LocalDate.now(), new ArrayList<Course>(), officeNum, officeHours, isFulltime);
            this.college.getFaculty().add(newFaculty);
        } catch(Exception err) {
            System.out.println("There was an error, please try again :)");
        }
    }

    private void viewStudents() {
        List<Object> printable = new ArrayList<>();
        for (Object s : this.college.getStudents()) {
            printable.add(s);
        }
        ui.displayPersonList(printable);
    }

    private void viewStaffMembers() {
        List<Object> printable = new ArrayList<>();
        for (Object s : this.college.getStaff()) {
            printable.add(s);
        }
        ui.displayPersonList(printable);
    }

    private void viewFaculty() {
        List<Object> printable = new ArrayList<>();
        for (Object s : this.college.getFaculty()) {
            printable.add(s);
        }
        ui.displayPersonList(printable);
    }

    public void viewNames() {
        ui.displayPrompt(this.college.toString());
    }

    private void deleteStudents() {
        try {
            ui.displayPrompt("Enter the name of the student you wish to delete");
            String nd = ui.getStringInput();
            this.college.removeStudent(nd);
        } catch (Exception err) {
            ui.displayPrompt("There seemed to be an issue removing that student");
        }
    }

    private void deleteStaff() {
        try {
            ui.displayPrompt("Enter the name of the staff member you wish to delete");
            this.college.removeStaff(ui.getStringInput());
        } catch (Exception err) {
            ui.displayPrompt("There seemed to be an issue removing that staff member");
        }
    }

    private void deleteFaculty() {
        try {
            ui.displayPrompt("Enter the name of the faculty member you wish to delete");
            this.college.removeFaculty(ui.getStringInput());
        } catch (Exception err) {
            ui.displayPrompt("There seemed to be an issue removing that faculty member");
        }
    }

    public static void main(String[] args) throws IOException {
        CollegeCreator cc = new CollegeCreator();
        cc.run();
    }
}
