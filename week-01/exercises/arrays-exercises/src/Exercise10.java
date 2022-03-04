import java.util.Arrays;
import java.util.Random;

public class Exercise10 {

    public static void main(String[] args) {
        String[] bugs = makeBugArray();

        // The bugs array elements are either the value "beetle" or "mosquito".
        // 1. Count the number of beetles and mosquitoes.
        // 2. Print the result.
        // Results will vary because of randomness.
        int countB =0;
        int countM = 0;
        for (int i = 0; i < bugs.length; i++) {
            System.out.println(bugs[i]);
            if (bugs[i] == "beetle") {
                countB +=1;
            }else {
                countM+=1;
            }
        }
        System.out.println("There are "+countB+" beetle and "+countM+" musquito!");
    }

    public static String[] makeBugArray() {
        String[] bugs = new String[200];
        Arrays.fill(bugs, "beetle");
        Random random = new Random();
        for (int i = 0; i < random.nextInt(150); i++) {
            bugs[random.nextInt(bugs.length)] = "mosquito";
        }
        return bugs;
    }
}
