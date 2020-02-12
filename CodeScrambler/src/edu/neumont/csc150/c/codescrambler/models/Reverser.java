package edu.neumont.csc150.c.codescrambler.models;

public class Reverser extends EncryptorClassParent {

    public Reverser() {}

    @Override
    public String encrypt(String message) {
        return new StringBuilder(message).reverse().toString();
    }

    @Override
    public String decrypt(String message) {
        return new StringBuilder(message).reverse().toString();
    }
}
