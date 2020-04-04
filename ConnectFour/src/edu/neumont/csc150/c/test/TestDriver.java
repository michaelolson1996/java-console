package edu.neumont.csc150.c.test;

import edu.neumont.csc150.c.view.ConnectFourUI;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class TestDriver {
    public static void main(String[] args) {
        System.out.println("\033[31;1mHello\033[0m");

        System.out.println(new Date().getTime());

        ArrayList<String> test = new ArrayList<>();

        test.add("one");
        test.add("two");
        test.add("three");
        Collections.reverse(test);

        System.out.println(test);
        TextField textField = new TextField();
        ConnectFourUI ui = new ConnectFourUI();
//        ui.getUserInput();
        System.out.println();
    }
}
