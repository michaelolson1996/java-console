package edu.neumont.csc150.c.codescrambler.view;

import edu.neumont.csc150.c.codescrambler.models.StringEncryptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CodeScramblerView {

    private BufferedReader in;

    public CodeScramblerView() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayMainMenu() {
        System.out.println(
             "[1] : Pick your Encryptors\r\n" +
             "[2] : View your Encryptors\r\n" +
             "[3] : Clear your Encryptors\r\n" +
             "[4] : Encrypt Message\r\n" +
             "[5] : Decrypt Message\r\n" +
             "[0] : Exit"
        );
    }

    public void displayEncryptorMenu() {
        System.out.println(
                "[1] : Cutter\r\n" +
                "[2] : Doubler\r\n" +
                "[3] : Vowel Replacer\r\n" +
                "[4] : Reverser\r\n" +
                "[0] : Exit\r\n"
        );
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput() throws IOException {
        String rawInput = in.readLine();
        return rawInput;
    }

    public void displayUserEncryptors(List<StringEncryptor> encryptors) {
        for (StringEncryptor se : encryptors) {
            System.out.println(se.toString());
        }
    }
}
