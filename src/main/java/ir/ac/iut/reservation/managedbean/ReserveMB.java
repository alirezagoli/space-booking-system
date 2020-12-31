package ir.ac.iut.reservation.managedbean;

import ir.ac.iut.reservation.model.*;
import ir.ac.iut.reservation.service.PlaceService;
import ir.ac.iut.reservation.service.ReservationService;
import ir.ac.iut.reservation.service.TimeSlotService;
import ir.ac.iut.reservation.service.UserAccountService;
import org.primefaces.event.FlowEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetails;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alireza on 1/26/2017.
 */
@ManagedBean(name = "reserveMB")
@ViewScoped
public class ReserveMB {

    @ManagedProperty("#{placeService}")
    private PlaceService placeService;
    @ManagedProperty("#{reservationService}")
    private ReservationService reservationService;
    @ManagedProperty("#{timeSlotService}")
    private TimeSlotService timeSlotService;
    @ManagedProperty("#{userAccountService}")
    private UserAccountService userAccountService;
    private List<Place> placeList;
    private List<Place> filteredPlaceList;
    private  Place selectedPlace;
    private Date currentDate;
    private Date maxDate;
    private Date selectedDate;
    private String formatedSelectedDate;
    private int nOpenDays=15;
    private List<TimeSlot> freeTimeSlotList;
    private List<TimeSlot> selectedTimeSlots;


    @PostConstruct
    public void init() {
        placeList = placeService.getAllPlaces();
        selectedPlace = placeList.get(0);

        selectedDate=currentDate= Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, nOpenDays);
        maxDate =cal.getTime();
    }

    public String onFlowProcess(FlowEvent event) {

        if (event.getOldStep().equals("placeTab")) {
            if (selectedPlace != null) {
                return event.getNewStep();
            }
            else {
                return event.getOldStep();
            }
        }
        else if (event.getOldStep().equals("dateandtime")) {
            if (event.getNewStep().equals("placeTab")) {
                return event.getNewStep();
            }
            else {
                if (selectedTimeSlots.size() > 0) {
                    selectedTimeSlots.sort(new Comparator<TimeSlot>() {
                        public int compare(TimeSlot o1, TimeSlot o2) {
                            if (o1.getId() > o2.getId()) {
                                return 1;
                            }
                            else if (o1.getId() < o2.getId()) {
                                return -1;
                            }
                            return 0;
                        }
                    });

                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    formatedSelectedDate = df.format(selectedDate);
                    return event.getNewStep();
                }
                else {
                    return event.getOldStep();
                }
            }
        }
        else
        {
            return event.getNewStep();
        }
    }

    public void getFreeTimeSlots()
    {
        List<TimeSlot> allTimeSlots = timeSlotService.getAllTimeSlots();
        List<TimeSlot> occupiedTimeSlots= new Vector<TimeSlot>(reservationService.getAllOccupiedTimeSlotsByDateAndPlaceAndStatus
                (selectedDate,selectedPlace,Status.ACCEPTED));


        for(int i=0;i<allTimeSlots.size();i++)
        {
            for(int j=0;j<occupiedTimeSlots.size();j++)
            {
                if(allTimeSlots.get(i).getId()==occupiedTimeSlots.get(j).getId())
                {
                    allTimeSlots.remove(i);
                    i--;
                    break;
                }
            }
        }
        allTimeSlots.sort(new Comparator<TimeSlot>() {
            public int compare(TimeSlot o1, TimeSlot o2) {
                if(o1.getId()>o2.getId()) {
                    return 1;
                }
                else if(o1.getId()<o2.getId())
                {
                    return -1;
                }
                return 0;
            }
        });
        freeTimeSlotList = allTimeSlots;

       /* List<TimeSlot> occupiedTimeSlots= new Vector<TimeSlot>(reservationService.getAllOccupiedTimeSlotsByDateAndPlace
                (selectedDate,selectedPlace));
        freeTimeSlotList=occupiedTimeSlots;*/
    }

    public String saveReservation()
    {
        LdapUserDetails ldapUserDetails = (LdapUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserAccount userAccount=userAccountService.getByUsername(ldapUserDetails.getUsername());
        reservationService.addReservation(selectedPlace, userAccount, Status.PENDING, selectedDate, selectedTimeSlots);

 /*       if(userAccount.getAccess()== Access.ADMIN) {
            reservationService.addReservation(selectedPlace, userAccount, Status.ACCEPTED, selectedDate, selectedTimeSlots);
        }
        else
        {
            reservationService.addReservation(selectedPlace, userAccount, Status.PENDING, selectedDate, selectedTimeSlots);
        }*/

        selectedTimeSlots=null;
        selectedPlace=null;
        selectedDate=null;
        freeTimeSlotList=null;

        FacesMessage msg = new FacesMessage("Successful", "Reservation is completed!");
        FacesContext.getCurrentInstance().addMessage(null,msg);

        return "reserve";
    }




    public PlaceService getPlaceService() {
        return placeService;
    }

    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    public List<Place> getFilteredPlaceList() {
        return filteredPlaceList;
    }

    public void setFilteredPlaceList(List<Place> filteredPlaceList) {
        this.filteredPlaceList = filteredPlaceList;
    }

    public Place getSelectedPlace() {
        return selectedPlace;
    }

    public void setSelectedPlace(Place selectedPlace) {
        this.selectedPlace = selectedPlace;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

    public int getnOpenDays() {
        return nOpenDays;
    }

    public void setnOpenDays(int nOpenDays) {
        this.nOpenDays = nOpenDays;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public TimeSlotService getTimeSlotService() {
        return timeSlotService;
    }

    public void setTimeSlotService(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    public List<TimeSlot> getFreeTimeSlotList() {
        return freeTimeSlotList;
    }

    public void setFreeTimeSlotList(List<TimeSlot> freeTimeSlotList) {
        this.freeTimeSlotList = freeTimeSlotList;
    }

    public List<TimeSlot> getSelectedTimeSlots() {
        return selectedTimeSlots;
    }

    public void setSelectedTimeSlots(List<TimeSlot> selectedTimeSlots) {
        this.selectedTimeSlots = selectedTimeSlots;
    }

    public UserAccountService getUserAccountService() {
        return userAccountService;
    }

    public void setUserAccountService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    public String getFormatedSelectedDate() {
        return formatedSelectedDate;
    }

    public void setFormatedSelectedDate(String formatedSelectedDate) {
        this.formatedSelectedDate = formatedSelectedDate;
    }
}
