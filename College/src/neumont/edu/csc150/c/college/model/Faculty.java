package neumont.edu.csc150.c.college.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Faculty extends PersonWithCourses {
    private int officeNum;
    private String officeHours;
    private boolean isFullTime;

    public Faculty() {}

    public Faculty(String name, LocalDate birthday, ArrayList courses, int officeNum, String officeHours, boolean isFullTime) {
        super(name, birthday, courses);
        setOfficeNum(officeNum);
        setOfficeHours(officeHours);
        setFullTime(isFullTime);
    }

    public int getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(int officeNum) {
        this.officeNum = officeNum;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public boolean getIsFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public void changeHours(String officeHours) {
        setOfficeHours(officeHours);
    }

    @Override
    public String toString() {
        return super.toString() + "Office Number: " + getOfficeNum() + "\nOffice Hours: " + getOfficeHours() +
                "\nIs full time: " + getIsFullTime();
    }
}
