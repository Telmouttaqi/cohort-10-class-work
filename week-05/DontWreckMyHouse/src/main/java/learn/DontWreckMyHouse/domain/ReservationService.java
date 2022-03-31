package learn.DontWreckMyHouse.domain;

import learn.DontWreckMyHouse.data.GuestRepository;
import learn.DontWreckMyHouse.data.HostRepository;
import learn.DontWreckMyHouse.data.ReservationRepository;

public class ReservationService {

    private final GuestRepository guestRepository;
    private final HostRepository hostRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(GuestRepository guestRepository, HostRepository hostRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.hostRepository = hostRepository;
        this.reservationRepository = reservationRepository;
    }



}
