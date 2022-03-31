package learn.DontWreckMyHouse.data;


import learn.DontWreckMyHouse.models.Guest;
import learn.DontWreckMyHouse.models.Host;
import learn.DontWreckMyHouse.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationFileRepositoryTest {

    static final String SEED_FILE_PATH = "./data/reservation_data_test/reservation-seed-293508da-e367-437a-9178-1ebaa7d83015.csv";
    static final String TEST_FILE_PATH = "./data/reservation_data_test/293508da-e367-437a-9178-1ebaa7d83015.csv";
    static final String TEST_DIR_PATH = "./data/reservation_data_test";

    private final String hostId = "293508da-e367-437a-9178-1ebaa7d83015";



    private final LocalDate startDate = LocalDate.of(2022,4,15);
    private final LocalDate endDate = LocalDate.of(2022,4,23);
    private final BigDecimal sRate = new BigDecimal("360");
    private final BigDecimal wRate = new BigDecimal("300");

    ReservationFileRepository repository = new ReservationFileRepository(TEST_DIR_PATH);


    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void ShouldFindByHostId() throws DataException {

        List<Reservation> reservations = repository.findAll(hostId);
        assertEquals(13, reservations.size());

    }

    @Test
    void shouldHostIdReturnCorrectReservationData() throws DataException {
        List <Reservation> all = repository.findAll(hostId);
        // get the first guest from the list ID // 845
        assertEquals(all.get(0).getGuest().getGuestId(),845);
    }


    @Test
    void NotExistingData() throws DataException {
        List <Reservation> NotExistData = repository.findAll("test@test.com");
        // get the first guest from the list ID // 845
        assertEquals(0,NotExistData.size());
    }


    @Test
    void shouldAddReservation() throws DataException {
        Reservation reservation = new Reservation();
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);

        Host host = new Host();
        host.setHostId(hostId);
        reservation.setHost(host);

        Guest guest = new Guest();
        guest.setGuestId(9);
        reservation.setGuest(guest);
        reservation.setTotal(new BigDecimal("700"));
        reservation = repository.add(reservation);

        assertEquals(14, reservation.getReservationId());


    }

    @Test
    void shouldNotAddNullReservation() throws DataException {
        Reservation reservation = null;

        reservation = repository.add(reservation);

        assertNull(reservation);

    }

    @Test
    void shouldUpdate() throws DataException {
        Host host = new Host();
        host.setHostId(hostId);

        Guest guest = new Guest();
        guest.setGuestId(6);
        Reservation reservation = new Reservation();
        reservation.setReservationId(9);
        reservation.setStartDate(LocalDate.of(2022, 9, 8));
        reservation.setEndDate(LocalDate.of(2022, 9, 15));
        reservation.setGuest(guest);
        reservation.setHost(host);
        reservation.setTotal(new BigDecimal("2500"));

        boolean pass = repository.update(reservation);

        assertTrue(pass);
        assertNotNull(reservation);
        assertEquals(13,repository.findAll(hostId).size());


    }

    @Test
    void shouldNotUpdateNotExistingReservation() throws DataException {
        Host host = new Host();
        host.setHostId(hostId);

        Guest guest = new Guest();
        guest.setGuestId(6);
        Reservation reservation = new Reservation();
        reservation.setReservationId(369);
        reservation.setStartDate(LocalDate.of(2022, 9, 8));
        reservation.setEndDate(LocalDate.of(2022, 9, 15));
        reservation.setGuest(guest);
        reservation.setHost(host);
        reservation.setTotal(new BigDecimal("2500"));

        boolean pass = repository.update(reservation);

        assertFalse(pass);

    }

    @Test
    void shouldDeleteReservation() throws DataException {
        Host host = new Host();
        host.setHostId(hostId);

        Reservation reservation = new Reservation();

        Guest guest = new Guest();
        guest.setGuestId(3);
        reservation.setReservationId(2);
        reservation.setGuest(guest);
        reservation.setHost(host);

        boolean pass = repository.delete(reservation);
        assertTrue(pass);
    }

    @Test
     void shouldNotDeleteReservation() throws DataException {

        Host host = new Host();
        host.setHostId(hostId);

        Reservation reservation = new Reservation();

        Guest guest = new Guest();
        guest.setGuestId(6);
        reservation.setReservationId(56);
        reservation.setGuest(guest);
        reservation.setHost(host);

        boolean pass = repository.delete(reservation);
        assertFalse(pass);

    }
    @Test
    void serializeGetCorrectExistingTotal () throws DataException {
        List<Reservation> all = repository.findAll(hostId);

        assertEquals(2045.0,all.get(4).getTotal().doubleValue());

    }

}