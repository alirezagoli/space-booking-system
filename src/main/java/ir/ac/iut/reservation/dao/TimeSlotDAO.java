package ir.ac.iut.reservation.dao;


import ir.ac.iut.reservation.model.TimeSlot;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Alireza on 1/26/2017.
 */
@Component
public interface TimeSlotDAO {
    List<TimeSlot> getAllTimeSlots();
}
