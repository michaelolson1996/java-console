package edu.neumont.csc150.c.shapes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapeView {

    private BufferedReader in;

    public ShapeView() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        in = new BufferedReader(inputStreamReader);
    }

    public void displayMainMenu() {
        System.out.println(
                "1 : add square\r\n" +
                "2 : Add Circle\r\n" +
                "3 : Print All Shapes\r\n" +
                "4 : Add Right Triangle\r\n" +
                "0 : exit"
        );
    }

    public int getIntegerFromUser(int min, int max) throws IOException {
        String rawInput = in.readLine();
        int input = Integer.parseInt(rawInput);
        return input;
    }

    public double getDoubleFromUser(int min, int max) throws IOException {
        String rawInput = in.readLine();
        double input = Double.parseDouble(rawInput);
        return input;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
