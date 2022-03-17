package com.thelaunchclub.userinput;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class CommonInput {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Logger LOGGER= Logger.getLogger(String.valueOf(CommonInput.class));

    public String getString(String text){
        System.out.println(text);
        return SCANNER.next().trim();
    }

    public Long getLong(String text){
        System.out.println(text);

        try {
            return SCANNER.nextLong();
        } catch(InputMismatchException e){
            LOGGER.info("Enter a Valid input");
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
