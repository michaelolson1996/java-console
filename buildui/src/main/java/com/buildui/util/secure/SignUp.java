//package com.buildui.util.secure;
//
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.PBEKeySpec;
//import java.io.Serializable;
//import java.net.Inet4Address;
//import java.net.InetAddress;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.security.spec.InvalidKeySpecException;
//import java.math.BigInteger;
//
//public class SignUp implements Inet4Address {
////    boolean reached = new InetAddress();
//
//    public static void main(String[] args) {
//    }
//
////    public String hash(String phrase) throws NoSuchAlgorithmException, InvalidKeySpecException {
////        int iterations = 20000;
////        byte[] salt = getSalt();
////        char[] charPhrase = phrase.toCharArray();
////
////        PBEKeySpec key = new PBEKeySpec(charPhrase, salt, iterations, 64*8);
////        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
////        byte[] hash = skf.generateSecret(key).getEncoded();
////
////        return String.format("%d:%s:%s", iterations, toHex(salt), toHex(hash));
////    }
//
////    private byte[] getSalt() throws NoSuchAlgorithmException {
////        SecureRandom secure = SecureRandom.getInstance("SHA1PRNG");
////        byte[] salt = new byte[16];
////        secure.nextBytes(salt);
////        return salt;
////    }
////
////    private String toHex(byte[] arr) {
////        BigInteger bigInt = new BigInteger(1, arr);
////        String hex = bigInt.toString(16);
////        int paddingLen = (arr.length * 2) - hex.length();
////        if (paddingLen > 0)
////            return String.format("%0" + paddingLen + "d", 0) + hex;
////        else
////            return hex;
////    }
//}