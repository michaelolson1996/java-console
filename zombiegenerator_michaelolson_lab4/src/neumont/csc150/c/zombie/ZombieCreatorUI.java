package neumont.csc150.c.zombie;

import neumont.csc150.c.zombie.model.Zombie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ZombieCreatorUI {

    private BufferedReader userInput;

    public ZombieCreatorUI() { userInput = new BufferedReader( new InputStreamReader(System.in) ); }

    public void displayMenu() {
        System.out.println(
                "[1] Create a random zombie" +
                "[2] Create several random zombies" +
                "[3] Create a specified Number of zombies" +
                "[0] Exit"
        );
    }

    public void displayPrompt(String prompt) { System.out.println(prompt); }

    public String getStringInput() throws IOException { return userInput.readLine(); }

    public void displayZombies(List<Zombie> zombies) {
        for (Zombie z : zombies) {
            System.out.println(z);
        }
    }
}
