package learn.solar.models;

// -- solar panel model

// build from back to front
public class Panel {
    // model layers
    private int panelId;
    private String section;
    private int row;
    private int column;
    private int year;
    private Material type;
    private String IsTracking;



    public Panel(int panelId,String section, int row, int column, int year, Material type, String isTracking) {
        this.panelId = panelId;
        this.section = section;
        this.row = row;
        this.column = column;
        this.year = year;
        this.type = type;
        IsTracking = isTracking;
    }

    public Panel() {

    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Material getType() {
        return type;
    }

    public void setType(Material type) {
        this.type = type;
    }

    public String getIsTracking() {
        return IsTracking;
    }

    public void setIsTracking(String isTracking) {
        IsTracking = isTracking;
    }
    public int getPanelId() {return panelId;}

    public void setPanelId(int panelId) {this.panelId = panelId;
    }
}
