package ir.ac.iut.reservation.dao;

import ir.ac.iut.reservation.model.Place;
import ir.ac.iut.reservation.model.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Alireza on 1/22/2017.
 */

@Component
@Qualifier("UserAccountDAO")
public class UserAccountDAOImpl implements UserAccountDAO  {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserAccount getByUsername(String username) {
        return  sessionFactory.getCurrentSession().get(UserAccount.class,username);
    }

    public void save(UserAccount user) {
        sessionFactory.getCurrentSession().save(user);

    }
}
