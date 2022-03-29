package learn.DontWreckMyHouse.data;

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

}