package ir.ac.iut.reservation.dao;

import ir.ac.iut.reservation.model.TimeSlot;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Alireza on 1/26/2017.
 */
@Component
@Qualifier("TimeSlotDAO")
public class TimeSlotDAOImpl implements TimeSlotDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<TimeSlot> getAllTimeSlots() {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(TimeSlot.class);
        cr.addOrder(Order.asc("id"));
        List results = cr.list();
        return results;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
