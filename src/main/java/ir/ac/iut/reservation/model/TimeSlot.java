package ir.ac.iut.reservation.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alireza on 1/20/2017.
 */
@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String interval;
    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="timeSlotSet")
    private Set<Reservation> reservationSet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }


}
