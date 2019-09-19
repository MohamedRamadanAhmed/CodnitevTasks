<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cognetiv Tasks</title>
        <style>
            img{
                width: 60%;
                height: 100%;
                float: right

            }
            div{
                width: 70%;
                height: 300px;
                background-color: beige
            }
            h2,h3{
                color: blue
            }
            thead{
                color: blue
            }
            .pjson{
                background-color: antiquewhite
            }
        </style>



    </head>

    <body>
        <h2>Mohamed Ramadan Ahmed </h2>
        <h1>Welcome to Cognetiv Tasks Solution </h1>
        <h3>First Task : </h3>
        <p><b>Method: POST  -  </b><b> URL:</b> <a href="http://localhost:8084/CodnitevTasks/User/Add">http://localhost:8084/CodnitevTasks/User/Add</a> </p>
        <p><b>params:  </b></p>
        <table>
            <thead>
                <td>Name</td>
                <td>Type</td>
            </thead>
            <tr>
                <td>first_name</td>
                <td>Text</td>
            </tr>
            <tr>
                <td>last_name</td>
                <td>Text</td>
            </tr>
            <tr>
                <td>country_code</td>
                <td>Text</td>
            </tr>
            <tr>
                <td>phone_number</td>
                <td>Text</td>
            </tr>
            <tr>
                <td>gender</td>
                <td>Text</td>
            </tr>
            <tr>
                <td>birth_date</td>
                <td>Text</td>
            </tr>
            <tr>
                <td>email</td>
                <td>Text</td>
            </tr>
            <tr>
                <td>avatar</td>
                <td>File</td>
            </tr>
        </table>
        <p>if params are valid service will return user object if any invalid param will return error json <b> sample : </b><p class="pjson">{
            "errors": [
            {
            "propertyName": "phone_number",
            "errors": [
            {
            "error": "not_a_number"
            },
            {
            "error": "not_exist"
            },
            {
            "error": "invalid"
            }
            ]
            },
            {
            "propertyName": "email",
            "errors": [
            {
            "error": "invalid"
            },
            {
            "error": "taken"
            }
            ]
            },
            {
            "propertyName": "country_code",
            "errors": [
            {
            "error": "Blank"
            }
            ]
            }
            ]
            }</p></p>
        
        <h3>Second Task : </h3>
        <p><b>Method: POST  -  </b><b> URL:</b> <a href="http://localhost:8084/CodnitevTasks/User/SignIn">http://localhost:8084/CodnitevTasks/User/SignIn</a> </p>
        <p><b>params:  </b></p>
        <table>
            <thead>
                <td>Name</td>
                <td>Type</td>
            </thead>
            
            <tr>
                <td>phone_number</td>
                <td>Text</td>
            </tr>
            
            <tr>
                <td>password</td>
                <td>Text</td>
            </tr>
        </table>
        <p>if user exist will return user Auth-token else will return error in json format <b> sample : </b><p class="pjson">{
            "error": "user_not_found"
            }</p></p>
        
        <h3>Third Task : </h3>
    </div>
    <p><b>Method: POST  -  </b><b> URL:</b> <a href="http://localhost:8084/CodnitevTasks/User/Access">http://localhost:8084/CodnitevTasks/User/Access</a> </p>
    <p><b>params:  </b></p>
    <table>
            <thead>
                <td>Name</td>
                <td>Type</td>
            </thead>
            
            <tr>
                <td>phone_number</td>
                <td>Text</td>
            </tr>
            
            <tr>
                <td>auth_taken</td>
                <td>Text</td>
            </tr>
        </table>
    <p class="">if user Authorized will return user  else will return error in json format <b> sample : </b>{
    <p class="pjson">  "error": "You Are Not Authorize"
        }</p></p>
    

</body>
</html>
