package neumont.edu.csc150.c.college;

import neumont.edu.csc150.c.college.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CollegeCreatorUI {

    private BufferedReader userIn;

    public CollegeCreatorUI() {
        userIn = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getUserSelection(int min, int max) throws IOException {
        String rawInput = userIn.readLine();
        int input = Integer.parseInt(rawInput);
        return input;
    }

    public void displayMainMenu() {
        System.out.println(
                "1 - Rename College\r\n" +
                "2 - Add Student\r\n" +
                "3 - Add Staff\r\n" +
                "4 - Add Faculty\r\n" +
                "5 - View Student\r\n" +
                "6 - View Staff\r\n" +
                "7 - View Faculty\r\n" +
                "8 - View School\r\n" +
                "9 - Delete Student\r\n" +
                "10 - Delete Staff\r\n" +
                "11 - Delete Faculty\r\n" +
                "0 - Exit\r\n"
        );
    }

    public void displayPrompt(String prompt) {
        System.out.println(prompt);
    }

    public String getStringInput() throws IOException {
        return userIn.readLine();
    }

    public void displayPersonList(List<Object> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
