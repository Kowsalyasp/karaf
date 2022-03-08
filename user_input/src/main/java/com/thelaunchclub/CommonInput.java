package com.thelaunchclub;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String getString(String text){
        System.out.println(text);
        return SCANNER.next().trim();
    }

    public Long getLong(String text){
        System.out.println(text);

        try {
            return SCANNER.nextLong();
        } catch(InputMismatchException e){
            System.out.println("Enter a Valid input");
            String input = SCANNER.next();

            return getLong(input);
        }
    }

    public int getInt(String text){
        System.out.println(text);

        try {
            return SCANNER.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Enter a Valid input");
            String input = SCANNER.next();

            return getInt(input);
        }
    }
}
