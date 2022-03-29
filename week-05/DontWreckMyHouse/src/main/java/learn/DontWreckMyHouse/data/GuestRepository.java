package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Guest;

import java.util.List;

public interface GuestRepository {


    List<Guest> findAll();

    List<Guest> findGuestById();

    List<Guest> findGuestByEmail();


}
