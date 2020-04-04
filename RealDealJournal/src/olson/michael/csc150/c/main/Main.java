package olson.michael.csc150.c.main;

import olson.michael.csc150.c.controller.JournalManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new JournalManager().run();
    }
}
