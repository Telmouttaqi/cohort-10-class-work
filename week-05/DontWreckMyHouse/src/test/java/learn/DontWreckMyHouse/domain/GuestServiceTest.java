package learn.DontWreckMyHouse.domain;
import learn.DontWreckMyHouse.data.DataException;
import learn.DontWreckMyHouse.data.GuestRepositoryDouble;
import learn.DontWreckMyHouse.models.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GuestServiceTest {

    GuestService service = new GuestService(new GuestRepositoryDouble());

    @Test
    void shouldFindAll() throws DataException {
        List<Guest> result = service.findAll();
        assertEquals(2,result.size());
    }

    @Test
    void shouldFindByEmail() throws DataException {
        Guest result = service.findGuestByEmail("Test@test2.com");
        assertEquals(2,result.getGuestId());
    }

    @Test
    void DoesNotExistEmail() throws DataException {
        Guest result = service.findGuestByEmail("DoesNotExisting@gmail.com");

        assertNull(result);
    }


}