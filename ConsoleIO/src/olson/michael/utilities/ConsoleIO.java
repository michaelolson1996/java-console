package olson.michael.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A utility class to simplify the process or interacting with the user
 * via the system console.
 */
public class ConsoleIO {

    /* PRO TIP: If you structure your code carefully, you only need to access your BufferedReader in the promptForInput() method.
     *  Doing so helps your code be as DRY as possible.
     */

    /**
     * A buffered reader object for internal use reading user input from the console
     */
    private BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Generates a prompt that allows the user to enter any response and returns the String.
     * @param prompt the prompt to be displayed to the user.
     * @param minLength the minimum length required for the user response string
     * @return the input from the user as a String
     */
    public String promptForString(String prompt, int minLength){
        String input = null;
        boolean isInvalid = true;

        do {
            displayMessage(prompt);

            try {
                input = consoleIn.readLine();
                isInvalid = input == null || input.trim().length() < minLength;

                if(isInvalid) {
                    displayError(String.format("Your input must have at least %d characters. Please, try again.", minLength));
                }
            }
            catch(IOException ex) {
                displayError("There was a technical issue. Please, try again.");
            }

        } while(isInvalid);

        return input;
    }

    /**
     * Generates a prompt that expects a numeric input representing an int value.
     * This method loops until valid input is given.
     * @param prompt the prompt to be displayed to the user
     * @param min the inclusive minimum boundary
     * @param max the inclusive maximum boundary
     * @return the int value
     */
    public int promptForInt(String prompt, int min, int max){
        int userNum = 0;
        boolean isInvalid = true;

        do {
            String input = promptForString(prompt,1);
            try {
                userNum = Integer.parseInt(input);
                isInvalid = userNum < min || userNum > max;
            }
            catch(NumberFormatException ex){
                isInvalid = true;
            }

            if(isInvalid) {
                displayError(String.format("You must enter a number between %d and %d. Please, try again.", min, max));
            }
        } while(isInvalid);

        return userNum;
    }

    /**
     * Generates a prompt that expects the user to enter one of two responses that will equate
     * to a boolean value. The trueString represents the case insensitive response that will equate to true.
     * The falseString acts similarly, but for a false boolean value.
     * 		Example: Assume this method is called with a trueString argument of "yes" and a falseString argument of
     * 		"no". If the enters "YES", the method returns true. If the user enters "no", the method returns false.
     * 		All other inputs are considered invalid, the user will be informed, and the prompt will repeat.
     * @param prompt - the prompt to be displayed to the user
     * @param trueString - the case insensitive value that will evaluate to true
     * @param falseString - the case insensitive value that will evaluate to false
     * @return the boolean value
     */
    public boolean promptForBoolean(String prompt, String trueString, String falseString){
        //TODO Implement this method with the proper logic
        boolean isInvalid = true;
        boolean returnedBool = true;
        do {
            String input = promptForString(prompt, 2);
            if (input.equals(trueString)) {
                returnedBool = true;
                isInvalid = false;
            } else if (input.equals(falseString)) {
                returnedBool = false;
                isInvalid = false;
            } else {
                displayError(String.format("You must enter either %s or %s. Please, try again.", trueString, falseString));
            }
        } while (isInvalid);
        return returnedBool;
    }


    /**
     * Treats the options parameter as a collection of menu options to be displayed
     * to the user in order of index; indexes containing null values are skipped
     * to allow for 1-based menu selection.
     * This method will only allow the user to enter valid selections within the bounds of the array
     * and not matching any index with null values.
     * @param options an array of string menu options to be presented to the user in index order
     * @return the index selected by the user
     */
    public int promptForMenuSelection(String[] options){
        //TODO Implement this method with the proper logic
        String buildMenu = "";
        int optionCount = 0;
        boolean isInvalid = true;
        for (int i = 0; i < options.length; i++) {
            if (options[i] != null) {
                buildMenu += String.format("[%d] %s", optionCount, options[optionCount]);
                optionCount++;
            } else {
                continue;
            }
        }
        int userInt = promptForInt(buildMenu, 0, optionCount);
        return userInt;
    }

    /**
     * Displays the parameter message to the user as informational
     * @param msg the message to be displayed
     */
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    /**
     * Displays the parameter error message to the user in error mode
     * @param err the error message to be displayed
     */
    public void displayError(String err) {
        System.err.println(err);
    }
}