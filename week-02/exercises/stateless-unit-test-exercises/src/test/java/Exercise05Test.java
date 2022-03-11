import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise05Test {

    @Test
    void isWithinFiveOfAHundred(){
        Exercise05 exercise05 = new Exercise05();

        assertTrue(exercise05.isWithinFiveOfAHundred(95));
        assertFalse(exercise05.isWithinFiveOfAHundred(50));
        assertTrue(exercise05.isWithinFiveOfAHundred(0));
        assertTrue(exercise05.isWithinFiveOfAHundred(-95));
        assertFalse(exercise05.isWithinFiveOfAHundred(-50));

    }

}