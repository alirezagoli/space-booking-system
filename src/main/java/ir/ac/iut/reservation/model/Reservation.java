package ir.ac.iut.reservation.model;

import javax.persistence.*;
import java.util.Set;
import java.util.Date;

/**
 * Created by Alireza on 1/20/2017.
 */
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
    private Place place;
    @ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
    private UserAccount user;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(TemporalType.DATE)
    Date date;
    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<TimeSlot> timeSlotSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<TimeSlot> getTimeSlotSet() {
        return timeSlotSet;
    }

    public void setTimeSlotSet(Set<TimeSlot> timeSlotSet) {
        this.timeSlotSet = timeSlotSet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
