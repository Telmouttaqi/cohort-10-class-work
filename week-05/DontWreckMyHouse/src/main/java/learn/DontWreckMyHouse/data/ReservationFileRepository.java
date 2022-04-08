package learn.DontWreckMyHouse.data;
import learn.DontWreckMyHouse.models.Guest;
import learn.DontWreckMyHouse.models.Host;
import learn.DontWreckMyHouse.models.Reservation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ReservationFileRepository implements ReservationRepository{
    private static final String HEADER = "id,start_date,end_date,guest_id,total";

    private final String directory;


    public ReservationFileRepository(@Value("${reservations}")String directory) {this.directory = directory;}

    public List<Reservation> findAll(Host host) throws DataException {

        ArrayList<Reservation> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath(host.getHostId())))) {

            reader.readLine(); // read header

            for (String line = reader.readLine(); line != null; line = reader.readLine()) { // read each line

                String[] fields = line.split(",", -1);
                if (fields.length == 5) {
                   result.add(deserialize(fields,host));
                }
            }
        }catch (FileNotFoundException ex){
            // do nothing for now.
        }catch (IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }
        return result;
    }



    @Override
    public Reservation add(Reservation reservation) throws DataException {
        if (reservation == null || reservation.getHost().getHostId() == null) {
            return null;
        }
        List<Reservation> all = findAll(reservation.getHost());
        reservation.setReservationId(getNextId(all));
        all.add(reservation);
        writeAll(all,reservation.getHost().getHostId());

        return reservation;
    }

    @Override
    public boolean update(Reservation reservation) throws DataException {
        if (reservation == null || reservation.getHost() == null) {
            return false;
        }

        List<Reservation> all = findAll(reservation.getHost());
        for (int i = 0; i < all.size(); i++) {
            // if the current reservation id equal the new reservation
            if (all.get(i).getReservationId() == (reservation.getReservationId())) {

                all.set(i, reservation);
                writeAll(all, reservation.getHost().getHostId());
                return true;
            }
        }
        return false;
    }



    public boolean delete(Reservation reservation,int reservationId) throws DataException {
        if (reservation == null || reservation.getHost() == null) {
            return false;
        }
        List<Reservation> all = findAll(reservation.getHost());
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getReservationId() == reservationId) {
                all.remove(all.get(i));
                writeAll(all, reservation.getHost().getHostId());
                return true;
            }
        }
        return false;
    }

    private void writeAll(List<Reservation> reservations, String hostId) throws DataException {
        try (PrintWriter writer = new PrintWriter(getFilePath(hostId))) {
            writer.println(HEADER);

            for (Reservation reservation : reservations) {
                writer.println(serialize(reservation));
            }
        } catch (FileNotFoundException ex) {
            throw new DataException(ex.getMessage(), ex);
        }
    }

    private String serialize(Reservation reservation) {

        // id,start_date,end_date,guest_id,total

        return String.format("%s,%s,%s,%s,%s",
                reservation.getReservationId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getGuest().getGuestId(),
                reservation.getTotal());
    }


    // id,start_date,end_date,guest_id,total
    private Reservation deserialize(String[] fields, Host host){
        Reservation result = new Reservation();
        result.setReservationId(Integer.parseInt(fields[0]));
        result.setStartDate(LocalDate.parse(fields[1]));
        result.setEndDate(LocalDate.parse(fields[2]));
        result.setHost(host);
        Guest guest = new Guest();
        guest.setGuestId(Integer.parseInt(fields[3]));
        result.setGuest(guest);
        result.setTotal(BigDecimal.valueOf(Double.parseDouble(fields[4])));
        return result;

    }

    private String getFilePath(String hostId) {
        return Paths.get(directory, hostId + ".csv").toString();
    }

    private int getNextId(List<Reservation> all) {
        int nextId = 0;
        if (all == null || all.isEmpty()) {
            return 1;
        } else {
            for (Reservation r : all) {
                nextId = Math.max(nextId, r.getReservationId());
            }
        }
        return nextId + 1;
    }
}
