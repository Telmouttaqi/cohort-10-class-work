package learn.DontWreckMyHouse.domain;

import learn.DontWreckMyHouse.data.DataException;
import learn.DontWreckMyHouse.data.GuestRepository;
import learn.DontWreckMyHouse.models.Guest;

import java.util.List;

public class GuestService {

    private final GuestRepository repository;


    public GuestService(GuestRepository repository) {
        this.repository = repository;
    }

    public List<Guest> findAll() throws DataException{
        return repository.findAll();
    }

    public Guest findGuestByEmail(String guestEmail) throws DataException {
        return repository.findGuestByEmail(guestEmail);
    }


}
