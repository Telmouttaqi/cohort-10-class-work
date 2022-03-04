public class Exercise06 {

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static boolean isBetween(int a, int b, int c){

        if (a < b && a > c){

            return true;

        }
        else
            return false;


    }

    public static void main(String[] args) {




        System.out.println(isBetween(5,7,3));

    }
}
