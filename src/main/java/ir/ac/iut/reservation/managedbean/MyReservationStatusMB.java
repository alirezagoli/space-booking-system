package ir.ac.iut.reservation.managedbean;

import ir.ac.iut.reservation.model.Reservation;
import ir.ac.iut.reservation.model.UserAccount;
import ir.ac.iut.reservation.service.ReservationService;
import ir.ac.iut.reservation.service.UserAccountService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetails;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Alireza on 1/30/2017.
 */
@ManagedBean(name = "myReservationStatusMB")
@RequestScoped
public class MyReservationStatusMB {

    @ManagedProperty("#{reservationService}")
    private ReservationService reservationService;
    @ManagedProperty("#{userAccountService}")
    private UserAccountService userAccountService;
    private List<Reservation> myReservationList;

    @PostConstruct
    public void init() {
        LdapUserDetails ldapUserDetails = (LdapUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserAccount userAccount=userAccountService.getByUsername(ldapUserDetails.getUsername());
        myReservationList = reservationService.getReservationByUserAccount(userAccount);
    }


    public ReservationService getReservationService() {
        return reservationService;
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public UserAccountService getUserAccountService() {
        return userAccountService;
    }

    public void setUserAccountService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    public List<Reservation> getMyReservationList() {
        return myReservationList;
    }

    public void setMyReservationList(List<Reservation> myReservationList) {
        this.myReservationList = myReservationList;
    }
}
