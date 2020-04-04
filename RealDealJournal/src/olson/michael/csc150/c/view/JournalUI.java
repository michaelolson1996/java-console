package olson.michael.csc150.c.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class JournalUI {

    private BufferedReader in;

    public JournalUI() { in = new BufferedReader(new InputStreamReader(System.in)); }

    public enum MenuChoice {
        EXIT,
        VIEW_ENTRY_BY_DATE,
        VIEW_ENTRIES_BY_RANGE,
        GENERATE_ENTRY_FOR_TODAY,
        GENERATE_ENTRY_WITH_DATE
    }

    public MenuChoice promptMenuSelection() throws IOException {
        String mainMenuStr = buildMainMenuDisplay();
        displayMessage(mainMenuStr);
        int selection = readInt(0, 4);
        return MenuChoice.values()[selection];
    }

    private String buildMainMenuDisplay() {
        return String.format("Main Menu\r\n" +
                "[1] - %s\r\n" +
                "[2] - %s\r\n" +
                "[3] - %s\r\n" +
                "[4] - %s\r\n" +
                "[0] - %s\r\n",
                MenuChoice.VIEW_ENTRY_BY_DATE, MenuChoice.VIEW_ENTRIES_BY_RANGE, MenuChoice.GENERATE_ENTRY_FOR_TODAY, MenuChoice.GENERATE_ENTRY_WITH_DATE, MenuChoice.EXIT
        );
    }

    public int promptYesOrNoSelection() throws IOException {
        String yesNoStr = yesNoMenuDisplay();
        displayMessage(yesNoStr);
        int selection = readInt(0, 1);
        return selection;
    }

    private String yesNoMenuDisplay() {
        return "[0] yes\r\n[1] no";
    }

    private int readInt(int min, int max) throws IOException {
        while(true) {
            String rawInput = in.readLine();
            try {
                int input = Integer.parseInt(rawInput);
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
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

    private LocalDate readDate(int minYear, int maxYear) throws IOException {
        displayMessage("Enter the year");
        int year = readInt(minYear, maxYear);
        displayMessage("Enter the month (1 - 12)");
        int month = readInt(1, 12);
        int maxDayInMonth = determineMaxDayInMonth(year, month);
        displayMessage(String.format("Enter the day (1 - %d)", maxDayInMonth));
        int day = readInt(1, maxDayInMonth);
        return LocalDate.of(year, month, day);
    }

    private int determineMaxDayInMonth(int year, int month) {
        return LocalDate.of(year, month, 1)
                .plusMonths(1)
                .minusDays(1)
                .getDayOfMonth();
    }

    public LocalDate promptDate() throws IOException {
        displayMessage("Enter the entry date");
        return readDate(1920, LocalDate.now().getYear());
    }

    public void displayError(String msg) {
        System.err.println(msg);
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public String receiveUserInput() throws IOException {
        return in.readLine();
    }
}
