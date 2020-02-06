package neumont.csc150.c.zombie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZombieCreatorUI {

    private BufferedReader userInput;

    public ZombieCreatorUI() { userInput = new BufferedReader( new InputStreamReader(System.in) ); }

    public void displayMenu() {
        System.out.println(
                "[1] Create a random zombie\n" +
                "[2] Create several random zombies\n" +
                "[3] Create a specified Number of zombies\n" +
                "[0] Exit"
        );
    }

    public void displayPrompt(String prompt) { System.out.println(prompt); }

    public String getStringInput() throws IOException { return userInput.readLine(); }
}
