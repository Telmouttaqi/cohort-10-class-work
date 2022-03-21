package learn.solar.ui;

public enum MenuOption {
    EXIT("Exit"),
    DISPLAY_ORBITERS("Find Panels by section"),
    CREATE_ORBITERS("Add Panels"),
    UPDATE_ORBITER("Update a Panel"),
    DELETE_ORBITER("Remove a Panel");


    private final String title;

    MenuOption(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

