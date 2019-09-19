/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.File;
import java.util.Date;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mohamed Ramadan
 */
@JsonIgnoreProperties(value = { "avatar" })
public class User {
    @NotNull(message = "blank")
    @NotEmpty(message="empty")
    private String first_name;
    @NotEmpty(message="empty")
    @NotNull(message = "blank")
    private String last_name;
    
    private String country_code;
    @NotNull(message = "blank")
    @NotEmpty(message="empty")
    @Size(min = 10, max = 15, message 
      = "Phone must be between 10 and 15 number")
    private String phone_number;
    private String gender;
    @Past
    private String birth_date;
    @Email(message = "Email should be valid")
    private String email;
    private MultipartFile avatar;

    public User() {
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGender() {
        return gender;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getEmail() {
        return email;
    }
    public MultipartFile getAvatar()
    {
        return avatar;
    }

    
    
}
