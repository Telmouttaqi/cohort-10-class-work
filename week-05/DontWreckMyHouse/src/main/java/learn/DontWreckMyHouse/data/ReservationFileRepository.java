package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Guest;
import learn.DontWreckMyHouse.models.Host;
import learn.DontWreckMyHouse.models.Reservation;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationFileRepository {

    private static final String HEADER = "id,start_date,end_date,guest_id,total";
    private final String directory;

    public ReservationFileRepository(String directory) {
        this.directory = directory;
    }

    public List<Reservation> findAll(String hostId) throws DataException {
        ArrayList<Reservation> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath(hostId)))) {

            reader.readLine(); // read header

            for (String line = reader.readLine(); line != null; line = reader.readLine()) { // read each line

                String[] fields = line.split(",", -1);

                if (fields.length == 5) {
                   // result.add(deserialize(fields,hostId));
                }
            }
        }catch (FileNotFoundException ex){
            // do nothing for now.
        }catch (IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }

        return result;
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


   /* // id,start_date,end_date,guest_id,total
    private String deserialize(String[] fields, String hostId){
        Reservation result = new Reservation();
        result.setReservationId(Integer.parseInt(fields[0]));
        result.setStartDate(LocalDate.parse(fields[1]));
        result.setEndDate(LocalDate.parse(fields[2]));
        Guest guest = new Guest();
        return result;

    }*/

    private String getFilePath(String hostId) {
        return Paths.get(directory, hostId + ".csv").toString();
    }
}
