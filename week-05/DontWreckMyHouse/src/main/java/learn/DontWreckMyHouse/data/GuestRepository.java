package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Guest;

import java.util.List;

public interface GuestRepository {


    List<Guest> findAll();

    Guest findGuestByEmail(String guestEmail);

    Guest findGuestById(int guestId);


}
