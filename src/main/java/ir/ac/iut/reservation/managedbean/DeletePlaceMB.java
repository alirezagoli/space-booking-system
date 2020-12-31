package ir.ac.iut.reservation.managedbean;

import ir.ac.iut.reservation.model.Place;
import ir.ac.iut.reservation.service.PlaceService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by Alireza on 1/30/2017.
 */
@ManagedBean(name = "deletePlaceMB")
@RequestScoped
public class DeletePlaceMB {
    @ManagedProperty("#{placeService}")
    PlaceService placeService;
    private Place deletedPlace;
    private List<Place>placeList;

    @PostConstruct
    public void init() {
        placeList = placeService.getAllPlaces();
    }

    public void delete()
    {
        placeService.deletePlace(deletedPlace);
        for(int i=0;i<placeList.size();i++)
        {
            if(placeList.get(i).getId()==deletedPlace.getId())
            {
                placeList.remove(i);
                break;
            }
        }
    }

    public PlaceService getPlaceService() {
        return placeService;
    }

    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    public Place getDeletedPlace() {
        return deletedPlace;
    }

    public void setDeletedPlace(Place deletedPlace) {
        this.deletedPlace = deletedPlace;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }
}

