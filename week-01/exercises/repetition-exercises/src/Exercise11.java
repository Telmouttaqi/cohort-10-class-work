import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.print("Start: ");
        int start = Integer.parseInt(console.nextLine());

        System.out.print("increment: ");
        int increment = Integer.parseInt(console.nextLine());

        System.out.print("End: ");
        int end = Integer.parseInt(console.nextLine());

        int sum =0;

        for (int index = start; index <= end; index+= increment){
            sum +=index;

        }
        System.out.println("Sum: "+sum);


    }
}
