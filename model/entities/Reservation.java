package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Long duration() {
        Long differ = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(differ, TimeUnit.MILLISECONDS);

    }

    public String updateDates(Date checkin, Date checkout) {
        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            return "Reservation Dates for update must be future Dates !\n";

        }
        if (!checkout.after(checkin)) {
            return "Check-Out Date must be after Check-In Date !\n";
        }

        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    public String toString() {
        return "Room " +
                roomNumber +
                ", Check-in: " +
                sdf.format(checkin) +
                ", Check-out: " +
                sdf.format(checkout) +
                ", " +
                duration() +
                " Nights";

    }

}