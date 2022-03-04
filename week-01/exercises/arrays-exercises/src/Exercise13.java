import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise13 {

    public static void main(String[] args) {
        String[] statesOrTowns = makeRandomStateAndTownArray();

        // The statesOrTowns array contains either state abbreviations or town names. You can distinguish state
        // abbreviations by their length. They're always two characters.
        // 1. Count the towns.
        // 2. Create a String[] to hold the towns.
        // 3. Loop through statesOrTowns a second time and put all towns in the new array.
        // 4. Print the town array.

        List<String> positive = new ArrayList<String>();
        List<String> negative = new ArrayList<String>();

        // 1. Count the number of positive elements in `values`.
        int i;
        int positiveCount =0 ;
        int negativeCount =0 ;
        for(i = 0; i < statesOrTowns.length; i++)
        {
            if(statesOrTowns.length == 2)  {
                positiveCount++;
                positive.add(String.valueOf(statesOrTowns[i]));

            }
            else  {
                negativeCount++;
                negative.add(String.valueOf(statesOrTowns[i]));
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

    public static String[] makeRandomStateAndTownArray() {
        Random random = new Random();
        String[] result = new String[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            String value = "MN";
            switch (random.nextInt(8)) {
                case 0:
                    value = "AL";
                    break;
                case 1:
                    value = "AK";
                    break;
                case 2:
                    value = "AR";
                    break;
                case 3:
                    value = "AZ";
                    break;
                case 4:
                    value = "Boring";
                    break;
                case 5:
                    value = "Loafers Glory";
                    break;
                case 6:
                    value = "Handsome Eddy";
                    break;
                case 7:
                    value = "Lonelyville";
                    break;
            }
            result[i] = value;
        }
        return result;
    }
}
