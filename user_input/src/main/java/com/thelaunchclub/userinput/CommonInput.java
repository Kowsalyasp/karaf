package com.thelaunchclub.userinput;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class CommonInput {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Logger LOGGER= Logger.getLogger(String.valueOf(CommonInput.class));

    /**
     * Get the String type user input.
     *
     * @param text
     * @return
     */
    public String getString(String text){
        System.out.println(text);
        return SCANNER.next().trim();
    }

    /**
     * Get the Long type user input.
     *
     * @param text
     * @return
     */
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

    /**
     * Get the Integer type user input.
     *
     * @param text
     * @return
     */
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
