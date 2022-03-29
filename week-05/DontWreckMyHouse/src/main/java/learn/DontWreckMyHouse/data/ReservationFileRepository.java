package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Host;
import learn.DontWreckMyHouse.models.Reservation;

import java.util.List;

public class ReservationFileRepository {

    private final String directory;

    public ReservationFileRepository(String directory) {
        this.directory = directory;
    }

    public List<Reservation> findAll(){
        return null;
    }


}
