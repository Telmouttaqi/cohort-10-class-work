package learn.DontWreckMyHouse.domain;

import learn.DontWreckMyHouse.data.DataException;
import learn.DontWreckMyHouse.data.HostRepositoryDouble;
import learn.DontWreckMyHouse.models.Guest;
import learn.DontWreckMyHouse.models.Host;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HostServiceTest {


    HostService service = new HostService(new HostRepositoryDouble());

    @Test
    void ShouldFindAll() throws DataException {
        List<Host> result = service.findAll();
        assertEquals(2,result.size());
    }

    @Test
    void shouldFindByEmail() throws DataException{
        Host result = service.findHostByEmail("test@gmail.com");
        assertEquals("27409",result.getPostalCode());
    }


    @Test
    void DoesNotExistEmail() throws DataException {
        Host result = service.findHostByEmail("DoesNotExisting@gmail.com");

        assertNull(result);
    }



}