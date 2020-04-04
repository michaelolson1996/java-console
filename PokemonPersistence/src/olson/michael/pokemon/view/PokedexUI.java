package olson.michael.pokemon.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class PokedexUI {

    public enum MenuItem {
        EXIT,
        CREATE_POKEMON,
        VIEW_POKEMON,
        SEARCH_POKEMON,
        LOAD_FROM_FILE
    }

    private BufferedReader in;

    public PokedexUI() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public MenuItem promptMenuSelection() throws IOException {
        // display the menu
        // read the selection
        String mainMenuString = buildMainMenuDisplay();
        displayMessage(mainMenuString);
        int sel = readInt(0, 4);
        return MenuItem.values()[sel];
    }

    private String buildMainMenuDisplay() {
        return String.format("Main Menu\r\n" +
                "1 - %s\r\n" +
                "2 - %s\r\n" +
                "3 - %s\r\n" +
                "4 - %s\r\n" +
                "0 - %s\r\n",
                MenuItem.CREATE_POKEMON, MenuItem.VIEW_POKEMON, MenuItem.SEARCH_POKEMON, MenuItem.LOAD_FROM_FILE, MenuItem.EXIT);
    }

    public String promptLoadFileName() throws IOException {
        displayMessage("enter text file name");
        return readString(1);
    }

    public int readInt(int min, int max) throws IOException {
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
        while (true) {
            String input = in.readLine();
            if (input.length() < minLength)
                displayError(String.format("The name must have at least %d characters", minLength));
            else
                return input;
        }
    }

    private LocalDate readDate (int minYear, int maxYear) throws IOException {
        displayMessage("Enter the year");
        int year = readInt(minYear, maxYear);
        displayMessage("Enter the month (1-12)");
        int month = readInt(1, 12);
        int maxDayInMonth = determineMaxDayInMonth(year, month);
        displayMessage(String.format("Enter the day (1-%d)", maxDayInMonth));
        int day = readInt(1, maxDayInMonth);
        return LocalDate.of(year, month, day);
    }

    private int determineMaxDayInMonth(int year, int month) {
        return LocalDate.of(year, month, 1)
                .plusMonths(1)
                .minusDays(1)
                .getDayOfMonth();
    }

    public LocalDate promptCaptureDate() throws IOException {
        displayMessage("Enter the capture date");
        return readDate(1970, LocalDate.now().getYear());
    }

    public int promptPokemonLevel() throws IOException {
        displayMessage("Enter the level");
        return readInt(0, 100);
    }

    public String promptPokemonName() throws IOException {
        displayMessage("Enter the name");
        return readString(1);
    }

    public void displayError(String msg) {
        System.err.println(msg);
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}