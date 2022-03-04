public class Exercise20 {

    public static void main(String[] args) {

        // From Alice Roosevelt Longworth:
        String aliceQuote = "If you can't say something good about someone, sit right here by me.";

        System.out.println(aliceQuote.length());

        char tenthChar = aliceQuote.charAt(9);
        System.out.println(tenthChar);

        // 1. Store the first character from aliceQuote in a char variable.
        char f = aliceQuote.charAt(0);

        // 2. Print it.
        System.out.println("First character : " + f);

        // 3. Print the 20th character.

        char Twenty = aliceQuote.charAt(19);
        System.out.println(Twenty);


        // 4. Print the 68th character.

        char sixtyEight = aliceQuote.charAt(67);
        System.out.println(sixtyEight);


    }
}
