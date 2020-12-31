package ir.ac.iut.reservation.managedbean;

import ir.ac.iut.reservation.service.PlaceService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Alireza on 1/23/2017.
 */
@ManagedBean(name = "addPlaceMB")
@RequestScoped
public class AddPlaceMB {

    @ManagedProperty("#{placeService}")
    private PlaceService placeService;

    private String name;
    private int capacity;
    private int nPC;
    private boolean hasVideoProjector;
    private boolean hasAirConditioner;
    private boolean hasBlackBoard;
    private boolean hasWhiteBoard;
    private boolean hasWiFiCoverage;
    private boolean hasLanCable;
    private boolean hasMicrophone;

    public void addNewPlace()
    {
        placeService.addPlace(name,capacity,nPC,hasVideoProjector,hasAirConditioner,hasBlackBoard,hasWhiteBoard,hasWiFiCoverage,
                hasLanCable,hasMicrophone);
        name =null;
        capacity=1;
        nPC=0;
        hasVideoProjector=hasAirConditioner=hasBlackBoard=hasWhiteBoard=hasWiFiCoverage=hasLanCable=hasMicrophone=false;
        FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Place added successfully"));
    }

    @PostConstruct
    public void init() {
        capacity=1;

    }

    public PlaceService getPlaceService() {
        return placeService;
    }

    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getnPC() {
        return nPC;
    }

    public void setnPC(int nPC) {
        this.nPC = nPC;
    }

    public boolean isHasVideoProjector() {
        return hasVideoProjector;
    }

    public void setHasVideoProjector(boolean hasVideoProjector) {
        this.hasVideoProjector = hasVideoProjector;
    }

    public boolean isHasAirConditioner() {
        return hasAirConditioner;
    }

    public void setHasAirConditioner(boolean hasAirConditioner) {
        this.hasAirConditioner = hasAirConditioner;
    }

    public boolean isHasBlackBoard() {
        return hasBlackBoard;
    }

    public void setHasBlackBoard(boolean hasBlackBoard) {
        this.hasBlackBoard = hasBlackBoard;
    }

    public boolean isHasWhiteBoard() {
        return hasWhiteBoard;
    }

    public void setHasWhiteBoard(boolean hasWhiteBoard) {
        this.hasWhiteBoard = hasWhiteBoard;
    }

    public boolean isHasWiFiCoverage() {
        return hasWiFiCoverage;
    }

    public void setHasWiFiCoverage(boolean hasWiFiCoverage) {
        this.hasWiFiCoverage = hasWiFiCoverage;
    }

    public boolean isHasLanCable() {
        return hasLanCable;
    }

    public void setHasLanCable(boolean hasLanCable) {
        this.hasLanCable = hasLanCable;
    }

    public boolean isHasMicrophone() {
        return hasMicrophone;
    }

    public void setHasMicrophone(boolean hasMicrophone) {
        this.hasMicrophone = hasMicrophone;
    }
}
