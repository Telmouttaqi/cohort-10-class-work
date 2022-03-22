package learn.solar.ui;

import learn.solar.data.DataException;
import learn.solar.domain.PanelResult;
import learn.solar.domain.PanelService;
import learn.solar.models.Panel;

import java.util.List;

public class Controller {


    private View view;
    private final PanelService service;

    public Controller(View view, PanelService service) {
        this.view = view;
        this.service = service;
    }

    public  void run() {
        view.printHeader("Welcome to Solar Farm");

        try {
            runMenuLoop();
        } catch (DataException ex) {
            view.printHeader("[Err]:" + ex.getMessage());
        }
        view.printHeader("GoodBye.");
    }

    public void runMenuLoop() throws DataException {
        MenuOption option ;
        do {
            option = view.displayMenuAndSelect();
            System.out.println();
            switch(option) {
                case EXIT:
                    break;
                case DISPLAY_ORBITERS:
                    displayAllPanels();
                    //displayPanelsBySection();
                    break;
                case CREATE_ORBITERS:
                    addPanel();
                    break;
                case UPDATE_ORBITER:
                    updatePanel();
                    break;
                case DELETE_ORBITER:
                    deletePanel();
                    break;

            }
        } while (option != MenuOption.EXIT);
    }

    private void displayAllPanels() throws DataException {
        List<Panel> panels = service.findAll();
        view.printHeader("Viewing All Panels");
        view.printPanels(panels);
    }

    private void displayPanelsBySection() throws DataException {
        view.printHeader("Select a Section");
        List<Panel> panels = service.findAll();
        String section = view.selectSectionToDisplay(panels);
        List<Panel> panelsBySection = service.findBySection(section);
        view.printHeader("Viewing Panels in Section \"" + section + "\"");
        view.printPanels(panelsBySection);

    }

    private void addPanel() throws DataException {
        view.printHeader("Add a Panel");
        Panel panel = view.createPanel();
        PanelResult result = service.add(panel);
        view.printResult(result);
    }

    private void updatePanel() throws DataException {
        view.printHeader("Update a Panel");
        List<Panel> panels = service.findAll();
        Panel panel = view.updatePanel(panels);
        PanelResult result = service.update(panel);
        view.printResult(result);
    }

    private void deletePanel() throws DataException {
        view.printHeader("Delete a Panel");
        List<Panel> panels = service.findAll();
        int panelId = view.deletePanel(panels);
        PanelResult result = service.deleteById(panelId);
        view.printResult(result);
    }

}