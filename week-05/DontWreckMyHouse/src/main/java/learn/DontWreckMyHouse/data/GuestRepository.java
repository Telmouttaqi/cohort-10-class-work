package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Guest;

import java.util.List;

public interface GuestRepository {

    List<Guest> findAll() throws DataException;

    Guest findGuestByEmail(String guestEmail) throws DataException;

    Guest findGuestById(int guestId) throws DataException;

}
