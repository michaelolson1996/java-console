package edu.neumont.csc150.c.codescrambler.models;

public class Cutter extends EncryptorClassParent {

    public Cutter() {}

    @Override
    public String encrypt(String message) {
        int strCount = message.length() % 2 == 0 ? message.length() / 2 : (message.length() - 1) / 2;
        String backHalf = message.substring(message.length() - strCount);
        return backHalf + message.substring(0, message.length() - backHalf.length());
    }

    @Override
    public String decrypt(String message) {
        int strCount = message.length() % 2 == 0 ? message.length() / 2 : (message.length() + 1) / 2;
        String frontHalf = message.substring(message.length() - strCount);
        return frontHalf + message.substring(0, message.length() - frontHalf.length());
    }
}
