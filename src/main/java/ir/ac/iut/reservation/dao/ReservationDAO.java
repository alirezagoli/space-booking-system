package ir.ac.iut.reservation.dao;

import ir.ac.iut.reservation.model.Place;
import ir.ac.iut.reservation.model.Reservation;
import ir.ac.iut.reservation.model.Status;
import ir.ac.iut.reservation.model.UserAccount;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Alireza on 1/26/2017.
 */
@Component
public interface ReservationDAO {
    List<Reservation> getReservationsByDateAndPlaceAndStatus(Date date ,Place place  ,Status status);
    void addReservation(Reservation reservation);
    List<Reservation> getPendingReservations();
    void update(Reservation reservation);
    List<Reservation> getReservationByUserAccount(UserAccount userAccount);

}
