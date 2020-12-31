package ir.ac.iut.reservation.dao;

import ir.ac.iut.reservation.model.Place;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Alireza on 1/20/2017.
 */
@Component
public interface PlaceDAO {

    void save(Place place);
    void update(Place place);
    void delete(Place place);
    List<Place> getAllPlaces();

}
