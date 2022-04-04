package learn.DontWreckMyHouse;

import learn.DontWreckMyHouse.data.GuestFileRepository;
import learn.DontWreckMyHouse.data.HostFileRepository;
import learn.DontWreckMyHouse.data.ReservationFileRepository;
import learn.DontWreckMyHouse.domain.GuestService;
import learn.DontWreckMyHouse.domain.HostService;
import learn.DontWreckMyHouse.domain.ReservationService;
import learn.DontWreckMyHouse.ui.ConsoleIO;
import learn.DontWreckMyHouse.ui.Controller;
import learn.DontWreckMyHouse.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("classpath:data.properties")
public class App {

    public static void main(String[] args) {


            ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

            Controller controller = context.getBean(Controller.class);

            controller.run();
        }
 }




    /*    ConsoleIO io = new ConsoleIO();
        View view = new View(io);

        ReservationFileRepository reservationFileRepository = new ReservationFileRepository("./data/reservations");
        GuestFileRepository guestFileRepository = new GuestFileRepository("./data/guests.csv");
        HostFileRepository hostFileRepository = new HostFileRepository("./data/hosts.csv");


        GuestService guestService = new GuestService(guestFileRepository);
        HostService hostService = new HostService(hostFileRepository);
        ReservationService reservationService =
                new ReservationService(guestFileRepository,hostFileRepository,reservationFileRepository);


        Controller controller = new Controller(guestService,hostService,reservationService,view);
        controller.run();*/





