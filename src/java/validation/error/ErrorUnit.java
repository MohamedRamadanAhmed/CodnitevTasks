/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation.error;

/**
 *
 * @author Mohamed Ramadan
 */
public class ErrorUnit {

    private String error;

    public ErrorUnit() {
    }

    public ErrorUnit(String error) {
        this.error = error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
