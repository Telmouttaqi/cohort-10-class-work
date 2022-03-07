import java.util.Scanner;

public class Exercise05 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Musician[] musicians = new Musician[5];

        //musicians[0] = new Musician("Frank Ocean", 10);
        /*musicians[1] = new Musician("Tawfik El Mouttaqi",20);
        musicians[2] = new Musician("Samia Kayass",30);
        musicians[3] = new Musician("Hello",20);
        musicians[4] = new Musician("Hi",10);

         */



        // 1. Use a loop to populate the `musicians` array with your top 5 favorite musicians.
        // (Replace Frank Ocean.)


        // Create musicians from user input. (See Exercise04.)

        // 2. Use a second loop to print details about each musician.

        for(int i=0;i<musicians.length;i++)    //length is the property of the array
            System.out.println(musicians[i]);
    }
}
