package edu.neumont.csc150.c.codescrambler.controller;

import edu.neumont.csc150.c.codescrambler.models.*;
import edu.neumont.csc150.c.codescrambler.view.CodeScramblerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private CodeScramblerView csv = new CodeScramblerView();
    private List<StringEncryptor> encryptors = new ArrayList<>();

    private void run() {
        boolean userRequestedExit = false;

        while (!userRequestedExit) {
            try {
                csv.displayMainMenu();
                int userInput = Integer.parseInt(csv.getUserInput());
                switch(userInput) {
                    case 0:
                        csv.displayMessage("Exiting");
                        userRequestedExit = true;
                        break;
                    case 1:
                        addEncryptors();
                        break;
                    case 2:
                        displayEncryptors();
                        break;
                    case 3:
                        clearEncryptors();
                        csv.displayMessage("Encryptors Cleared");
                        break;
                    case 4:
                         encryptMessage();
                        break;
                    case 5:
                        decryptMessage();
                    default:
                        csv.displayMessage("There was an issue processing your request, please try again");
                }
            } catch (Exception ex) {
                csv.displayMessage("There was an issue processing your request, please try again");
            }
        }
    }

    private void encryptMessage() throws IOException {

        csv.displayMessage("please enter a message");
        String message = csv.getUserInput();
        for (StringEncryptor cipher : encryptors) {
            message = cipher.encrypt(message);
            System.out.println(message);
        }
    }

    private void decryptMessage() throws IOException {
        csv.displayMessage("please enter a message");
        String message = csv.getUserInput();
        for (int i = encryptors.size() - 1; i >= 0; i--) {
            message = encryptors.get(i).decrypt(message);
            System.out.println(message);
        }
    }

    private void clearEncryptors() {
        this.encryptors.clear();
    }

    private void addEncryptors() {
        boolean userRequestedExit = false;

        while(!userRequestedExit) {
            try {
                csv.displayMessage(String.format("Encryptor Count : %d", encryptors.size()));
                csv.displayEncryptorMenu();
                int userInput = Integer.parseInt(csv.getUserInput());
                switch(userInput) {
                    case 0:
                        userRequestedExit = true;
                        break;
                    case 1:
                        encryptors.add(new Cutter());
                        break;
                    case 2:
                        encryptors.add(new Doubler());
                        break;
                    case 3:
                        encryptors.add(new VowelReplacer());
                        break;
                    case 4:
                        encryptors.add(new Reverser());
                        break;
                    default:
                        csv.displayMessage("There was an issue processing your request, please try again");
                        break;
                }
            } catch(Exception ex) {
                csv.displayMessage("There was an issue processing your request, please try again");
            }
        }
    }

    private void displayEncryptors() {
        csv.displayUserEncryptors(encryptors);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
