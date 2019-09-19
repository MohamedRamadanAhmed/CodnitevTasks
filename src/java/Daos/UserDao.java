/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import beans.AouthorizedUser;
import beans.User;
import java.util.ArrayList;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohamed Ramadan
 */
@Repository
public class UserDao {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<AouthorizedUser> authorizedUsers = new ArrayList<AouthorizedUser>();

    public boolean addUser(User user) {
        return users.add(user);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    public boolean addAouthorizedUser(AouthorizedUser user) {        
        return authorizedUsers.add(user);

    }

    public boolean removeAouthorizedUser(User user) {
        if (isUserAouthorize(user) != null) {
            for (AouthorizedUser Auser : authorizedUsers) {
                if (Auser.getUser() == user) {
                    authorizedUsers.remove(Auser);
                    return true;
                }
            }

        }
        return false;
    }

    public User findUserByPhone(String phoneNumber) {
        for (User user : users) {
            if (user.getPhone_number().equalsIgnoreCase(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    public String isUserAouthorize(User user) {
        for (AouthorizedUser Auser : authorizedUsers) {
            if (Auser.getUser().getPhone_number().equalsIgnoreCase(user.getPhone_number())) {
                return Auser.getTaken();
            }
        }
        return null;
    }

}
