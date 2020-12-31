package ir.ac.iut.reservation.model;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alireza on 1/20/2017.
 */
@Entity
public class UserAccount {
    @Id
    private String username;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Access access;
    @OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="user")
    private Set<Reservation> reservationSet;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }
}
