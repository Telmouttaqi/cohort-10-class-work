package learn.DontWreckMyHouse.domain;

import learn.DontWreckMyHouse.data.DataException;
import learn.DontWreckMyHouse.data.GuestRepository;
import learn.DontWreckMyHouse.models.Guest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public Result findByEmail(String email) throws DataException {
        Result<Guest> result = new Result();
        Guest guest = repository.findGuestByEmail(email);
        if (guest == null) {
            result.addErrorMessage("No Guest found with email address \"" + email + "\".");
        } else {
            result.setPayload(guest);
        }
        return result;
    }


}
