/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.AouthorizedUser;
import beans.User;

/**
 *
 * @author Mohamed Ramadan
 */
public interface UserService {
    
    public boolean addUser(User user);
    public boolean removeUser(User user);
    public boolean addAouthorizedUser(AouthorizedUser user);
    public boolean removeAouthorizedUser(User user);
    public User findUserByPhone(String phoneNumber);
    public String isUserAouthorize(User user);
    
}
