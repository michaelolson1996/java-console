package edu.neumont.csc150.c.codescrambler.models;

public interface StringEncryptor {
    String encrypt(String message);
    String decrypt(String message);
}
