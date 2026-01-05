package scr.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Encrypter {
    public String encryptString(String input) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] messageDigest = md.digest(input.getBytes());

        BigInteger bigInt = new BigInteger(1, messageDigest);

        return bigInt.toString(16);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to be hashed");
        String pass = sc.nextLine();
        Encrypter en = new Encrypter();
        try {
            System.out.println(en.encryptString(pass));
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

    }
}
