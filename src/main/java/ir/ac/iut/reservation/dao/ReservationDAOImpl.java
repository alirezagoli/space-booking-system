package ir.ac.iut.reservation.dao;

import ir.ac.iut.reservation.model.Place;
import ir.ac.iut.reservation.model.Reservation;
import ir.ac.iut.reservation.model.Status;
import ir.ac.iut.reservation.model.UserAccount;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Alireza on 1/26/2017.
 */
@Component
@Qualifier("ReservationDAO")
public class ReservationDAOImpl implements ReservationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Reservation> getReservationsByDateAndPlaceAndStatus(Date date, Place place ,Status status) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Reservation.class);
        cr.add(Restrictions.eq("date",date));
        cr.add(Restrictions.eq("place",place));
        cr.add(Restrictions.eq("status",status));
        List results = cr.list();
        return results;
    }

    public void addReservation(Reservation reservation) {
        sessionFactory.getCurrentSession().save(reservation);
    }

    public List<Reservation> getPendingReservations() {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Reservation.class);
        cr.add(Restrictions.eq("status", Status.PENDING));
        cr.addOrder(Order.asc("date"));
        List<Reservation> results = cr.list();
        for (Reservation res : results) {
            Hibernate.initialize(res.getPlace());
            Hibernate.initialize(res.getUser());
            Hibernate.initialize(res.getTimeSlotSet());
        }

        return results;
    }

    public void update(Reservation reservation) {
        sessionFactory.getCurrentSession().update(reservation);
    }

    public List<Reservation> getReservationByUserAccount(UserAccount userAccount) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Reservation.class);
        cr.add(Restrictions.eq("user", userAccount));
        cr.addOrder(Order.desc("date"));
        List<Reservation> results = cr.list();
        for (Reservation res : results) {
            Hibernate.initialize(res.getPlace());
            Hibernate.initialize(res.getTimeSlotSet());
        }

        return results;
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
