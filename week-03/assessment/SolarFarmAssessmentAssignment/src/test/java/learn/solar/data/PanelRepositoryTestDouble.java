package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.util.ArrayList;
import java.util.List;

public class PanelRepositoryTestDouble implements PanelRepository{

    private List<Panel> panels = new ArrayList<>();

    public PanelRepositoryTestDouble() {

        panels.add(new Panel(1, "Mars", 5, 5, 2020, Material.COPPER_INDIUM, "Yes"));
        panels.add(new Panel(2, "Moon", 6, 6, 2020, Material.CADMIUM_TELLURIDE, "Yes"));
        panels.add(new Panel(3, "Venus", 7, 7, 2019, Material.AMORPHOUS_SILICON, "NO"));
        panels.add(new Panel(4, "Mars", 8, 8, 2019, Material.AMORPHOUS_SILICON, "Yes"));
        panels.add(new Panel(5, "Moon", 9, 9, 2018, Material.AMORPHOUS_SILICON, "Yes"));
    }


    @Override
    public List<Panel> findAll() throws DataException {
        return new ArrayList<>(panels);
    }



    @Override
    public Panel findById(int panelId) throws DataException {
        for (Panel p : panels) {
            if (p.getPanelId() == panelId) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Panel> findBySection(String section) throws DataException {
        List<Panel> results = new ArrayList<>();
        for (Panel p : panels) {
            if (p.getSection().equalsIgnoreCase(section)) {
                results.add(p);
            }
        }
        return results;
    }

    @Override
    public List<Panel> findByType(Material type) throws DataException {
        return null;
    }

    @Override
    public Panel add(Panel panel) throws DataException {
        // No need to add to panels. We're not going to confirm.
        panels.add(panel);
        return panel;
    }

    @Override
    public boolean update(Panel panel) throws DataException {
        return findById(panel.getPanelId()) != null;
    }


    @Override
    public boolean deleteById(int panelId) throws DataException {
        return findById(panelId) != null;
    }
    @Override
    public boolean deleteBySection(String sectionName) throws DataException {
        return false;
    }


}
