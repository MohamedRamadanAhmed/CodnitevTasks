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
public class PropertyError
    {
        private String propertyName;
        public ArrayList<ErrorUnit> errors = new ArrayList<>();

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        public String getPropertyName() {
            return propertyName;
        }

    public void addErrorUnit(ErrorUnit e) {
        this.errors.add(e);
    }

    public void removeErrorUnit(ErrorUnit e) {
        this.errors.remove(e);
    }
        
        
        
    }
