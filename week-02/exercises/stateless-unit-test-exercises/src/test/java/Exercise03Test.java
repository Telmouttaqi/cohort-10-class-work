import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise03Test {

    @Test
    void hasAllVowels() {
        assertTrue(Exercise03.hasAllVowels("aeiou"));
        assertFalse(Exercise03.hasAllVowels("aie"));



    }

    @Test
    void checkUpperCase(){
        assertTrue(Exercise03.hasAllVowels("AEIOU"));
    }

    @Test
    void nullShouldReturnFalse(){

    }

}