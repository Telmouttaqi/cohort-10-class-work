package learn;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class App {
    public static void main(String[] args) {


        LocalDate birth = LocalDate.of(1993, Month.JULY,9);
        LocalDate Wife  = LocalDate.of(1995,Month.AUGUST,12);
        //birth = birth.plusWeeks(-1);
        //System.out.println(birth);
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        //Period periodBetween = Period.between((birth,Wife));

        Duration duration = Duration.between(birth,Wife);




    }
}
