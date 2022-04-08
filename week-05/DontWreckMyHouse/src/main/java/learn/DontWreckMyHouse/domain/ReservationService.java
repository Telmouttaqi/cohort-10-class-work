package learn.DontWreckMyHouse.domain;

import learn.DontWreckMyHouse.data.DataException;
import learn.DontWreckMyHouse.data.GuestRepository;
import learn.DontWreckMyHouse.data.HostRepository;
import learn.DontWreckMyHouse.data.ReservationRepository;
import learn.DontWreckMyHouse.models.Guest;
import learn.DontWreckMyHouse.models.Host;
import learn.DontWreckMyHouse.models.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final GuestRepository guestRepository;
    private final HostRepository hostRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(GuestRepository guestRepository, HostRepository hostRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.hostRepository = hostRepository;
        this.reservationRepository = reservationRepository;

    }

    public List<Reservation> findByHost(Host host) throws DataException {
        Map<Integer, Guest> guestMap = guestRepository
                .findAll().stream()
                .collect(Collectors.toMap(g -> g.getGuestId(), g -> g));
        List<Reservation> reservations = reservationRepository.findAll(host);
        for(Reservation reservation : reservations) {
            Guest guest = guestMap.get(reservation.getGuest().getGuestId());
            reservation.setGuest(guest);
        }
        return reservations;
    }


    public Result<Reservation> add(Reservation reservation) throws DataException {

        Result<Reservation> result = validateNull(reservation);
        if (!result.isSuccess()) {
            return result;
        }
        validateFields(reservation, result);
        if (!result.isSuccess()) {
            return result;
        }
        validateChildrenExist(reservation, result);
        if (!result.isSuccess()) {
            return result;
        }
        reservationRepository.add(reservation);
        result.setPayload(reservation);
        return result;
    }

    public Result<Reservation> update(Reservation reservation) throws DataException {

        Result<Reservation>  result = new Result<>(); //validateNull(reservation);
        if(!result.isSuccess()) {
            return result;
        }
        if(result.isSuccess()) {
            reservationRepository.update(reservation);
            result.setPayload(reservation);
        }else {

            String message = String.format("Reservation ID: %s was not found", reservation.getReservationId());
            result.addErrorMessage(message);
        }

        return result;
    }

    public Result<Reservation> delete(Reservation reservation, int reservationId) throws DataException {

        Result<Reservation>  result = new Result<>();


        if(!reservationRepository.delete(reservation,reservationId)){
            result.addErrorMessage("ERROR!");
        }
        if(result.isSuccess()) {
            reservationRepository.delete(reservation,reservationId);
            result.setPayload(reservation);
        }

        return result;
    }



    public Result<Reservation> validateNull(Reservation reservation) throws DataException {

        Result<Reservation> result = new Result<>();

        if (reservation == null) {
            result.addErrorMessage("Reservation should not be null.");
            return result;
        }
        if (reservation.getStartDate() == null) {
            result.addErrorMessage("Reservation start date is required.");
            return result;
        }

        if (reservation.getEndDate() == null) {
            result.addErrorMessage("Reservation end date is required.");
            return result;
        }

        if (reservation.getGuest() == null) {
            result.addErrorMessage("Reservation guest is required");
            return result;
        }
        if (reservation.getHost() == null) {

            result.addErrorMessage("Reservation Host is required.");
        }
        validateDatesOverlap(reservation,result);

        return result;
    }


    private void validateChildrenExist(Reservation reservation, Result<Reservation> result) throws DataException {

        if (guestRepository.findGuestById(reservation.getGuest().getGuestId()) == null) {
            result.addErrorMessage("Reservation guest does not exist");
        }

        if (hostRepository.findHostById(reservation.getHost().getHostId()) == null) {
            result.addErrorMessage("Reservation host does not exist");
        }
    }


    private void validateFields(Reservation reservation, Result<Reservation> result) throws DataException {
        if (reservation.getStartDate().isBefore(LocalDate.now())
                || reservation.getEndDate().isBefore(LocalDate.now())) {
            result.addErrorMessage("Error =  you are not allowed to book a date in the past.");
        }
        if (reservation.getStartDate().isAfter(reservation.getEndDate())) {
            result.addErrorMessage("Error = you are not allowed to book a date after the end date");
        }
    }

    private void validateDatesOverlap(Reservation reservation, Result<Reservation> result) throws DataException {
        if (reservation.getHost() != null) {
            List<Reservation> reservations = findByHost(reservation.getHost());
            LocalDate startDate = reservation.getStartDate();
            LocalDate endDate = reservation.getEndDate();

            if (startDate != null && endDate != null) {
                for (Reservation r : reservations) {
                    if ((startDate.isBefore(r.getEndDate())) &&
                            (r.getStartDate().isBefore(endDate)) &&
                            reservation.getReservationId() != r.getReservationId()) {
                        result.addErrorMessage("Reservation cannot overlap existing reservation.");
                        break;
                    }
                }
            }
        }
    }

}










