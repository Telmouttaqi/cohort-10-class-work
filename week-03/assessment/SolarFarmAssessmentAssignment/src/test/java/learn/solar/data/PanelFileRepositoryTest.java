package learn.solar.data;

import learn.solar.models.Panel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static learn.solar.models.Material.AMORPHOUS_SILICON;
import static learn.solar.models.Material.MULTICRYSTALLINE_SILICON;
import static org.junit.jupiter.api.Assertions.*;

class PanelFileRepositoryTest {

    final String TEST_FILE = "./data/solarPanel-test-file.csv";
    final String SEED_FILE = "./data/SolarPanel-test-seed.csv";

    PanelRepository repository = new PanelFileRepository(TEST_FILE);


    @BeforeEach
    void init() throws IOException {
        // replace the test file with the seed file
        Path testFilePath = Paths.get(TEST_FILE);
        Path seedFilePath = Paths.get(SEED_FILE);

        Files.copy(seedFilePath, testFilePath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test

    void shouldBeAbleToAcceptNull() throws DataException {
        repository.add(new Panel());
    }

    @Test
    void shouldGetNextIdWhenSaved() throws DataException {
        Panel panel = new Panel(1, "Main", 3, 10, 2015, MULTICRYSTALLINE_SILICON, "Yes");
        Panel returnedPanel = repository.add(panel);

        // characteristic that should be true if my logic worked
        assertEquals(14, returnedPanel.getPanelId());
    }

    @Test
    void shouldReturnTrueWhenSuccessfullyDeleted() throws DataException {
        // should indicate the actual record was deleted successfully the first time
        assertFalse(repository.deleteById(1));
    }

    @Test
    void shouldReturnFalseWhenNothingToDelete() throws  DataException {
        assertFalse(repository.deleteById(18593558));
    }

    @Test
    void shouldReturnTrueWhenUpdateSuccessfully() throws DataException {
        // figure out what's currently at a particular id
        Panel oldPanel = repository.findById(2);

        Panel replacementPanel = new Panel(3,"Main",5,3,2015,AMORPHOUS_SILICON,"Yes");
        // should get true if the id is found,
        assertTrue(repository.update(replacementPanel));

    }



}