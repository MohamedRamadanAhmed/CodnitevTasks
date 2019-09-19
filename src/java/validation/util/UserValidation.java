/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation.util;

import beans.User;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;
import org.springframework.web.multipart.MultipartFile;
import validation.error.ErrorDesigne;
import validation.error.ErrorUnit;
import validation.error.PropertyError;

/**
 *
 * @author Mohamed Ramadan
 */
public class UserValidation {

    ErrorDesigne errorDesigne = new ErrorDesigne();
    User user;

    public UserValidation(User user) {
        this.user = user;
    }

    public Object validUser() {
        validFirstName(user.getFirst_name());
        validLastName(user.getLast_name());
        validGender(user.getGender());
        validPhoneNumber(user.getPhone_number());
        validBirthdate(user.getBirth_date());
        validEmail(user.getEmail());
        validCountryCode(user.getCountry_code());
        validAvatar(user.getAvatar());
        if (errorDesigne.errors.size() > 0) {
            return errorDesigne;
        } else {
            return user;
        }
    }

    private void validFirstName(String firstName) {
        PropertyError propertError = new PropertyError();
        propertError.setPropertyName("first_name");
        checckBlank(propertError, firstName);
        if (propertError.errors.size() > 0) {
            errorDesigne.addErrorProperty(propertError);
        }

    }

    private void validLastName(String lastName) {
        PropertyError propertError = new PropertyError();
        propertError.setPropertyName("last_name");
        checckBlank(propertError, lastName);
        if (propertError.errors.size() > 0) {
            errorDesigne.addErrorProperty(propertError);
        }

    }

    private void validCountryCode(String countryCode) {
        PropertyError propertError = new PropertyError();
        propertError.setPropertyName("country_code");
        checckBlank(propertError, countryCode);
        if (!Util.isValidISOCountry(countryCode)) {
            propertError.addErrorUnit(new ErrorUnit("inclusion"));

        }
        if (propertError.errors.size() > 0) {
            errorDesigne.addErrorProperty(propertError);
        }

    }

    private void validPhoneNumber(String phoneNumber) {
        PropertyError propertError = new PropertyError();
        propertError.setPropertyName("phone_number");
        checckBlank(propertError, phoneNumber);
        if (!Util.isValidToRegex("^01[0-2]{1}[0-9]{8}", phoneNumber)) {
            propertError.addErrorUnit(new ErrorUnit("not_a_number"));
            propertError.addErrorUnit(new ErrorUnit("not_exist"));
            propertError.addErrorUnit(new ErrorUnit("invalid"));

        } else if (phoneNumber.length() > 15) {
            propertError.addErrorUnit(new ErrorUnit("too_long"));

        } else if (phoneNumber.length() < 10) {
            propertError.addErrorUnit(new ErrorUnit("too_short"));

        }
        if (propertError.errors.size() > 0) {
            errorDesigne.addErrorProperty(propertError);
        }

    }

    private void validGender(String gender) {
        PropertyError propertError = new PropertyError();
        propertError.setPropertyName("gender");
        checckBlank(propertError, gender);
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {

            propertError.addErrorUnit(new ErrorUnit("inclusion"));
        }
        if (propertError.errors.size() > 0) {
            errorDesigne.addErrorProperty(propertError);
        }

    }

    private void validEmail(String email) {
        PropertyError propertError = new PropertyError();
        propertError.setPropertyName("email");
        checckBlank(propertError, email);
        if (!Util.isValidToRegex("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", email)) {
            propertError.addErrorUnit(new ErrorUnit("invalid"));
            propertError.addErrorUnit(new ErrorUnit("taken"));
        }
        if (propertError.errors.size() > 0) {
            errorDesigne.addErrorProperty(propertError);
        }

    }

    private void validBirthdate(String birthdate) {
        PropertyError propertError = new PropertyError();
        propertError.setPropertyName("birth_date");
        Date date = parseDate(birthdate);
        if (date == null) {

            propertError.addErrorUnit(new ErrorUnit("invalid"));
            return;

        }
        checckBlank(propertError, birthdate);
        if (!date.before(new Date())) {

            propertError.addErrorUnit(new ErrorUnit("in_the_future"));

        }
        if (propertError.errors.size() > 0) {
            errorDesigne.addErrorProperty(propertError);
        }

    }

    public void validAvatar(MultipartFile file) {
        PropertyError propertError = new PropertyError();
        propertError.setPropertyName("avatar");
        if (file == null) {

            propertError.addErrorUnit(new ErrorUnit("Blank"));

        } else if (!file.getOriginalFilename().contains(".jpeg")) {
            if (!file.getOriginalFilename().contains(".jpg")) {
                if (!file.getOriginalFilename().contains(".png")) {
                    propertError.addErrorUnit(new ErrorUnit("invalid_content_type"));

                }

            }

        }
        if (propertError.errors.size() > 0) {
            errorDesigne.addErrorProperty(propertError);
        }

    }

    private void checckBlank(PropertyError property, String text) {
        if (text == null || text.equals("")) {
            property.addErrorUnit(new ErrorUnit("Blank"));
        }
    }

    private Date parseDate(String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        Date convertedDate = new Date();

        try {
            convertedDate = format.parse(date);
            return convertedDate;
        } catch (ParseException e) {

            return null;

        }

    }

}
