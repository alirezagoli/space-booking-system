package ir.ac.iut.reservation.managedbean;

import ir.ac.iut.reservation.model.Access;
import ir.ac.iut.reservation.model.Place;
import ir.ac.iut.reservation.model.UserAccount;
import ir.ac.iut.reservation.service.PlaceService;
import ir.ac.iut.reservation.service.UserAccountService;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetails;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Created by Alireza on 1/24/2017.
 */
@ManagedBean(name = "placeStatusMB")
@RequestScoped
public class PlaceStatusMB {

    @ManagedProperty("#{placeService}")
    private PlaceService placeService;
    @ManagedProperty("#{userAccountService}")
    private UserAccountService userAccountService;
    private List<Place> placeList;

    @PostConstruct
    public void init() {
        placeList = placeService.getAllPlaces();

        LdapUserDetails ldapUserDetails = (LdapUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserAccount userAccount=userAccountService.getByUsername(ldapUserDetails.getUsername());
        if(userAccount==null)
        {
            if(ldapUserDetails.getAuthorities().toArray().length==2) {
                userAccountService.save(ldapUserDetails.getDn().split(",")[0].split("=")[1].split(" ")[0],
                        ldapUserDetails.getDn().split(",")[0].split("=")[1].split(" ")[1], ldapUserDetails.getUsername(),
                        Access.ADMIN);
            }
            else
            {
                userAccountService.save(ldapUserDetails.getDn().split(",")[0].split("=")[1].split(" ")[0],
                        ldapUserDetails.getDn().split(",")[0].split("=")[1].split(" ")[1], ldapUserDetails.getUsername(),
                        Access.USER);
            }
        }

        System.out.println("Username:"+ldapUserDetails.getUsername());
        System.out.println("Firstname:"+ldapUserDetails.getDn().split(",")[0].split("=")[1].split(" ")[0]);
        System.out.println("Lastname:"+ldapUserDetails.getDn().split(",")[0].split("=")[1].split(" ")[1]);
        System.out.println("Access:"+ldapUserDetails.getAuthorities().toArray()[0]);
        if(ldapUserDetails.getAuthorities().toArray().length==2) {
            System.out.println("Access:" + ldapUserDetails.getAuthorities().toArray()[1]);
        }

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

    public UserAccountService getUserAccountService() {
        return userAccountService;
    }

    public void setUserAccountService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }
}

