package ir.ac.iut.reservation.service;
import ir.ac.iut.reservation.dao.ReservationDAO;
import ir.ac.iut.reservation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alireza on 1/26/2017.
 */
@Service("reservationService")
@Transactional
public class ReservationService {

    @Autowired
    ReservationDAO reservationDAO ;

    public Set<TimeSlot> getAllOccupiedTimeSlotsByDateAndPlaceAndStatus(Date date,Place place,Status status)
    {
        List<Reservation> reservationList=reservationDAO.getReservationsByDateAndPlaceAndStatus(date,place,status);
        Set<TimeSlot>timeSlotSet = new HashSet<TimeSlot>();
        if(reservationList!=null) {
            for (int i = 0; i < reservationList.size(); i++) {
                timeSlotSet.addAll(reservationList.get(i).getTimeSlotSet());
            }
        }
        return timeSlotSet;
    }

    public void addReservation(Place place, UserAccount userAccount, Status status, Date date,List<TimeSlot> timeSlotList)
    {
        Reservation reservation = new Reservation();
        reservation.setPlace(place);
        reservation.setUser(userAccount);
        reservation.setStatus(status);
        reservation.setDate(date);
        Set<TimeSlot> timeSlotSet = new HashSet<TimeSlot>(timeSlotList);
        reservation.setTimeSlotSet(timeSlotSet);
        reservationDAO.addReservation(reservation);
    }

    public List<Reservation> getReservationByUserAccount(UserAccount userAccount)
    {
        return reservationDAO.getReservationByUserAccount(userAccount);
    }

    public List<Reservation> getPendingReservations()
    {
      return reservationDAO.getPendingReservations();
    }

    public void update(Reservation reservation)
    {
        reservationDAO.update(reservation);
    }

    public ReservationDAO getReservationDAO() {
        return reservationDAO;
    }

    public void setReservationDAO(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }
}
