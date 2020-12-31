package ir.ac.iut.reservation.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alireza on 1/20/2017.
 */
@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
    @OneToMany(cascade= CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="place")
    private Set<Reservation> reservationSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Reservation> getReservationSet() {
        return reservationSet;
    }

    public void setReservationSet(Set<Reservation> reservationSet) {
        this.reservationSet = reservationSet;
    }
}
