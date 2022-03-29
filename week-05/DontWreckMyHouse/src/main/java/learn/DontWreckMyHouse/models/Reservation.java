package learn.DontWreckMyHouse.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reservation {
    //id,start_date,end_date,guest_id,total

    private int reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    // guestid
    private BigDecimal total;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
