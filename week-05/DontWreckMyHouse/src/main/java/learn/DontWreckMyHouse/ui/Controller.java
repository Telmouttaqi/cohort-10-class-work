package learn.DontWreckMyHouse.ui;

import learn.DontWreckMyHouse.data.DataException;
import learn.DontWreckMyHouse.domain.GuestService;
import learn.DontWreckMyHouse.domain.HostService;
import learn.DontWreckMyHouse.domain.ReservationService;

public class Controller {
    private final GuestService guestService;
    private final HostService hostService;
    private final ReservationService reservationService;
    private final View view;

    public Controller(GuestService guestService, HostService hostService, ReservationService reservationService, View view) {
        this.guestService = guestService;
        this.hostService = hostService;
        this.reservationService = reservationService;
        this.view = view;
    }

    public void run() {

        view.displayHeader("Welcome");
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
                    System.out.println("View Reservations for Host Working on it");
                    view.enterToContinue();
                    break;
                case ADD_RESERVATION:
                    System.out.println("Make a Reservation Working on it.");
                    view.enterToContinue();
                    break;
                case EDIT_RESERVATION:
                    System.out.println("Edit a Reservation Working on it. ");
                    view.enterToContinue();
                    break;
                case CANCEL_RESERVATION:
                    System.out.println("Cancel a Reservation Working on it ");
                    view.enterToContinue();
                    break;
            }

        }
        while (option != MainMenuOption.EXIT);
    }
}
