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


    @Test
    void shouldFindExistingGuestById(){

        Guest isabel = repository.findGuestById(10);
        assertNotNull(isabel);
        assertEquals("Isabel",isabel.getFirstName());

    }

    @Test
    void shouldNotFindExistingGuestById(){

        Guest notExist = repository.findGuestById(5000);
        assertNull(notExist);

    }


    @Test
    void shouldFindExistingGuestByEmail(){
        Guest isabel = repository.findGuestByEmail("iganter9@privacy.gov.au");
        assertNotNull(isabel);
        assertEquals("Isabel",isabel.getFirstName());
    }

    @Test
    void shoutNotFindExistingGuestByEmail(){
        Guest notExist = repository.findGuestByEmail("test@test.com");
        assertNull(notExist);

    }
}