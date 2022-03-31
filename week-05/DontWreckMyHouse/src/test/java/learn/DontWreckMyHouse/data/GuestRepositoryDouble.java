package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Guest;

import java.util.ArrayList;
import java.util.List;


// implement guest Repo to the guest repo double .
public class GuestRepositoryDouble implements GuestRepository {

    private List<Guest> guests = new ArrayList<>();

    public GuestRepositoryDouble(){
        // Guest(int guestId, String firstName, String lastName, String email, String phone, String state)
        guests.add(new Guest(1,"Tawfik","El-mouttaqi",
                "Test@test.com","6179439020","NC"));
        guests.add(new Guest(2,"test2","lastNameTest",
                "Test@test2.com","7179439020","MA"));


    }

    @Override
    public List<Guest> findAll() throws DataException {
        return guests;
    }

    @Override
    public Guest findGuestByEmail(String guestEmail) throws DataException {
        return guests.stream()
                .filter(guest -> guest.getEmail().equalsIgnoreCase(guestEmail))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Guest findGuestById(int guestId) throws DataException {
        return guests.stream()
                .filter(guest -> guest.getGuestId() == guestId)
                .findFirst()
                .orElse(null);
    }
}
