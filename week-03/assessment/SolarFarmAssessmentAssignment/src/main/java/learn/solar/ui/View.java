package learn.solar.ui;
import learn.solar.domain.PanelResult;
import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Component
public class View {

    private final TextIO io;

    private final Scanner console = new Scanner(System.in);

    public View(TextIO io) {
        this.io = io;
    }


    public MenuOption displayMenuAndSelect() {
        MenuOption[] values = MenuOption.values();
        printHeader("Main Menu");
        for (int i = 0; i < values.length; i++) {
            System.out.printf("%s. %s%n", i, values[i].getTitle());
        }
        int index = io.readInt("Select [ 0-4 ]:  ", 0, 4);
        return values[index];
    }


    public String selectSectionToDisplay(List<Panel> panels) {
        List<String> sections = new ArrayList<>();
        for (int i = 0; i < panels.size(); i++) {
            if (!sections.contains(panels.get(i).getSection())) {
                sections.add(panels.get(i).getSection());
                continue;
            }
        }
        displaySections(sections);
        return sections.get(io.readInt("Choose a Section [1-" + sections.size() + "]: ", 1, sections.size()) - 1);
    }

    private void displaySections(List<String> sections) {
        printHeader("Viewing All Sections");
        for (int i = 0; i < sections.size(); i++) {
            System.out.println((i + 1) + ". " + sections.get(i));

        }
    }

    public void printHeader(String message) {
        int length = message.length();
        System.out.println("");
        System.out.println(message);
        System.out.println("=".repeat(length));
    }

    public void printResult(PanelResult result) {
        if (result.isSuccess()) {

        } else {
            printHeader("Errors");
            for (String msg : result.getMessages()) {
                System.out.printf("- %s%n", msg);
                System.out.println("Please tey again.");
            }
        }
    }

    // Just used one catch-all printPanels method for anytime we needed to print out an array of panels
    public void printPanels(List<Panel> panels) {

        if (panels == null || panels.size() == 0) {
            System.out.println();
            System.out.println("No Panels Found.");
        } else {
            System.out.printf("%-12s%-12s%-12s%-12s%-12s%-30s%-20s\n","Panel ID", "Section", "ROW", "COL", "YEAR", "MATERIAL", "TRACKING");
            for (Panel p : panels) {
                /*System.out.printf("ID: %s | Section: %s | Row: %s | Column: %s | Year: %s | Material: %s | Tracked? %s%n",
                        p.getPanelId(),
                        p.getSection(),
                        p.getRow(),
                        p.getColumn(),
                        p.getYear(),
                        p.getType(),
                        p.isTracking()); */


                System.out.printf("%-12d%-12s%-12d%-12d%-12d%-30s%-20s\n",p.getPanelId(), p.getSection(), p.getRow(),
                        p.getColumn(), p.getYear(), p.getType().label, p.getIsTracking());
            }
        }
    }

    public int deletePanel(List<Panel> panels) {
        printPanels(panels);

        System.out.println();
        System.out.println();
        return io.readInt("Can you please enter the Panel Id you would like to delete.");
    }

    public Panel createPanel() {
        Panel panel = new Panel();
        System.out.println("");
        System.out.println();
        panel.setSection(io.readRequiredString("Section: "));
        panel.setRow(io.readInt("Row: ", 1, 250));
        panel.setColumn(io.readInt("Column: ", 1, 250));
        panel.setYear(io.readInt("Installation Year: ", 1890, 2021));
        panel.setType(printMaterialsAndSelect());
        panel.setIsTracking(io.readString("Tracked [yes/no]"));
        System.out.println();
        return panel;
    }

    public Panel update(Panel panel) {
        printHeader("Updating Panel");
        System.out.println();
        System.out.println("Press [Enter] to keep original value.");
        System.out.println();
        System.out.println("Material : " + panel.getType());
        Material type = printMaterialsAndSelect();
        panel.setType(type);
        String year = io.readString("Installation Year (" + panel.getYear() + ") : ");
        if (year.trim().length() > 0) {
            panel.setYear(Integer.parseInt(year));
        }
        String isTracking = io.readString("Tracked (" + panel.getIsTracking() + "): [y/n] ");
        if(isTracking.equals("y")){
            panel.setIsTracking("Yes");
        }else{
            panel.setIsTracking("No");
        }
        /*if (isTracking.trim().length() > 0) {
            if (isTracking.equalsIgnoreCase("y")) {
                panel.setIsTracking("Yes");//
            } else if (isTracking.equalsIgnoreCase("n")) {
                panel.setIsTracking("No");//

            }
        }*/

        return panel;
    }

    public Panel updatePanel(List<Panel> panels) {
        printPanels(panels);
        if (panels.size() == 0) {
            return null;
        }
        System.out.println();
        int panelId = io.readInt("Enter ID of Panel You Wish To Update: ");
        for (Panel p : panels) {
            if (p.getPanelId() == panelId) {
                return update(p);
            }
        }
        System.out.println("Panel Id " + panelId + " not found.");
        return null;
    }



    private Material printMaterialsAndSelect() {
        System.out.println("Material Selection:");
        Material[] materials = Material.values();
        Material result = null;
        for (int i = 0; i < materials.length; i++) {
            System.out.println((i + 1) + ". " + materials[i]);
        }
        int choice = io.readInt("Choose Material [1-5]: ", 1, 5);
        switch (choice) {
            case 1:
                result = Material.MULTICRYSTALLINE_SILICON;
                break;
            case 2:
                result = Material.MONOCRYSTALLINE_SILICON;
                break;
            case 3:
                result = Material.AMORPHOUS_SILICON;
                break;
            case 4:
                result = Material.CADMIUM_TELLURIDE;
                break;
            case 5:
                result = Material.COPPER_INDIUM;
                break;
        }
        return result;
    }






}

