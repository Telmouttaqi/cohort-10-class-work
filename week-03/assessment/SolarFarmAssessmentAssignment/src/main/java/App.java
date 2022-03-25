import learn.solar.ui.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@ComponentScan // 2. Tells Spring to scan all classes in this package or its children.
//@PropertySource("classpath:data.properties")

public class App {
    public static void main(String[] args) {

    /*
            Regular !

        TextIO io = new ConsoleIO();
        View view = new View(io);

        PanelFileRepository repository = new PanelFileRepository("./data/solarpanel.csv");
        PanelService service = new PanelService(repository);

        Controller controller = new Controller(view,service);
        controller.run();
*/


        ApplicationContext container = new ClassPathXmlApplicationContext("dependency-configuration.xml");

        Controller controller = container.getBean(Controller.class);

        controller.run();


    }

}

  /*


*/