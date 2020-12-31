package ir.ac.iut.reservation.service;

import ir.ac.iut.reservation.dao.UserAccountDAO;
import ir.ac.iut.reservation.model.Access;
import ir.ac.iut.reservation.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Alireza on 1/22/2017.
 */
@Service("userAccountService")
@Transactional
public class UserAccountService {
    @Autowired
    UserAccountDAO userAccountDAO;


    public UserAccount getByUsername(String username){
        return userAccountDAO.getByUsername(username);
    }
    public void save(String Firstname,String LastName,String username,Access access){
        UserAccount userAccount=new UserAccount();
        userAccount.setAccess(access);
        userAccount.setFirstName(Firstname);
        userAccount.setLastName(LastName);
        userAccount.setUsername(username);
        userAccountDAO.save(userAccount);
    }

    public UserAccountDAO getUserAccountDAO() {
        return userAccountDAO;
    }

    public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }


}
