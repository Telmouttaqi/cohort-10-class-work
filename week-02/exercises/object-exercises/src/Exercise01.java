public class Exercise01 {

    public static void main(String[] args) {

        Musician ocean = new Musician("Frank Ocean", 10);

        System.out.println(ocean.getName());


        // 1. Find the Musician class in this project.
        // 2. Read its constructor comments.
        // 3. Instantiate two more musicians and assign them to new variables.
        Musician one = new Musician("Tawfik El Mouttaqi ",10);
        Musician two = new Musician("El-Mouttaqi Tawfik", 10);
        // 4. Print the musicians' names to the console.

        System.out.println(one.getName());
        System.out.println(two.getName());

    }
}
