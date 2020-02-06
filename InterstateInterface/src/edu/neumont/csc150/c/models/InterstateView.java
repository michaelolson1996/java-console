package edu.neumont.csc150.c.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

public class InterstateView {

    BufferedReader in;

    public InterstateView() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        in = new BufferedReader(inputStreamReader);
    }

    public void displayMainMenu() {
        System.out.println(
                "0 : Exit\r\n" +
                "1 : Accelerate\r\n" +
                "2 : Brake"
        );
    }

    public int getInputFromUser() throws IOException {
        String rawInput = in.readLine();
        int input = Integer.parseInt(rawInput);
        return input;
    }

    public void showMessage(String output) {
        System.out.println(output);
    }

    public void showVehicleStatus(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }
}
