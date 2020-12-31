package ir.ac.iut.reservation.managedbean;

import ir.ac.iut.reservation.model.Place;
import ir.ac.iut.reservation.service.PlaceService;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Alireza on 1/30/2017.
 */

@ManagedBean(name = "editPlaceMB")
@RequestScoped
public class EditPlaceMB {
    @ManagedProperty("#{placeService}")
    private PlaceService placeService;
    private List<Place> placeList;
    private Boolean [] booleanValues;

    @PostConstruct
    public void init() {
        placeList = placeService.getAllPlaces();
        booleanValues = new Boolean[2];
        booleanValues[0]=true;
        booleanValues[1]=false;

    }

    public void onRowEdit(RowEditEvent event)
    {
        FacesMessage msg = new FacesMessage("Place Edited", ((Place) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
      Place place =  (Place)event.getObject();
        placeService.updatePlace(place);
    }

    public void onRowCancel(RowEditEvent event)
    {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Place) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public Boolean[] getBooleanValues() {
        return booleanValues;
    }

    public void setBooleanValues(Boolean[] booleanValues) {
        this.booleanValues = booleanValues;
    }
}
