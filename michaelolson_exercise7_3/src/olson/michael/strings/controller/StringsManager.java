package olson.michael.strings.controller;

import olson.michael.strings.model.StringClass;
import olson.michael.strings.view.StringUI;

import java.io.*;

public class StringsManager {
    private final static String stringsFile = "strings.txt";
    private StringUI ui = new StringUI();

    public void run() throws IOException {
        boolean exitRequested = false;

        while(!exitRequested) {
            StringUI.MenuItem selection = ui.promptMenuSelection();
            switch(selection) {
                case EXIT:
                    exitRequested = true;
                    break;
                case ENTER_MESSAGE:
                    createMessage();
                    break;
                case READ_MESSAGE:
                    readMessage();
                    break;
            }
        }
    }

    private void readMessage() throws IOException {
        BufferedReader inFile = new BufferedReader(new InputStreamReader(new FileInputStream(stringsFile)));
        try {
            while(inFile.ready()) {
                String line = inFile.readLine();
                if (!line.trim().isEmpty()) {
                    StringClass str = new StringClass();
                    str.deserialize(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inFile.close();
        }
    }

    private void createMessage() throws IOException {
        while (true) {
            PrintStream outFile = new PrintStream(stringsFile);
            try {
                String userInput = ui.promptMessage();
                if (userInput.length() < 1)
                    throw new Exception();
                StringClass str = new StringClass();
                str.setMessage(userInput);
                outFile.println(str.serialize());
            } catch(Exception ex) {
                ui.displayError("Your message but contain content");
            } finally {
                outFile.close();
            }
        }
    }
}
