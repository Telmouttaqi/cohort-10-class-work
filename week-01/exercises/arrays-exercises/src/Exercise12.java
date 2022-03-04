import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();

        // 1. Count the number of positive and non-positive elements in `values`.
        // 2. Create two new int[]s, one for positive elements and one for non-positive.
        // (We count first to determine the capacity to allocate.)
        // 3. Loop through `values` a second time. If an element is positive, add it to the positive array.
        // If it is non-positive, add it to the non-positive array.
        // 4. Confirm that your secondary arrays are properly populated either by debugging or printing their elements.


        List<String> positive = new ArrayList<String>();
        List<String> negative = new ArrayList<String>();

        // 1. Count the number of positive elements in `values`.
        int i;
        int positiveCount =0 ;
        int negativeCount =0 ;
        for(i = 0; i < values.length; i++)
        {
            if(values[i] >= 0)  {
                positiveCount++;
                positive.add(String.valueOf(values[i]));

            }
            else  {
                negativeCount++;
                negative.add(String.valueOf(values[i]));
            }

        }
        System.out.println("Positive " + positiveCount);
        System.out.println("Negative " + negativeCount);

        // 2. Create a new int[] to hold the positive elements.

        // (We must count first to know the capacity to allocate.)
        // 3. Loop through `values` a second time. Add positive elements to the new array.


        // 4. Confirm the positive array is properly populated either by debugging or printing its elements.
        System.out.println("Positive numbers are: "+positive);
        System.out.println("Negative numbers are: "+negative);
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
