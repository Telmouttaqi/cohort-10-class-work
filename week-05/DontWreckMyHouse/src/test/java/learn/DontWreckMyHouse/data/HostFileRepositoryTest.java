package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Guest;
import learn.DontWreckMyHouse.models.Host;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HostFileRepositoryTest {


    private HostFileRepository repository = new HostFileRepository("./data/hosts.csv");

    @Test
    void shouldFind1001Host(){
        List<Host> actual = repository.findAll();
        assertNotNull(actual);
        assertEquals(1000,actual.size());
    }


    @Test
    void shouldFindExistingGuestById(){

        Host Croney = repository.findHostById("e0a8112e-fd35-4054-af88-cb8448394004");
        assertNotNull(Croney);
        assertEquals("Croney",Croney.getLastName());

    }


    @Test
    void shouldNotFindExistingHostById(){

        Host notExist = repository.findHostById("testIdHost");
        assertNull(notExist);

    }


    @Test
    void shouldFindExistingGuestByEmail(){
        Host Croney = repository.findHostByEmail("jcroneya@noaa.gov");
        assertNotNull(Croney);
        assertEquals("Croney",Croney.getLastName());
    }

    @Test
    void shoutNotFindExistingGuestByEmail(){
        Host notExist = repository.findHostByEmail("Test@gmail.com");
        assertNull(notExist);

    }


}