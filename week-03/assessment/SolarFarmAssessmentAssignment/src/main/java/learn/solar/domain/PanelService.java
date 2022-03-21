package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepository;
import learn.solar.models.Panel;

import java.util.List;

public class PanelService {

    private final PanelRepository repository;

    public PanelService(PanelRepository repository) {
        this.repository = repository;
    }

    public List<Panel> findAll()throws DataException {
        return repository.findAll();
    }

    public List<Panel> findBySection(String section)throws DataException{
        return repository.findBySection(section);
    }

    public Panel findById (int PanelId) throws DataException {
        return repository.findById(PanelId);
    }


    // ADD PANEL!
    public PanelResult add(Panel Panel)throws DataException{
        PanelResult result = validate(Panel);
        if(!result.isSuccess()){
            return result;
        }
        List<Panel> Panels =repository.findAll();
        for(Panel o: Panels){
            if(Panel.getSection().equals(o.getSection()) && o.getRow() == Panel.getRow() && o.getColumn() == Panel.getColumn()){
                result.addErrorMessage("Panel already installed in this location.");
                return result;
            }
        }
        Panel = repository.add(Panel);
        result.setPayload(Panel);
        System.out.println("[Success]");
        //System.out.println("Panel " + Panel.getSection()+ " Has been added." +  "-" + "");
        System.out.printf("Panel %s - %d - %d added",Panel.getSection(),Panel.getRow(),Panel.getColumn());
        System.out.println("");

        return result;
    }

    public PanelResult update(Panel Panel) throws DataException {
        PanelResult result = validate(Panel);

        if (result.getMessages().contains("Panel should not be null ")) {
            return result;
        }
        if (Panel.getPanelId() <= 0) {
            result.addErrorMessage("ID must be greater then 0");
        }
        if (result.isSuccess()) {
            if (repository.update(Panel)) {
                result.setPayload(Panel);
                System.out.println("Panel " + Panel.getPanelId() + " Has Been Updated.");
            } else {
                result.addErrorMessage("Could Not Find Panel With ID " + Panel.getPanelId());
            }
        }
        return result;
    }


    public PanelResult deleteById(int panelId) throws DataException {
        PanelResult result = new PanelResult();
        boolean isDeleted = repository.deleteById(panelId);
        if (!isDeleted) {
            result.addErrorMessage("Could Not Find Panel With ID " + panelId);
        }
        System.out.println();
        System.out.println("Panel " + panelId + " Has Been Deleted.");
        return result;
    }

    private PanelResult validate(Panel panel) {
        PanelResult result = new PanelResult();
        if (panel == null) {
            result.addErrorMessage("Panel Cannot Be Null.");
            return result;
        }
        if (panel.getSection() == null || panel.getSection().isEmpty()) {
            result.addErrorMessage("Panel Section is Required.");
        }
        if (panel.getRow() < 1 ||panel.getRow() > 250) {
            result.addErrorMessage("Panel Rows Must Be Between 1 and 250.");
        }
        if (panel.getColumn() < 1 || panel.getColumn() > 250) {
            result.addErrorMessage("Panel Columns Must Be Between 1 and 250.");
        }
        if (panel.getYear() >= 2022) {
            result.addErrorMessage("Panels Cannot Be Installed In the Future.");
        }
        if (panel.getType() == null) {
            result.addErrorMessage("Panel Material is Required.");
        }
        return result;
    }
}
