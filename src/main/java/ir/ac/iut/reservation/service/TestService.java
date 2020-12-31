package ir.ac.iut.reservation.service;

import ir.ac.iut.reservation.model.TimeSlot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Alireza on 1/27/2017.
 */
@Service("testService")
@Transactional
public class TestService {
    @Autowired
    private SessionFactory sessionFactory;

    public void myService()
    {
        Session session = sessionFactory.getCurrentSession();
        TimeSlot timeSlot;

        timeSlot = new TimeSlot();
        timeSlot.setInterval("8 - 8:30");
        session.save(timeSlot);

    timeSlot = new TimeSlot();
        timeSlot.setInterval("8:30 - 9");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("9 - 9:30");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("9:30 - 10");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("10 - 10:30");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("10:30 - 11");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("11 - 11:30");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("11:30 - 12");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("12 - 12:30");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("12:30 - 13");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("13 - 13:30");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("13:30 - 14");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("14 - 14:30");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("14:30 - 15");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("15 - 15:30");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("15:30 - 16");
        session.save(timeSlot);

        timeSlot = new TimeSlot();
        timeSlot.setInterval("16 - 16:30");
        session.save(timeSlot);

    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
