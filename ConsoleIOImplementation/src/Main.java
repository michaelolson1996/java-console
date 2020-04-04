import olson.michael.utilities.ConsoleIO;

public class Main {
    public static void main(String[] args) {
        ConsoleIO cio = new ConsoleIO();
        int value = cio.promptForInt("give me an int between 4 and 9", 4, 9);
        cio.displayMessage(String.format("The value you entered was %d", value));
        boolean userChoosesBool = cio.promptForBoolean("please type true or false", "true", "false");
        cio.displayMessage(String.format("You chose %s", userChoosesBool));
        cio.promptForString("Enter a minimum of 5 letters", 5);
        String[] options = {
                "click zero",
                "click one",
                "click two",
                "click three",
                "click four",
                "click five"
        };
        int returnVal = cio.promptForMenuSelection(options);
        cio.displayMessage(String.format("You chose %d", returnVal));
    }
}
