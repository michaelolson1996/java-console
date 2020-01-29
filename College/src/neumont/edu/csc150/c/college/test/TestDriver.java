package neumont.edu.csc150.c.college.test;

import neumont.edu.csc150.c.college.model.Student;
import neumont.edu.csc150.c.college.model.Course;
import neumont.edu.csc150.c.college.model.Faculty;
import neumont.edu.csc150.c.college.model.Staff;
import neumont.edu.csc150.c.college.model.College;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestDriver {
    public static void main(String[] args) throws IOException {
        TestDriver td = new TestDriver();
        td.test();
    }

    public void test() throws IOException {

        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in)
        );

        System.out.println("Please enter a name for your college");
        String collegeName = in.readLine();
        College college = new College();
        college.setName(collegeName);

        System.out.println("You have successfully created your college. Here is the current status...");
        System.out.println(college.toString());

        boolean isActive = true;

        while (isActive) {
            System.out.println("What would you like to do?");
            System.out.println("[a] Read the list");
            System.out.println("[b] Add to the list");
            String choice = in.readLine();

            switch(choice) {
                case "a": {
                    System.out.println(college.toString());
                } case "b": {
                    System.out.println("What would you like to add?");
                    System.out.println("[a] Add a Student");
                    System.out.println("[b] Add a Faculty");
                    System.out.println("[c] Add a Staff");
                    String addChoice = in.readLine();

                    switch(addChoice) {
                        case "a": {
                            System.out.println("Please add a name of Student");
                            String name = in.readLine();
                            System.out.println("Please add a birth year");
                            String year = in.readLine();
                            System.out.println("Please add a birth month");
                            String month = in.readLine();
                            System.out.println("Please add a birthday");
                            String day = in.readLine();
                            System.out.println("Please add a gpa");
                            String gpa = in.readLine();
                            college.addStudent(new Student(name, LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)), new ArrayList<Course>(), Double.parseDouble(gpa), new Staff()));
                            break;
                        } case "b": {
                            System.out.println("Please add a name of Faculty");
                            String name = in.readLine();
                            System.out.println("Please add a birth year");
                            String year = in.readLine();
                            System.out.println("Please add a birth month");
                            String month = in.readLine();
                            System.out.println("Please add a birthday");
                            String day = in.readLine();
                            System.out.println("Please enter an office number");
                            String officeNum = in.readLine();
                            System.out.println("Please enter office hours");
                            String officeHours = in.readLine();
                            boolean determineFullTime = true;
                            boolean isFullTime;
                            while (determineFullTime) {
                                System.out.println("Is this faculty member fulltime?");
                                System.out.println("[a] yes");
                                System.out.println("[b] no");
                                String fullTime = in.readLine();
                                switch (fullTime) {
                                    case "a": {
                                        isFullTime = true;
                                        college.addFaculty(new Faculty(name, LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)), new ArrayList<Course>(), Integer.parseInt(officeNum), officeHours, isFullTime));
                                        determineFullTime = false;
                                    } case "b": {
                                        isFullTime = false;
                                        college.addFaculty(new Faculty(name, LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)), new ArrayList<Course>(), Integer.parseInt(officeNum), officeHours, isFullTime));
                                        determineFullTime = false;
                                    } default: {
                                        System.out.println("Please enter a valid answer");
                                    }
                                }
                            }
                            break;
                        } case "c": {
                            System.out.println("Please add a name of Staff");
                            System.out.println("");
                            System.out.println("");
                            break;
                        } default: {

                        }
                    }
                } default: {

                }
            }
        }



