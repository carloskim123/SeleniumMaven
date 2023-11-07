package main.resources;

import java.security.SecureRandom;
import java.util.Scanner;

public class passwordGenerator {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of password: ");
        int passLen = scanner.nextInt();
        int maxNumOfPasswords = 4;

        System.out.print("How many passwords to generate: ");
        int numOfPasswords = scanner.nextInt();

        if (numOfPasswords <= maxNumOfPasswords) {

            for(int i = 0; i < numOfPasswords; i++) {
                String password = generatePassword(passLen);
                print(i+":Generated password:-> " + password);
            }
        } else {
            print("Exceeded maximum number of passwords which is " + maxNumOfPasswords);
        }

    }
    public static void print(String value) {
        System.out.println(value);
    }

    public static String generatePassword(int passLen) {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";
        int maxPassLen = 12;

        String allChars = uppercaseChars + lowercaseChars + numbers + specialChars;
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        if ( passLen <= maxPassLen){
            for (int i = 0; i < passLen; i++) {
                int randIndex = random.nextInt(allChars.length());
                password.append(allChars.charAt(randIndex));
            }
        }else {
            print("Exceeded maximum password length of " + maxPassLen);
        }

        return password.toString();
    }
}



