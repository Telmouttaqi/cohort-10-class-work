package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Host;
import learn.DontWreckMyHouse.models.Reservation;

import java.util.List;

public class ReservationFileRepository {

    private static final String HEADER = "id,start_date,end_date,guest_id,total";
    private final String directory;

    public ReservationFileRepository(String directory) {
        this.directory = directory;
    }

    public List<Reservation> findAll(){
        return null;
    }


}
