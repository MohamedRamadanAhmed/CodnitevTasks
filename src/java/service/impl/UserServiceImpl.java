/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import Daos.UserDao;
import beans.AouthorizedUser;
import beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

/**
 *
 * @author Mohamed Ramadan
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public boolean addUser(User user) {
       return userDao.addUser(user);
    }

    @Override
    public boolean removeUser(User user) {
        return userDao.removeUser(user);
    }

    @Override
    public boolean addAouthorizedUser(AouthorizedUser user) {
       return userDao.addAouthorizedUser(user);
    }

    @Override
    public boolean removeAouthorizedUser(User user) {
       return userDao.removeAouthorizedUser(user);
    }

    @Override
    public User findUserByPhone(String phoneNumber) {
        return userDao.findUserByPhone(phoneNumber);
    }

    @Override
    public String isUserAouthorize(User user) {
        return userDao.isUserAouthorize(user);
                
    }
    
}
