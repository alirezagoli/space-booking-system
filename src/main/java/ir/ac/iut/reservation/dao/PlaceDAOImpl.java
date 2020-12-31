package ir.ac.iut.reservation.dao;

import ir.ac.iut.reservation.model.Place;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Alireza on 1/20/2017.
 */
@Component
@Qualifier("PlaceDAO")
public class PlaceDAOImpl implements PlaceDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.save(place);
    }

    public void update(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.update(place);
    }

    public void delete(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(place);
    }

    public List<Place> getAllPlaces() {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Place.class);
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
