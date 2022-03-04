import java.util.Random;

public class Exercise15 {

    public static void main(String[] args) {
        int[] one = makeRandomArray();
        int[] two = makeRandomArray();

        // 1. Create a new int[] with room enough for all elements in `one` and `two`.
        // 2. Copy elements from `one` into the beginning of the array.
        // 3. Copy elements from `two` at the end of the array.
        // 4. Print the results to confirm that it worked.

        int [] oneNew = new int[1500];


        for(int index =0 ; index < one.length; index++) {
            System.out.println("this is variable one : "+one[index]);

            for (int j = 0; j < two.length; j++) {

                System.out.println("This is variable two : "+two[j]);

            }
        }



    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }
}
