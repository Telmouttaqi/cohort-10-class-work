package learn.DontWreckMyHouse.ui;

import learn.DontWreckMyHouse.data.DataException;
import learn.DontWreckMyHouse.domain.GuestService;
import learn.DontWreckMyHouse.domain.HostService;
import learn.DontWreckMyHouse.domain.ReservationService;
import learn.DontWreckMyHouse.domain.Result;
import learn.DontWreckMyHouse.models.Guest;
import learn.DontWreckMyHouse.models.Host;
import learn.DontWreckMyHouse.models.Reservation;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class Controller {
    private final GuestService guestService;
    private final HostService hostService;
    private final ReservationService reservationService;
    private final View view;
    private ConsoleIO io;

    public Controller(GuestService guestService, HostService hostService, ReservationService reservationService, View view) {
        this.guestService = guestService;
        this.hostService = hostService;
        this.reservationService = reservationService;
        this.view = view;
    }

    public void run() {

        view.displayHeader("Don't Wreck My House");
        try {
            runAppLoop();
        } catch (DataException ex) {
            view.displayException(ex);
        }
        view.displayHeader("Goodbye.");
    }

    private void runAppLoop() throws DataException {
        MainMenuOption option;
        do {
            option = view.selectMainMenuOption();
            switch (option) {
                case VIEW_RESERVATIONS_FOR_HOST:
                    viewReservationForHost();
                    view.enterToContinue();
                    break;
                case ADD_RESERVATION:
                    AddReservation();
                    //view.enterToContinue();
                    view.enterToContinue();
                    break;
                case EDIT_RESERVATION:
                    editReservation();
                    view.enterToContinue();
                    break;
                case CANCEL_RESERVATION:
                    cancelReservation();
                    view.enterToContinue();
                    break;
            }

        }
        while (option != MainMenuOption.EXIT);
    }

    private void viewReservationForHost() throws DataException {
        view.displayHeader(MainMenuOption.VIEW_RESERVATIONS_FOR_HOST.getMessage());
        String hostEmail = view.getHostEmail();
        Host host = hostService.findHostByEmail(hostEmail);
        if (host == null) {
            System.out.println("Host Email does not exist.");
            return;
        }
        List<Reservation> reservations = reservationService.findByHost(host);
        view.displayReservations(reservations);
    }


    private void AddReservation() throws DataException {
        Scanner console = new Scanner(System.in);
        view.displayHeader(MainMenuOption.ADD_RESERVATION.getMessage());

        Guest guest = getGuest();
        if (guest == null) {
            System.out.println("Guess Not found.");
            return;
        }
        Host host = getHost();

        if (host == null) {
            System.out.println("Host not found.");
        }

        List<Reservation> reservations = reservationService.findByHost(host);
        view.displayReservations(reservations);
        Reservation reservation = view.makeReservation(guest, host);
        reservation.setTotal(calculateTotal(reservation.getStartDate(),reservation.getEndDate(),host));
        view.confirmation(reservation);
        String yesOrNo = console.nextLine();
        if (yesOrNo.equalsIgnoreCase("y")) {
            Result<Reservation> result = reservationService.add(reservation);
            if (!result.isSuccess()) {
                view.displayStatus(false, result.getErrorMessages());
            } else {

                String successMessage = String.format("Reservation %s Added", result.getPayload().getReservationId());
                view.displayStatus(true, successMessage);
            }

        } else {
            System.out.println("Ok, try a different host for a better price. ");
        }
    }

    // guest email kcurson5@youku.com
    private Guest getGuest() throws DataException {
        String guestEmail = view.getGuestEmail();
        return guestService.findGuestByEmail(guestEmail);
    }

    private Host getHost() throws DataException {
        String hostEmail = view.getHostEmail();
        return hostService.findHostByEmail(hostEmail);


    }


    // host  email  : lhannonay@cyberchimps.com ===> id b1d69bea-c9be-4217-aeba-bb04e414edc3
    // guest email  : hmounchia@clickbank.net :  id 659

    public void editReservation() throws DataException {
        Scanner console = new Scanner(System.in);
        view.displayHeader(MainMenuOption.ADD_RESERVATION.getMessage());

        Guest guest = getGuest();
        if (guest == null) {
            System.out.println("Guess Not found.");
            return;
        }

        Host host = getHost();
        if (host == null) {
            System.out.println("Host not found.");
        }

        List<Reservation> reservations = reservationService.findByHost(host);
        view.displayForEditing(reservations, guest);
        System.out.print("Reservation ID : ");
        int inputReservation = Integer.parseInt(console.nextLine());
        if(inputReservation < 0 ) {
            System.out.println("Sorry try again out of the range.");
            return;
        }
        Reservation reservation = view.editReservation(guest, host);
        reservation.setTotal(calculateTotal(reservation.getStartDate(),reservation.getEndDate(),host));
        view.confirmation(reservation);
        String yesOrNo = console.nextLine();
        if (yesOrNo.equalsIgnoreCase("y")) {

            reservation.setReservationId(inputReservation);
            Result<Reservation> result = reservationService.update(reservation);
            if (!result.isSuccess()) {
                view.displayStatus(false, result.getErrorMessages());
            } else {

                String successMessage = String.format("Reservation %s updated.", result.getPayload().getReservationId());
                view.displayStatus(true, successMessage);
            }

        } else {
            System.out.println("Ok try a different days to get a cheap price. ");
        }
    }

    public void cancelReservation() throws DataException {

        Scanner console = new Scanner(System.in);
        view.displayHeader(MainMenuOption.CANCEL_RESERVATION.getMessage());

        Guest guest = getGuest();
        if (guest == null) {
            System.out.println("Guess Not found.");
            return;
        }
        Host host = getHost();
        if (host == null) {
            System.out.println("Host not found.");
        }

        List<Reservation> reservations = reservationService.findByHost(host);

        view.displayForEditing(reservations, guest);
        System.out.print("Reservation ID : ");
        int inputReservation = Integer.parseInt(console.nextLine());
        System.out.println(inputReservation);

        Reservation reservation = view.cancelReservation(guest,host);
        System.out.println("Are you sure you would like to delete Reservation ID: "+inputReservation+"[Y/N]");
        String yesOrNo = console.nextLine();
        if (yesOrNo.equalsIgnoreCase("y")) {
            reservation.setReservationId(inputReservation);
            Result<Reservation> result = reservationService.delete(reservation,inputReservation);

            if (!result.isSuccess()) {
                view.displayStatus(false, result.getErrorMessages());
            } else {

                String successMessage = String.format("Reservation %s deleted.", result.getPayload().getReservationId());
                view.displayStatus(true, successMessage);
            }

        }
    }



    public BigDecimal calculateTotal(LocalDate startDate,LocalDate endDate,Host host) {

        BigDecimal weekdays = new BigDecimal(0);
        BigDecimal weekends = new BigDecimal(0);

        for (LocalDate start = startDate; start.isBefore(endDate); start = start.plusDays(1)) {

            if (start.getDayOfWeek().equals(DayOfWeek.MONDAY)
                    || start.getDayOfWeek().equals(DayOfWeek.TUESDAY)
                    || start.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)
                    || start.getDayOfWeek().equals(DayOfWeek.THURSDAY)
                    || start.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                weekdays = weekdays.add(new BigDecimal(1));
            } else {
                weekends = weekends.add(new BigDecimal(1));
            }
        }

        BigDecimal weekdayCost = host.getStandardRate().multiply(weekdays);
        BigDecimal weekendCost = host.getWeekEndRate().multiply(weekends);

        return weekdayCost.add(weekendCost);
    }

}






