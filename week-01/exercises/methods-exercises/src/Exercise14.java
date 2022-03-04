import java.util.Scanner;

public class Exercise14 {
    /* SHORT SURVEY

    Write a program that asks a user four questions and prints the results:
    - What is your first name?
    - What is your last name?
    - How many towns/cities have you lived in?
    - How many musical instruments can you play?

    Store each answer in a variable with an appropriate type.
    Print the results after the user has answered all four questions.

    Use methods to break the program into reusable blocks of code.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String firstName = readUserInput(scan, "Please tell me your name: ");
        String lastName = readUserInput(scan, "- What is your last name: ?");
        String countCities = readUserInput(scan, "- How many towns/cities have you lived in?");
        String instruments = readUserInput(scan, "- - How many musical instruments can you play?");

        displayInput(firstName,lastName,countCities,instruments);

    }

    public static String readUserInput(Scanner scanner, String prompt) {
        String userInput;
        System.out.print(prompt);
        userInput = scanner.nextLine();

        return userInput;
    }

    public static void displayInput(String a,String b,String c,String d){

        System.out.println("My first name is: "+a);
        System.out.println("My last name is: "+b);
        System.out.println("cities where I have you lived"+c);
        System.out.println("How many musical instruments can you play?"+d);

    }


}
