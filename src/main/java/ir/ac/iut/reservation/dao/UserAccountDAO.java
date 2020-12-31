package ir.ac.iut.reservation.dao;

import ir.ac.iut.reservation.model.Place;
import ir.ac.iut.reservation.model.UserAccount;
import org.springframework.stereotype.Component;

/**
 * Created by Alireza on 1/22/2017.
 */
@Component
public interface UserAccountDAO  {
    public UserAccount getByUsername(String username);
    public void save(UserAccount userAccount);
}
