package edu.neumont.csc150.c.codescrambler.models;

public class Doubler extends EncryptorClassParent {

    public Doubler() {}

    @Override
    public String encrypt(String message) {
        return message + message;
    }

    @Override
    public String decrypt(String message) {
        int strCount = message.length() / 2;
        return message.substring(strCount);
    }
}
