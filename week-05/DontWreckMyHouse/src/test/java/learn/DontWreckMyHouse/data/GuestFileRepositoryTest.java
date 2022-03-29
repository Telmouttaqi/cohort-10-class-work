package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Guest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestFileRepositoryTest {


    private GuestFileRepository repository = new GuestFileRepository("./data/guests.csv");


    @Test
    void shouldFind1000Guest(){
        List<Guest> actual = repository.findAll();
        assertNotNull(actual);
        assertEquals(1000,actual.size());
    }
}