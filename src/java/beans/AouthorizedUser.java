/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Mohamed Ramadan
 */
public class AouthorizedUser {
    String taken;
    User user;

    public void setTaken(String taken) {
        this.taken = taken;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaken() {
        return taken;
    }

    public User getUser() {
        return user;
    }
    
    
    
    
}
