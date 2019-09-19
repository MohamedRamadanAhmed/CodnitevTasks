/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation.error;

import java.util.ArrayList;

/**
 *
 * @author Mohamed Ramadan
 */
public class ErrorDesigne {
    public ArrayList<PropertyError> errors = new ArrayList<>();

    public void addErrorProperty(PropertyError errorProperty) {
        this.errors.add(errorProperty);
    }

    public void removeErrorProperty(PropertyError errorProperty) {
        this.errors.remove(errorProperty);
    }
    
    
    
    
}
