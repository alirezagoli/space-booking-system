package ir.ac.iut.reservation.service;

import ir.ac.iut.reservation.dao.PlaceDAO;
import ir.ac.iut.reservation.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alireza on 1/23/2017.
 */
@Service("placeService")
@Transactional
public class PlaceService {

    @Autowired
    PlaceDAO placeDAO;

    public void addPlace( String name, int capacity, int nPC, boolean hasVideoProjector, boolean hasAirConditioner,
                  boolean hasBlackBoard, boolean hasWhiteBoard, boolean hasWiFiCoverage, boolean hasLanCable, boolean hasMicrophone) {
        Place place= new Place();
        place.setName(name);
        place.setCapacity(capacity);
        place.setnPC(nPC);
        place.setHasVideoProjector(hasVideoProjector);
        place.setHasAirConditioner(hasAirConditioner);
        place.setHasBlackBoard(hasBlackBoard);
        place.setHasWhiteBoard(hasWhiteBoard);
        place.setHasWiFiCoverage(hasWiFiCoverage);
        place.setHasLanCable(hasLanCable);
        place.setHasMicrophone(hasMicrophone);

        placeDAO.save(place);
    }

    public List<Place> getAllPlaces()
    {
        return placeDAO.getAllPlaces();
    }


    public PlaceDAO getPlaceDAO() {
        return placeDAO;
    }

    public void setPlaceDAO(PlaceDAO placeDAO) {
        this.placeDAO = placeDAO;
    }

    public void deletePlace(Place place)
    {
        placeDAO.delete(place);
    }

    public void updatePlace(Place place)
    {
        placeDAO.update(place);
    }
}
