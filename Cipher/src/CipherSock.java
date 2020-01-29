import Ciphers.Caesar;
import Ciphers.Viginere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CipherSock {

    public static void main(String[] args) throws IOException {
        cipherGen();
    }

    public static void cipherGen() throws IOException {
        boolean isActive = true;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in)
        );

        while (isActive) {
            System.out.println(
                "[a] encrypt a message\n" +
                "[b] exit"
            );
            String message = in.readLine();
            switch(message.toLowerCase()) {
                case "a": {
                    encryptMessage(in);
                    break;
                } case "b": {
                    isActive = false;
                    break;
                } default: {
                    System.out.println("Please enter a valid answer");
                    break;
                }
            }
        }
    }

    public static void encryptMessage(BufferedReader in) throws IOException {
        boolean isActive = true;
        while (isActive) {
            System.out.println("Please enter a message you would like encrypted");
            String message = in.readLine();
            System.out.println("Please choose an encryption type");
            System.out.println(
                    "[a] Caesar\n" +
                    "[b] Vigenere\n" +
                    "[c] Grid\n" +
                    "[d] Exit"
            );

            String chooseCipher = in.readLine();

            switch(chooseCipher) {
                case "a": {
                    generateCaesarCipher(message, in, Type.CAESAR);
                    break;
                } case "b": {
                    generateVigenereCipher(message, in, Type.VIGINERE);
                    break;
                } case "c": {
//                    generateGridCipher(message);
                    System.out.println("This feature is currently a work in progress, thank you for your patience :)");
                    break;
                } case "d": {
                    isActive = false;
                    break;
                } default: {
                    System.out.println("Please enter a valid answer");
                    break;
                }
            }
        }
    }

    public static void generateCaesarCipher(String message, BufferedReader in, Type caesar) throws IOException {
        boolean isChoosing = true;
        int shiftCountInt;

        while (isChoosing) {
            try {
                System.out.println("How many letters would you like to shift?");
                String shiftCount = in.readLine();
                shiftCountInt = Integer.parseInt(shiftCount);
                isChoosing = false;
                Encryptor caesarEncryptor = new Encryptor(caesar, message, shiftCountInt);
                encryptMessage(caesarEncryptor);
            } catch (IOException err) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    public static void generateVigenereCipher(String message, BufferedReader in, Type viginere) {
        boolean isChoosing = true;
        String key;

        while (isChoosing) {
            try {
                System.out.println("What is your key word?");
                key = in.readLine();
                isChoosing = false;
                Encryptor viginereEncryptor = new Encryptor(viginere, message, key);
                encryptMessage(viginereEncryptor);
            } catch (IOException err) {
                System.out.println("Please enter a valid word");
            }
        }
    }

    // Currently not being utilized //
//    public static void generateGridCipher(String message) {
//
//    }

    public static void encryptMessage(Encryptor encryptor) {
        Type currentType = encryptor.getEncryptionType();

        switch(currentType) {
            case CAESAR: {
                encryptor.generateCaesarEncryption(Caesar.getCipher());
                System.out.println(encryptor.toString());
                break;
            } case VIGINERE: {
                encryptor.generateViginereEncryption(Viginere.getCipher());
                System.out.println(encryptor.toString());
                break;
            } case GRID: {
                System.out.println("This feature is currently a work in progress, thank you for your patience :)");
                break;
            }
            default: {
                System.out.println("Please enter a valid answer");
                break;
            }
        }
    }
}