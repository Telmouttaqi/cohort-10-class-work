package learn.DontWreckMyHouse.data;
import learn.DontWreckMyHouse.data.DataException;
import learn.DontWreckMyHouse.models.Reservation;

import java.util.List;

public interface ReservationRepository {

    List<Reservation> findAll(String hostId) throws DataException;

    Reservation add(Reservation reservation) throws DataException;

    boolean update(Reservation reservation) throws DataException;

    boolean delete(Reservation reservation) throws DataException;

}
