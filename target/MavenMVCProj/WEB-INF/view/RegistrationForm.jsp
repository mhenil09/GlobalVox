<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Henil
  Date: 06-01-2020
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Registration Form</title>
</head>
<br/><br/><h3 style="text-align:center">Student Registration Page</h3><br/><br/>
    <center><table cellspacing="10px" cellpadding="10px">
        <form:form action="studentData" method="post" class="container" enctype="multipart/form-data" modelAttribute="user">
            <tr><td>Enter Username      :</td> <td><form:input class="form-control" path="username" /></td></tr>
            <tr><td>Enter Email address :</td> <td> <form:input class="form-control" type="email" path="email" /></td> </tr>
            <tr><td>Enter Password      :</td> <td> <form:password class="form-control" path="password" /></td> </tr>
            <tr><td>Choose BirthDate    :</td> <td> <form:input class="form-control" type="date" path="dob" /></td> </tr>
            <tr><td>Choose Profile Pic  :</td> <td> <input class="form-control" type="file" name="profile" /></td> </tr>
            <tr><td><input type="submit" class="btn btn-outline-success" value="Register" /></td>
                <td><input type="reset" class="btn btn-outline-dark" value="Clear" /></td></tr>
                <tr><td><a href="login"> Login from here </a></td></tr>
        </form:form></table>
    </center>
</body>
</html>
