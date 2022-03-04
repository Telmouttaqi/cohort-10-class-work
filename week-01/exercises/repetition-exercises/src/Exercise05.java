public class Exercise05 {

    public static void main(String[] args) {
        // 1. Rewrite the following loop as a `for` statement.
        // Run the code before you make changes to better understand current behavior.
        // The transformation from `while` to `for` should not change behavior.

        /*int index = 5;
        while (index <= 100) {
            System.out.println(index);
            index += 5;
        }
        */

        int  i ;

        for (i = 5; i < 101; i+=5){

            System.out.println("");
            System.out.println(i);

        }
    }
}
