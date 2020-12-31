package ir.ac.iut.reservation.service;

import ir.ac.iut.reservation.dao.TimeSlotDAO;
import ir.ac.iut.reservation.model.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alireza on 1/26/2017.
 */
@Service("timeSlotService")
@Transactional
public class TimeSlotService {

    @Autowired
    TimeSlotDAO timeSlotDAO;

    public List<TimeSlot> getAllTimeSlots()
    {
        return timeSlotDAO.getAllTimeSlots();
    }

    public TimeSlotDAO getTimeSlotDAO() {
        return timeSlotDAO;
    }

    public void setTimeSlotDAO(TimeSlotDAO timeSlotDAO) {
        this.timeSlotDAO = timeSlotDAO;
    }
}