//        Course oop = new Course("csc150", "Object Oriented Programming");
//        System.out.println("2. Initialize Course");
//        System.out.println(oop.toString());
//
//        Course personalityDevelopment = new Course("ssc250", "Human Relations and Personality Development");
//        Course productivityToolkit = new Course("bit105", "Productivity Toolkit");
//
//        Faculty ryanCox = new Faculty();
//        ryanCox.setName("Ryan Cox");
//        ryanCox.setBirthday(LocalDate.of(1980, 4, 9));
//        ryanCox.setFullTime(true);
//        ryanCox.setOfficeHours("10:00am - 12:00pm");
//        ryanCox.setOfficeNum(12);
//        ryanCox.addCourse(oop);
//
//        System.out.println("\nInitialize Instructor 1");
//        System.out.println(ryanCox.toString());
//
//        System.out.println("\nAdd Instructor to College");
//        college.addFaculty(ryanCox);
//        System.out.println(college.toString());
//
//        Faculty joshKrebbs = new Faculty();
//        joshKrebbs.setName("Josh Krebbs");
//        joshKrebbs.setBirthday(LocalDate.of(1981, 3, 23));
//        joshKrebbs.setFullTime(true);
//        joshKrebbs.setOfficeHours("12:00am - 1:00pm");
//        joshKrebbs.setOfficeNum(3);
//        joshKrebbs.addCourse(oop);
//
//        System.out.println("\nInitialize Instructor 2");
//        System.out.println(joshKrebbs.toString());
//        college.addFaculty(joshKrebbs);
//
//        Faculty troyHunter = new Faculty();
//        troyHunter.setName("Troy Hunter");
//        troyHunter.setBirthday(LocalDate.of(1980, 4, 27));
//        troyHunter.setFullTime(false);
//        troyHunter.setOfficeHours(null);
//        troyHunter.setOfficeNum(0);
//        troyHunter.addCourse(productivityToolkit);
//        college.addFaculty(troyHunter);
//
//        System.out.println("\nInitialize Instructor 3");
//        System.out.println(troyHunter.toString());
//
//        Faculty johnSmith = new Faculty(
//                "John Smith",
//                LocalDate.of(1990, 4, 4),
//                new ArrayList<Course>(),
//                14,
//                "5:00pm - 7:00pm",
//                true
//        );
//        johnSmith.addCourse(oop);
//        johnSmith.addCourse(personalityDevelopment);
//        college.addFaculty(johnSmith);
//
//        System.out.println("\nInitialize Instructor 4");
//        System.out.println(johnSmith.toString());
//
//        oop.addInstructor(ryanCox);
//        oop.addInstructor(joshKrebbs);
//        oop.addInstructor(johnSmith);
//        personalityDevelopment.addInstructor(johnSmith);
//        productivityToolkit.addInstructor(troyHunter);
//
//        System.out.println("\nInitialize Staff Member 1");
//        Staff joseph = new Staff("Joseph Bloo", LocalDate.of(1999, 3, 24), "Student Advocate");
//        System.out.println(joseph.toString());
//
//        System.out.println("\nInitialize Staff member 2");
//        Staff jessica = new Staff("Jessica Brown", LocalDate.of(1996, 2, 3), "Student Advocate");
//        System.out.println(jessica.toString());
//
//        System.out.println("\nInitialize Staff member 3");
//        Staff ellie = new Staff("Ellie Gold", LocalDate.of(1994, 5, 6), "Student Advocate");
//        System.out.println(ellie.toString());
//
//        System.out.println("\nAdd Staff to college");
//        college.addStaff(joseph);
//        college.addStaff(jessica);
//        college.addStaff(ellie);
//        System.out.println(college.toString());
//
//        System.out.println("\nInitialize Student 1");
//        Student michael = new Student();
//        michael.setName("Michael Olson");
//        michael.setGpa(4.0);
//        michael.setBirthday(LocalDate.of(1996, 7, 23));
//        michael.setAdvocate(ellie);
//        michael.addCourse(oop);
//        michael.addCourse(productivityToolkit);
//        michael.addCourse(personalityDevelopment);
//        ellie.assignToStudent(michael);
//        System.out.println(michael.toString());
//
//        System.out.println("\nInitialize Student 2");
//        Student joe = new Student("Joe Bob", LocalDate.of(1984, 4, 7), new ArrayList<Course>(), 2.17, ellie);
//        joe.addCourse(oop);
//        joe.addCourse(productivityToolkit);
//        ellie.assignToStudent(joe);
//        System.out.println(joe.toString());
//
//        System.out.println("\nInitialize Student 3");
//        Student john = new Student("Johnny Bob Good", LocalDate.of(1944, 5, 17), new ArrayList<Course>(), 2.17, joseph);
//        john.addCourse(oop);
//        System.out.println(john.toString());
//
//        System.out.println("\nAssign Advocates to Advisees");
//
//        System.out.println(joseph.toString());
//        joseph.assignToStudent(john);
//        System.out.println(joseph.toString());
//
//        System.out.println("\nAdd students to College");
//        college.addStudent(michael);
//        college.addStudent(joe);
//        college.addStudent(john);
//
//        System.out.println(college.toString());
//
//        System.out.println("Change office hours");
//        System.out.println(ryanCox.toString());
//        ryanCox.changeHours("5:00pm - 7:00pm");
//        System.out.println(ryanCox.toString());
//
//        System.out.println("Remove a course from student");
//        System.out.println(michael.toString());
//        michael.deleteCourse(oop);
//        System.out.println(michael.toString());
//
//        System.out.println("\nRemove a student, faculty, and staff from college");
//        System.out.println(college.toString());
//        college.removeStudent(michael);
//        college.removeFaculty(joshKrebbs);
//        college.removeStaff(ellie);
//        System.out.println(college.toString());

    }
}
