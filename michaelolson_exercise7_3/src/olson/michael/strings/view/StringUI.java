package olson.michael.strings.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringUI {

    public enum MenuItem {
        EXIT,
        ENTER_MESSAGE,
        READ_MESSAGE
    }

    private BufferedReader in;

    public StringUI() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public MenuItem promptMenuSelection() throws IOException {
        String mainMenuString = buildMainMenuDisplay();
        displayMessage(mainMenuString);
        int sel = readInt(0,2);
        return MenuItem.values()[sel];
    }

    private String buildMainMenuDisplay() {
        return String.format("Main Menu\r\n" +
                "1 - %s\r\n" +
                "2 - %s\r\n" +
                "3 - %s\r\n",
                MenuItem.ENTER_MESSAGE, MenuItem.READ_MESSAGE, MenuItem.EXIT);
    }

    public int readInt(int min, int max) throws IOException {
        while(true) {
            String rawInput = in.readLine();
            try {
                int input = Integer.parseInt(rawInput);
                if (input < min || input > max)
                    throw new NumberFormatException();
            } catch(NumberFormatException ex) {
                displayError(String.format("You must enter an integer between %d and %d", min, max));
            }
        }
    }

    private String readString(int minLength) throws IOException {
        while(true) {
            String input = in.readLine();
            if (input.length() < minLength)
                displayError(String.format("The name must have at least %d characters", minLength));
            else
                return input;
        }
    }

    public String promptMessage() throws IOException {
        displayMessage("Enter a message");
        return readString(1);
    }

    public void displayError(String msg) {
        System.err.println(msg);
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}
