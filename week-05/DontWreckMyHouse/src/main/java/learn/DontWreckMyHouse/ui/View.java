package learn.DontWreckMyHouse.ui;
import learn.DontWreckMyHouse.models.Guest;
import learn.DontWreckMyHouse.models.Host;
import learn.DontWreckMyHouse.models.Reservation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.List;

@Component
public class View {
    private final ConsoleIO io;
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public View(ConsoleIO io) {
        this.io = io;
    }

    public void enterToContinue() {
        io.readString("Press [Enter] to continue.");
    }

    public MainMenuOption selectMainMenuOption() {
        displayHeader("Main Menu");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (MainMenuOption option : MainMenuOption.values()) {
            if (!option.isHidden()) {
                io.printf("%s. %s%n", option.getValue(), option.getMessage());
            }
            min = Math.min(min, option.getValue());
            max = Math.max(max, option.getValue());
        }
        String message = String.format("Select [%s-%s]: ", min, max);
        return MainMenuOption.fromValue(io.readInt(message, min, max));
    }

    public void displayHeader(String message) {
        io.println("");
        io.println(message);
        io.println("=".repeat(message.length()));
    }

    public void displayException(Exception ex) {
        displayHeader("A critical error occurred:");
        io.println(ex.getMessage());
    }

    public String getHostEmail() {
        return io.readRequiredString("Host Email: ");
    }
    public String getGuestEmail() {
        return io.readRequiredString("Guest Email: ");
    }

    public void displayStatus(boolean success, String message) {
        displayStatus(success, List.of(message));
    }

    public void displayStatus(boolean success, List<String> messages) {
        displayHeader(success ? "Success" : "Error");
        for (String message : messages) {
            io.println(message);
        }

    }

    public void displayReservations(List<Reservation> reservations) {

        if (reservations == null || reservations.isEmpty()) {
            io.println("No reservations found.");

        }
        reservations.sort(Comparator.comparing(Reservation::getStartDate));
        for (Reservation reservation : reservations) {
                    System.out.println("");
                    displayHeader(
                            reservation.getHost().getLastName()
                                    + ", " + reservation.getHost().getCity()
                                        + " - " + reservation.getHost().getState());
                    break;

        }
        for (Reservation reservation : reservations) {
            io.printf("ID: %s, %s - %s, Guest: %s, %s, Email: %s, Total: $%s%n",
                    reservation.getReservationId(),
                    reservation.getStartDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                    reservation.getEndDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                    reservation.getGuest().getFirstName(),
                    reservation.getGuest().getLastName(),
                    reservation.getGuest().getEmail(),
                    reservation.getTotal());
        }


    }

    public Reservation makeReservation(Guest guest, Host host) {
        Reservation reservation = new Reservation();
        reservation.setGuest(guest);
        reservation.setHost(host);
        reservation.setStartDate(io.readLocalDate("Start (MM/dd/yyyy) : "));
        reservation.setEndDate(io.readLocalDate("End (MM/dd/yyyy) : "));
        return reservation;
    }

    public Reservation editReservation(Guest guest, Host host) {
        Reservation reservation = new Reservation();

        reservation.setGuest(guest);
        reservation.setHost(host);

        reservation.setStartDate(io.readLocalDate("Start (MM/dd/yyyy) : "));
        reservation.setEndDate(io.readLocalDate("End (MM/dd/yyyy) : "));

        return reservation;
    }
    public Reservation cancelReservation(Guest guest,Host host) {

        Reservation reservation = new Reservation();
        reservation.setGuest(guest);
        reservation.setHost(host);
        return reservation;

    }

    public void confirmation(Reservation reservation) {
        System.out.println("Summary");
        System.out.println("=======");
        System.out.println("Start: "+ reservation.getStartDate());
        System.out.println("End: "+reservation.getEndDate());
        System.out.println("Total: $"+reservation.getTotal());
        System.out.println("Is This Okay? [Y/N]");
    }

    public void deleteConfirmation() {
        System.out.println("Is This Okay? [Y/N]");

    }

    public void displayForEditing(List<Reservation> reservations,Guest emailGuest) {
        if (reservations == null || reservations.isEmpty()) {
            io.println("No reservations found.");
            return;
        }
        reservations.sort(Comparator.comparing(Reservation::getStartDate));

        for (Reservation reservation : reservations) {
            io.printf("%s : %s , %s \n",
                    reservation.getHost().getLastName(),
                    reservation.getHost().getCity(),
                    reservation.getHost().getState());
                    break;

        }

        for (Reservation reservation : reservations) {
            io.printf("ID: %s, %s - %s, Guest: %s, %s, Email: %s, Total: $%s%n",
                            reservation.getReservationId(),
                            reservation.getStartDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                            reservation.getEndDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                            reservation.getGuest().getFirstName(),
                            reservation.getGuest().getLastName(),
                            reservation.getGuest().getEmail(),
                            reservation.getTotal());
                        }

    }

    public void MessageDelete(Reservation reservation) {
        System.out.println("are you sure you would like to delete the id: "+reservation.getReservationId());
    }

    public void userConfirmation() {
        io.readRequiredString("Yes or no :");
    }





}



