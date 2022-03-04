public class Exercise10 {
    // 1. Add a `main` method.
    // 2. Create method that accepts a String and returns that string with all of its whitespace remove.
    // 2. Call your method in various ways in the main method.
    public static void main(String[] args) {


        System.out.println(WhiteSpaceRemove("  Tawfik   "));
    }
    public static String WhiteSpaceRemove(String s){


        // remove white space!
        return s.trim();

    }
}
