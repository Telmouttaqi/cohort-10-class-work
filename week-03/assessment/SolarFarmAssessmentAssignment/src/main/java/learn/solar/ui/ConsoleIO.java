package learn.solar.ui;

import org.springframework.stereotype.Component;
import java.util.Scanner;

//@Component
public class ConsoleIO implements TextIO{

    private final Scanner console = new Scanner(System.in);

    public int readInt(String prompt, int min, int max) {
        int result = 0;
        do {
            result = readInt(prompt);
            if (result < min || result > max) {
                System.out.println("Value must be between " + min + " and " + max);
            }
        } while (result < min || result > max);
        return result;
    }

    public int readInt(String prompt) {
        int result = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                result = Integer.parseInt(readRequiredString(prompt));
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Value must be a number. ");
            }
        }
        return result;
    }

    @Override
    public void println(Object value) {

    }

    @Override
    public void print(Object value) {

    }

    @Override
    public void printf(String format, Object... values) {

    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return console.nextLine();
    }

    public String readRequiredString(String prompt) {
        String result = null;
        do {
            result = readString(prompt).trim();
            if (result.isEmpty()) {
                System.out.println("Value is required, sorry. ");
            }
        } while (result.length() == 0);
        return result;
    }

    public boolean readBoolean(String prompt) {
        String choice = "";
        do {
            choice = readString(prompt);
            if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter \"y\" or \"n\".");
            }

        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
        if (choice.equalsIgnoreCase("y")) {

            return true;

        } else {

            return false;

        }
    }
}
