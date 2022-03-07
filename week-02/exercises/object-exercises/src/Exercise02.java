public class Exercise02 {

    public static void main(String[] args) {

        // 1. Add a getter for the rating field in Musician.

        Musician ocean = new Musician("Frank Ocean", 10);
        System.out.println(ocean.getName());
        System.out.println(ocean.getRating());
        // 2. Uncomment the line below and insure that it compiles and runs.
         System.out.println(ocean.getRating());

        // 3. Instantiate two musicians and assign them to new variables.
        Musician one = new Musician("Tawfik El Mouttaqi ",10);
        Musician two = new Musician("El-Mouttaqi Tawfik", 10);

        // 4. Print each musicians' name and rating on a single line.
        String format = "name: %s, rating: %s%n";
        System.out.printf(format,one.getName(), one.getRating());
        System.out.printf(format,two.getName(), two.getRating());
    }
}
