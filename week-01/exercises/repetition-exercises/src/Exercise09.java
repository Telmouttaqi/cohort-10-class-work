public class Exercise09 {

    public static void main(String[] args) {
        // 1. Write a loop to sum all numbers between 7 and 16.
        // 2. Print the result.

        int sum = 0;
        for (int i =7; i < 17; i+=1) {
            System.out.println(i);
            sum = i + sum;

        }
        System.out.println("total of the sum between 7 and 16 is : " + sum);
    }
}
