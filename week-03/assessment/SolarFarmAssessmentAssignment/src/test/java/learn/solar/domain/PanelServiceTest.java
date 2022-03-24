package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepository;
import learn.solar.data.PanelRepositoryTestDouble;
import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanelServiceTest {

    private PanelRepository repository = new PanelRepositoryTestDouble();
    PanelService service = new PanelService(repository);

    @Test
    void shouldFindBySection() throws DataException {
        List<Panel> panels = service.findBySection("Mars");
        assertEquals(2, panels.size());

        panels = service.findBySection("Moon");
        assertEquals(2, panels.size());
    }

    @Test
    void shouldFindById() throws DataException {
        Panel panel = service.findById(1);
        assertEquals("Mars", panel.getSection());
    }

    @Test
    void shouldAddValidPanel() throws DataException {
        Panel validPanel = new Panel(0, "Test Section", 5, 5, 2020, Material.AMORPHOUS_SILICON, "Yes");
        PanelResult result = service.add(validPanel);
        assertTrue(result.isSuccess());
    }


    @Test
    void shouldNotAddYearFromFuture() throws DataException {
        PanelResult expected = makeResult("Panels Cannot Be Installed In the Future.");
        Panel panel = new Panel(0, "Test Section", 5, 50, 2030, Material.AMORPHOUS_SILICON, "Yes");
        PanelResult actual = service.add(panel);
        assertNotEquals(actual,expected);
    }

    @Test
    void shouldNotAddDuplicatePanel() throws DataException {
        PanelResult expected = makeResult("Panel already installed in this location.");
        // The location of this panel (section/row/col) is the same as the first entry in our seed/test file
        Panel panel = new Panel(0, "Mars", 5, 5, 2020, Material.AMORPHOUS_SILICON, "Yes");
        PanelResult actual = service.add(panel);
        assertNotEquals(actual, expected);
    }

    @Test
    void shouldUpdateExistingPanel() throws DataException {
        // Updating first entry = 1, Mars, 5 ,5, 2020, CDTE, "Yes"
        Panel panel = new Panel(1, "Moon", 10, 10, 2020, Material.COPPER_INDIUM, "No");
        PanelResult result = service.update(panel);
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotUpdateNonexistentPanel() throws DataException {
        Panel panel = new Panel(20, "Mars", 5, 6, 2020, Material.AMORPHOUS_SILICON, "No");
        PanelResult result = service.update(panel);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotUpdatePanelWithIdLessThanEqualToZero() throws DataException {
        Panel panel = new Panel(0, "Mars", 5, 6, 2020, Material.AMORPHOUS_SILICON, "NO");
        PanelResult result = service.update(panel);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotUpdateEmptySection() throws DataException {
        Panel panel = new Panel(1, "", 5, 6, 2020, Material.AMORPHOUS_SILICON, "Yes");
        PanelResult result = service.update(panel);
        assertFalse(result.isSuccess());

        panel = new Panel(1, null, 5, 6, 2020, Material.AMORPHOUS_SILICON, "Yes");
        result = service.update(panel);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotUpdateRowOutOfBounds() throws DataException {
        Panel panel = new Panel(0, "Test Section", 500, 5, 2020, Material.AMORPHOUS_SILICON, "Yes");
        PanelResult result = service.update(panel);
        assertFalse(result.isSuccess());

        panel = new Panel(0, "Test Section", 0, 10, 2020, Material.AMORPHOUS_SILICON, "Yes");
        result = service.update(panel);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotUpdateColumnOutOfBounds() throws DataException {
        Panel panel = new Panel(0, "Test Section", 5, 500, 2020, Material.AMORPHOUS_SILICON, "Yes");
        PanelResult result = service.update(panel);
        assertFalse(result.isSuccess());

        panel = new Panel(0, "Test Section", 5, 0, 2020, Material.AMORPHOUS_SILICON, "Yes");
        result = service.update(panel);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotUpdateEmptyMaterial() throws DataException {
        Panel panel = new Panel(0, "Test Section", 5, 5, 2020, null, "Yes");
        PanelResult result = service.add(panel);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotUpdateYearFromFuture() throws DataException {
        Panel panel = new Panel(1, "", 5, 6, 2040, Material.AMORPHOUS_SILICON, "Yes");
        PanelResult result = service.update(panel);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldDeleteExistingPanel() throws DataException {
        PanelResult result = service.deleteById(1);
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotDeleteNonexistentPanel() throws DataException {
        PanelResult result = service.deleteById(100);
        assertFalse(result.isSuccess());
    }


    private PanelResult makeResult(String message) {
        PanelResult result = new PanelResult();
        result.addErrorMessage(message);
        return result;
    }
}