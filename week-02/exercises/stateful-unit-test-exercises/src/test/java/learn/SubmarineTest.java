package learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubmarineTest {

    Submarine submarine = new Submarine(100.0);

    @Test
    void shouldHaveCorrectDepthAfter3Dives() {
        submarine.dive();
        submarine.dive();
        submarine.dive();
        assertEquals(9.0, submarine.getDepthInMeters(), 0.001);
    }

    @Test
    void shouldHaveCorrectPressureAfter3Dives() {
        submarine.dive();
        submarine.dive();
        submarine.dive();
        // 1.0 at sea level plus 1.0 * 0.9
        assertEquals(1.9, submarine.getPressureInAtmospheres(), 0.001);
    }

    // 1. Create one or more tests to confirm `dive` is working properly.
    @Test
        void shouldNotDropBelowMax(){
        Submarine submarine = new Submarine(8.0);
        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.dive();
        assertEquals(8.0,submarine.getDepthInMeters());

    }
    // 2. Create a test to assert the submarine can't go deeper than the max depth.
    // (Be sure to use more than one max depth.)
    // 3. Create one or more tests to confirm `surface` is working properly.
    @Test
    void shouldIcreaseBy5(){
        Submarine submarine = new Submarine(15.0);
        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.dive();
        assertEquals(10.00,submarine.getDepthInMeters());

    }
    // 4. Create a test to assert the submarine can't go above sea level.
    // (Depth can never be negative.)

    @Test
    void souldNotGoAbove0(){
        Submarine submarine = new Submarine(10.00);

        submarine.surface();
        assertFalse(submarine.getDepthInMeters() < 0);

    }
    // 5. Create one or more tests to confirm `getPressureInAtmospheres` is working properly.

    @Test
    void pressureIsWorking(){
        Submarine submarine = new Submarine(50.0);

        assertEquals(1,submarine.getPressureInAtmospheres());
        assertEquals(1+3.00/10,submarine.getPressureInAtmospheres());
        assertEquals(1+6.00/10,submarine.getPressureInAtmospheres());
        assertEquals(1+9.00/10,submarine.getPressureInAtmospheres());
        //assertEquals(1+12.00/10,submarine.getPressureInAtmospheres());



    }
}