import java.util.Objects;
import java.util.Scanner;

public class CapsuleHotel {
    public static void main(String[] args) {

        // StartUp() method to print the welcome message.
        // Ask the user to enter the capsules available to book.
        startup();


        // // Create a Scanner object.
        Scanner console = new Scanner(System.in);
        // assign int to variable capsules available.
        int capsulesAvailable = Integer.parseInt(console.nextLine());
        // create an array to hold how many capsules will the user enter.
        String[] capsules = new String[capsulesAvailable];
        // display message include the length of capsules.
        System.out.println("There are " + capsules.length + " unoccupied capsules ready to be booked.\n");

        String userInput;

        do {
            MainMenu();
            userInput = console.nextLine();
            switch (userInput) {
                case "1" -> checkIn(console, capsules);
                case "2" -> checkOut(console, capsules);
                case "3" -> viewGuests(console, capsules);
                case "4" -> exit(console);
                default -> System.out.println("We don't have that option please try again and pick from [1-4]: ");
            }
        } while (!userInput.equals("0"));


    }

    // void method to display the menu
    public static void MainMenu() {
        System.out.print("""

                Guest Menu
                ==========
                1. Check In
                2. Check Out
                3. View Guests
                4. Exit
                Choose on option [1-4]:\s""");
    }


    // Void method to display the welcome message
    // display the message ask the user to enter number of capsules.
    public static void startup() {
        System.out.println("Welcome to Capsule-Capsule.");
        System.out.println("=".repeat(27));
        System.out.print("Enter the number of capsules: ");

    }

    // exit method take a Scanner parameter
    // which make the user enter either
    // y to exit the program
    // n to stay and avoid the data erase.
    public static void exit(Scanner console) {
        System.out.println("""
                Exit
                ====
                Are you sure you want to exit?
                All data will be lost.
                Exit [y/n]:""");
        String exitInput = console.nextLine();
        if (Objects.equals(exitInput, "n")) {

            return;

        } else {
            System.out.print("Good Bye, See you soon!");
            System.exit(0);
        }

    }


    // Check In method
    // display messages ask the user-name, Capsule number
    public static void checkIn(Scanner console, String[] capsules) {
        System.out.println("Guess Check In: ");
        System.out.println("==============");
        System.out.print("Guest Name: ");
        String guestName = console.nextLine();
        System.out.print("Capsule #[1-" + capsules.length + "]: ");
        int index = Integer.parseInt(console.nextLine()) - 1;

        // Changed the while loop with if statement
        if (capsules[index] != null) {
            System.out.println("Error :(\n" +
                    "Capsule #" + (index + 1) + " is occupied.");
            System.out.print("Capsule #[1-" + capsules.length + "]: ");
            index = Integer.parseInt(console.nextLine()) - 1;

        }

        // Changed while loop with if statement
        if (capsules[index] == null) {
            capsules[index] = guestName;
            System.out.println("Success :)\n" +
                    guestName + " is booked in capsule #" + (index + 1) + ".");

        }

    }

    public static void viewGuests(Scanner console, String[] capsules) {
        System.out.println("View Guests\n" +
                "===========");
        System.out.print("Capsule #[1-" + capsules.length + "]: ");
        int viewGuest = Integer.parseInt(console.nextLine()) - 1;
        System.out.println(" Capsule:           Guest");
        if (viewGuest + 1 <= 5) {
            for (int i = 0; i < viewGuest + 6; i++) {

                if (i == capsules.length) {
                    break;
                }
                System.out.println("");
                System.out.printf("  Capsules #%s: %s%n ",
                        i + 1, capsules[i] == null ? "  unoccupied" : capsules[i]);
            }

        } else {
            for (int i = viewGuest - 5; i < viewGuest + 6; i++) {
                if (i == capsules.length) {
                    break;
                }
                System.out.println("");
                System.out.printf("Capsules #%s: %s%n ",
                        i + 1, capsules[i] == null ? "  unoccupied" : capsules[i]);
            }
        }
    }


    public static void checkOut(Scanner console, String[] capsules) {

        System.out.println("Guess Check Out: ");
        System.out.println("==============");
        System.out.print("Capsule #[1-" + capsules.length + "]: ");
        int index = Integer.parseInt(console.nextLine()) - 1 ;

        while (capsules[index] == null) {
            System.out.println("Error :(\n" +
                    "Capsule #" + index + " is unoccupied.");
             System.out.print("Capsule #[1-"+capsules.length+"]: ");
             index = Integer.parseInt(console.nextLine()) - 1 ;

        }

        while (capsules[index] != null) {
            System.out.println("Success :)\n" +
                    capsules[index] + " checked out from capsule # " + (index + 1) + "");
            capsules[index] = null;


        }

    }

}

