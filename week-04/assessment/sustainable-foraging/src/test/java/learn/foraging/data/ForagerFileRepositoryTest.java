package learn.foraging.data;

import learn.foraging.models.Forager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForagerFileRepositoryTest {

    static final String SEED_PATH = "./data/forage_data_test/foragers-seed.csv";
    static final String TEST_PATH = "./data/forage_data_test/foragers-test.csv";

    ForagerFileRepository repository = new ForagerFileRepository(TEST_PATH);

    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(SEED_PATH);
        Path testPath = Paths.get(TEST_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindAll() {
        ForagerFileRepository repo = new ForagerFileRepository("./data/foragers.csv");
        List<Forager> all = repo.findAll();
        assertEquals(1000, all.size());
    }

    @Test

    void shouldAddForager() throws DataException{
        Forager forager = new Forager();
        forager.setFirstName("Tawfik");
        forager.setLastName("ElMouttaqi");
        forager.setState("NC");
        repository.add(forager);
        assertEquals(1,repository.findAll().size());

    }

    @Test
    void CheckFileSize() throws DataException {
        assertEquals(0,repository.findAll().size());
    }


}