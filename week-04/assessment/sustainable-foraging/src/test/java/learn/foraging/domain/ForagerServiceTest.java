package learn.foraging.domain;

import learn.foraging.data.DataException;
import learn.foraging.data.ForagerRepositoryDouble;
import learn.foraging.models.Forage;
import learn.foraging.models.Forager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForagerServiceTest {

    ForagerService service = new ForagerService(new ForagerRepositoryDouble());

   @Test
    void ShouldAdd() throws DataException{
       Forager forager = new Forager();
       forager.setFirstName("Tawfik");
       forager.setLastName("El Mouttaqi");
       forager.setState("NC");

       Result<Forager> result = service.add(forager);
       assertTrue(result.isSuccess());

   }

    @Test
    void RequireFirstName() throws DataException {
        Forager forager = new Forager();
        forager.setFirstName("");
        forager.setLastName("ElMouttaqi");
        forager.setState("MA");
        Result<Forager> result = service.add(forager);
        assertFalse(result.isSuccess());

    }

   @Test
    void RequireLastName() throws DataException {
       Forager forager = new Forager();
       forager.setFirstName("Tawfik1");
       forager.setLastName("");
       forager.setState("GA");
       Result<Forager> result = service.add(forager);
       assertFalse(result.isSuccess());

   }

    @Test
    void RequireState() throws DataException {
        Forager forager = new Forager();
        forager.setFirstName("Tawfik");
        forager.setLastName("ElMouttaqi");
        forager.setState("");
        Result<Forager> result = service.add(forager);
        assertFalse(result.isSuccess());

    }

    @Test
    void shouldNotAddDuplicateForager() throws DataException {

        Forager forager = new Forager();
        forager.setId("f4b050a5-060a-4450-b621-3b386776a716");
        forager.setFirstName("Tawfik");
        forager.setLastName("Mouttaqi");
        forager.setState("NC");
        Result<Forager> result = service.add(forager);
        assertFalse(result.isSuccess());

    }

}
