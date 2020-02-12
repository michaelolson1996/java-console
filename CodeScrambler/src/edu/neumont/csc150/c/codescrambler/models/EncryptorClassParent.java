package edu.neumont.csc150.c.codescrambler.models;

public class EncryptorClassParent implements StringEncryptor {

    public EncryptorClassParent() {
    }

    @Override
    public String encrypt(String message) {
        return null;
    }

    @Override
    public String decrypt(String message) {
        return null;
    }

    @Override
    public String toString() {
        return String.format("Encryptor : %s", this.getClass().getSimpleName());
    }
}
