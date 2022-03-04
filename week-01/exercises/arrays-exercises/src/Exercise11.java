import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise11 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();
        List<String> where = new ArrayList<String>();

        // 1. Count the number of positive elements in `values`.
        int i;
        int positiveCount =0 ;
        int negativeCount =0 ;
        for(i = 0; i < values.length; i++)
        {
            if(values[i] >= 0)  {
                positiveCount++;
                where.add(String.valueOf(values[i]));

            }
            else  {
                negativeCount++;
            }

        }
        System.out.println("Positive " + positiveCount);
        System.out.println("Negative " + negativeCount);

        // 2. Create a new int[] to hold the positive elements.

        // (We must count first to know the capacity to allocate.)
        // 3. Loop through `values` a second time. Add positive elements to the new array.


        // 4. Confirm the positive array is properly populated either by debugging or printing its elements.
        System.out.println(where);
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
