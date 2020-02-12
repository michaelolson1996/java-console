package edu.neumont.csc150.c.codescrambler.models;

public class VowelReplacer extends EncryptorClassParent {

    public VowelReplacer() {}

    @Override
    public String encrypt(String message) {
        String encryptedMsg = "";
        for (int i = 0; i < message.length(); i++) {
            switch(String.valueOf(message.charAt(i))) {
                case "a":
                    encryptedMsg += "e";
                    break;
                case "e":
                    encryptedMsg += "i";
                    break;
                case "i":
                    encryptedMsg += "o";
                    break;
                case "o":
                    encryptedMsg += "u";
                    break;
                case "u":
                    encryptedMsg += "a";
                    break;
                default:
                    encryptedMsg += String.valueOf(message.charAt(i));
            }
        }
        return encryptedMsg;
    }

    @Override
    public String decrypt(String message) {
        String decryptedMsg = "";
        for (int i = 0; i < message.length(); i++) {
            switch(String.valueOf(message.charAt(i))) {
                case "a":
                    decryptedMsg += "u";
                    break;
                case "e":
                    decryptedMsg += "a";
                    break;
                case "i":
                    decryptedMsg += "e";
                    break;
                case "o":
                    decryptedMsg += "i";
                    break;
                case "u":
                    decryptedMsg += "o";
                    break;
                default:
                    decryptedMsg += String.valueOf(message.charAt(i));
            }
        }
        return decryptedMsg;
    }
}
