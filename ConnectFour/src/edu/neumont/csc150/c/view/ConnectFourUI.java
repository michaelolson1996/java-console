package edu.neumont.csc150.c.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConnectFourUI {
    BufferedReader in;

    public ConnectFourUI() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayPrompt(String s) {
        System.out.println(s);
    }

    public void displayPlayerMenu() {
        System.out.println(
            "Please choose your game mode\r\n" +
            "[1] Player vs Player\r\n" +
            "[2] Player vs Computer\r\n" +
            "[3] Computer vs Computer\r\n" +
            "[0] Exit\r\n"
        );
    }

    public String getUserInput() throws IOException {
        return in.readLine();
    }

    public void displayBoardForUsers(String board) {
        System.out.println(board);
    }

    public void displayIndex() {
        System.out.println("1  2  3  4  5  6  7");
    }
}
