package olson.michael.csc150.c.controller;

import olson.michael.csc150.c.model.JournalEntry;
import olson.michael.csc150.c.view.JournalUI;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JournalManager {
    private JournalUI ui;
    private final static String journalFile = "journal.txt";
    private List<JournalEntry> journalEntryList = new ArrayList<>();

    public JournalManager() throws IOException {
        loadJournalEntries();
    }

    private void startJournal() throws IOException {
        boolean userRequestedExit = false;

        while(!userRequestedExit) {
            JournalUI.MenuChoice selection = ui.promptMenuSelection();
            switch(selection) {
                case EXIT:
                    userRequestedExit = true;
                    break;
                case VIEW_ENTRY_BY_DATE:
                    getJournalEntry();
                    break;
                case VIEW_ENTRIES_BY_RANGE:
                    getRangeOfJournalEntries();
                    break;
                case GENERATE_ENTRY_FOR_TODAY:
                    generateEntryToday();
                    break;
                case GENERATE_ENTRY_WITH_DATE:
                    generateEntryByDate();
                    break;
            }
        }
    }

    private void getJournalEntry() throws IOException {
        LocalDate userInput = ui.promptDate();
        int entryCount = 0;
        for (JournalEntry s : this.journalEntryList) {
            if (s.getDate().isEqual(userInput)) {
                ui.displayMessage("Here is your entry");
                ui.displayMessage(s.toString());
                ui.displayMessage("Would you like to add anything to this entry?");
                int selection = ui.promptYesOrNoSelection();
                entryCount += 1;
                switch(selection) {
                    case 0:
                        ui.displayMessage("What would you like to add?");
                        String appendedEntry = s.getData() + ui.receiveUserInput();
                        s.setData(appendedEntry);
                        saveJournalEntries();
                        break;
                }

                break;
            }
        }
        if (entryCount == 0) {
            ui.displayMessage("No entries found");
        }
    }

    private void getRangeOfJournalEntries() throws IOException {
        ui.displayMessage("Please enter the starting date");
        LocalDate startDate = ui.promptDate();
        ui.displayMessage("Please enter the end date");
        LocalDate endDate = ui.promptDate();
        int entryCount = 0;

        for (JournalEntry s : this.journalEntryList) {
            if (s.getDate().isAfter(startDate) && s.getDate().isBefore(endDate) || s.getDate().isEqual(startDate) || s.getDate().isEqual(endDate)) {
                System.out.println(s.toString());
                entryCount++;
            }
        }

        if (entryCount == 0) {
            ui.displayMessage("No entries found");
        }
    }

    private void generateEntryToday() throws IOException {
        JournalEntry je = new JournalEntry();
        ui.displayMessage("Please enter your journal entry message");
        je.setData(ui.receiveUserInput());
        je.setDate(LocalDate.now());
        journalEntryList.add(je);
        saveJournalEntries();
    }

    private void generateEntryByDate() throws IOException {
        JournalEntry je = new JournalEntry();
        ui.displayMessage("Please enter your journal message");
        je.setData(ui.receiveUserInput());
        je.setDate(ui.promptDate());
        journalEntryList.add(je);
        saveJournalEntries();
    }

    private void saveJournalEntries() throws FileNotFoundException {
        PrintStream outFile = new PrintStream(journalFile);
        try {
            for (JournalEntry e : journalEntryList) {
                outFile.println(e.serialize());
            }
        } finally {
            outFile.close();
        }
    }

    private void loadJournalEntries() throws IOException {
        BufferedReader inFile = new BufferedReader(new InputStreamReader(
                new FileInputStream("journal.txt")));
        this.journalEntryList.clear();

        try {
            while (inFile.ready()) {
                String line = inFile.readLine();
                if (!line.trim().isEmpty()) {
                    JournalEntry je = new JournalEntry();
                    je.deserialize(line);
                    this.journalEntryList.add(je);
                }
            }
        } finally {
            inFile.close();
        }
    }

    private void initializeComponents() {
        ui = new JournalUI();
    }

    public void run() throws IOException {
        initializeComponents();
        startJournal();
    }
}
