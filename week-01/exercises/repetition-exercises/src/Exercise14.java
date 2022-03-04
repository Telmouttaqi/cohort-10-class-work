import java.util.Scanner;

public class Exercise14 {

    public static void main(String[] args) {
        // 1. Collect a phrase from a user via the console.
        // 2. Count the number of digits in the phrase.
        // Hint: Character.isDigit
        // 3. Print the result.

        Scanner console = new Scanner(System.in);

        System.out.print("Enter a phrase please: ");
        String phrase = console.nextLine();

        // first solution !
        int count = phrase.replaceAll("\\D", "").length();

        System.out.println(count);

        // second solution!

        int c = 0;
        for (int i = 0, len = phrase.length(); i < len; i ++){
            if (Character.isDigit(phrase.charAt(i))) {
                c++;
            }
        }

        System.out.println(c);


    }
}
