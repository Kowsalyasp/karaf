package com.thelaunchclub.userinput;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Common inputs for an different datatypes.
 */
public class CommonInput {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(CommonInput.class));

    /**
     * Get the String type user input.
     *
     * @param text
     */
    public String getString(String text) {
        LOGGER.info(text);

        return SCANNER.next().trim();
    }

    /**
     * Get the Long type user input.
     *
     * @param text
     */
    public Long getLong(String text) {
        LOGGER.info(text);

        try {
            return SCANNER.nextLong();
        } catch (InputMismatchException e) {
            LOGGER.info("Enter a Valid input");
            String input = SCANNER.next();

            return getLong(input);
        }
    }

    /**
     * Get the Integer type user input.
     *
     * @param text
     */
    public int getInt(String text) {
        LOGGER.info(text);

        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            LOGGER.info("Enter a Valid input");
            String input = SCANNER.next();

            return getInt(input);
        }
    }
}
