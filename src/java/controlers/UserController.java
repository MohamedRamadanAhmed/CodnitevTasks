/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import Daos.UserDao;
import beans.AouthorizedUser;
import beans.User;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.UserService;
import service.impl.UserServiceImpl;
import validation.error.*;
import validation.util.UserValidation;
import validation.util.Util;

/**
 *
 * @author Mohamed Ramadan
 */
@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    UserService userService;

// Task (1)
    @RequestMapping(value = "/Add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE/*, consumes = {"multipart/form-data"}*/)
    public Object setUser(@RequestParam(value = "first_name") @NotEmpty @Size(min = 1, max = 3, message
            = "Phone must be between 10 and 15 number") String first_name, @RequestParam("last_name") String last_name,
            @RequestParam("country_code") String country_code, @RequestParam("phone_number") String phone_number,
            @RequestParam("gender") String gender, @RequestParam("birth_date") String birth_date,
            @RequestParam(value = "email", required = false) String email,
            HttpServletResponse response, @RequestParam("avatar") MultipartFile avatar) {

        @Valid
        User user = new User();
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setBirth_date(birth_date);
        user.setGender(gender);
        user.setPhone_number(phone_number);
        user.setCountry_code(country_code);
        user.setAvatar(avatar);
        user.setEmail(email);
        UserValidation userValidation = new UserValidation(user);
        Object object = userValidation.validUser();
        if (object instanceof User) {
            userService.addUser(user);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }

        return object;

    }
// Task (2)

    @RequestMapping(value = "/SignIn",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object loginUser(@RequestParam("phone_number") String phoneNumber,
            @RequestParam("password") String password) {
        User user = userService.findUserByPhone(phoneNumber);
        if (user != null) {
            AouthorizedUser auothorizeUser = new AouthorizedUser();
            String taken = Util.generateNewToken();
            auothorizeUser.setTaken(taken);
            auothorizeUser.setUser(user);
            userService.addAouthorizedUser(auothorizeUser);

            return taken;

        } else {
            ErrorUnit error = new ErrorUnit();
            error.setError("user_not_found");
            return error;
        }

    }

    // Task (3)
    @RequestMapping(value = "/Access",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object accessResources(@RequestParam("phone_number") String phoneNumber,
            @RequestParam("auth_taken") String taken, HttpServletResponse response) {
        User user = userService.findUserByPhone(phoneNumber);
        if (user != null) {
            String userToken = userService.isUserAouthorize(user);
            if (taken.equals(userToken)) {
                return user;
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                ErrorUnit error = new ErrorUnit();
                error.setError("You Are Not Authorize");
                return error;
            }

        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            ErrorUnit error = new ErrorUnit();
            error.setError("You Are Not Authorized.");
            return error;
        }

    }

}
