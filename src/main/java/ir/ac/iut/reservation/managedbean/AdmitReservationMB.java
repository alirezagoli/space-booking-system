package ir.ac.iut.reservation.managedbean;


import ir.ac.iut.reservation.model.Reservation;
import ir.ac.iut.reservation.model.Status;
import ir.ac.iut.reservation.model.TimeSlot;
import ir.ac.iut.reservation.service.ReservationService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alireza on 1/27/2017.
 */
@ManagedBean(name = "admitReservationMB")
@ViewScoped
public class AdmitReservationMB {

    @ManagedProperty("#{reservationService}")
    private ReservationService reservationService;

    private List<Reservation> pendingReservationList;
    private Reservation acceptedReservation;
    private Reservation rejectedReservation;


    @PostConstruct
    public void init() {

        pendingReservationList = reservationService.getPendingReservations();

    }

    public void accept() {
       // System.out.println("accept:" + acceptedReservation.getPlace().getName());

        acceptedReservation.setStatus(Status.ACCEPTED);
        reservationService.update(acceptedReservation);

        List<TimeSlot> acceptedTimeSlots = new ArrayList<TimeSlot>(acceptedReservation.getTimeSlotSet());
        for (int i = 0; i < pendingReservationList.size(); i++) {

            if (pendingReservationList.get(i).getDate().equals(acceptedReservation.getDate()) &&
                    pendingReservationList.get(i).getId()!=acceptedReservation.getId() &&
                    pendingReservationList.get(i).getPlace().getId()==acceptedReservation.getPlace().getId() ) {
                List<TimeSlot> pendingTimeSlots = new ArrayList<TimeSlot>(pendingReservationList.get(i).getTimeSlotSet());
                boolean flag =false;
                for(int j=0;j<pendingTimeSlots.size();j++)
                {
                    for(int k=0;k<acceptedTimeSlots.size();k++)
                    {
                        if(pendingTimeSlots.get(j).getInterval().equals(acceptedTimeSlots.get(k).getInterval()))
                        {
                            pendingReservationList.get(i).setStatus(Status.REJECTED);
                            reservationService.update(pendingReservationList.get(i));
                            flag = true;
                            break;
                        }
                    }

                    if(flag==true)
                    {
                        break;
                    }
                }

            }
        }
    }

    public void reject() {

        //System.out.println("reject:" + rejectedReservation.getPlace().getName());
        rejectedReservation.setStatus(Status.REJECTED);
        reservationService.update(rejectedReservation);
    }


    public ReservationService getReservationService() {
        return reservationService;
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public List<Reservation> getPendingReservationList() {
        return pendingReservationList;
    }

    public void setPendingReservationList(List<Reservation> pendingReservationList) {
        this.pendingReservationList = pendingReservationList;
    }

    public Reservation getAcceptedReservation() {
        return acceptedReservation;
    }

    public void setAcceptedReservation(Reservation acceptedReservation) {
        this.acceptedReservation = acceptedReservation;
    }

    public Reservation getRejectedReservation() {
        return rejectedReservation;
    }

    public void setRejectedReservation(Reservation rejectedReservation) {
        this.rejectedReservation = rejectedReservation;
    }
}
