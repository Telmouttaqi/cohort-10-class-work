package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class PanelFileRepository implements PanelRepository{

    private final String filePath;
    private static final String HEADER ="panel_id,section,row,col,year,material,isTracking";


    public PanelFileRepository(@Value("./data/solarPanel.csv") String filePath) {
        this.filePath = filePath;
    }

    public List<Panel> findAll() throws DataException {

        ArrayList<Panel> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] fields = (line.split(",", -1));
                if (fields.length == 7) {

                    Panel panel = new Panel();
                    panel.setPanelId(Integer.parseInt(fields[0]));
                    panel.setSection(fields[1]);
                    panel.setRow(Integer.parseInt(fields[2]));
                    panel.setColumn(Integer.parseInt(fields[3]));
                    panel.setYear(Integer.parseInt(fields[4]));
                    panel.setType(Material.valueOf(fields[5]));
                    if(fields[6].equalsIgnoreCase("yes")){
                        panel.setIsTracking("yes"); //
                    }else{
                        panel.setIsTracking("no"); //
                    }
                    result.add(panel);
                }
            }
        }catch (FileNotFoundException ex){
            // Okay to ignore
        } catch (IOException ex) {
            throw new DataException(ex.getMessage(),ex);
            // Do nothing
        }

        return result;
    }

    @Override
    public List<Panel> findBySection(String section) throws DataException {
        List<Panel> result = findAll();
        List<Panel> sectionPanel = new ArrayList<>();
        for(Panel panel : result){
            if(panel.getSection().equals(section)){
                sectionPanel.add(panel);
            }
        }
        return sectionPanel;
    }

    // find the panel by ID

    @Override
    public Panel findById(int panelId) throws DataException {
        for (Panel panel : findAll()) {
            if (panel.getPanelId() == panelId) {
                return panel;
            }
        }
        return null;
    }

    // find by type material.

    @Override
    public List<Panel> findByType(Material type) throws DataException {
        ArrayList<Panel> result = new ArrayList<>();
        for (Panel panel : findAll()) {
            if (panel.getType() == type) {
                result.add(panel);
            }
        }
        return result;

    }

    // add panel

    @Override
    public Panel add(Panel panel) throws DataException {
        List<Panel> all = findAll();
        int nextId = 0;
        for(Panel o:all) {
            nextId = Math.max(nextId, o.getPanelId());
        }
        nextId++;
        panel.setPanelId(nextId);
        all.add(panel);
        writeAll(all);
        return panel;

    }

    // Update by Panel ID

    @Override
    public boolean update(Panel panel) throws DataException {
        List<Panel> all = findAll();

        for(int i = 0 ; i < all.size() ; i++){
            if (all.get(i).getPanelId() == panel.getPanelId()){
                all.set(i,panel);
                writeAll(all);
                return true;
            }
        }
        return false;

    }

    // delete by Panel ID

    @Override
    public boolean deleteById(int panelId) throws DataException {
        List<Panel> all = findAll();

        for(int i = 0 ; i < all.size() ; i++){
            if (all.get(i).getPanelId() == panelId){
                all.remove(i);
                writeAll(all);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteBySection(String sectionName) throws DataException {
        List<Panel> all = findAll();

        for(int i = 0 ; i < all.size() ; i++){
            if (all.get(i).getSection() == sectionName){
                all.remove(i);
                writeAll(all);
                return true;
            }
        }
        return false;
    }


    // Write All the result inside the file.
    private void writeAll(List<Panel> panels) throws DataException {

        try (PrintWriter writer = new PrintWriter(filePath)){
            writer.println(HEADER); // Print the header
            for (Panel o: panels){
                writer.println(serialize(o));
            }
        }catch (IOException ex){
            throw new DataException(ex.getMessage(),ex);


        }

    }


    // Serialize the result.
    private String serialize(Panel panel){
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                panel.getPanelId(),
                panel.getSection(),
                panel.getRow(),
                panel.getColumn(),
                panel.getYear(),
                panel.getType(),
                panel.getIsTracking());
    }


}
