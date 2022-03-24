package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.util.List;

public interface PanelRepository {

    List<Panel> findAll() throws DataException;

    List<Panel> findBySection(String section) throws DataException;

    Panel findById(int panelId) throws DataException;

    List<Panel> findByType(Material type) throws DataException;

    Panel add(Panel panel) throws DataException;

    boolean update(Panel panel) throws DataException;

    boolean deleteById(int panelId) throws DataException;

    boolean deleteBySection(String sectionName) throws DataException;
}