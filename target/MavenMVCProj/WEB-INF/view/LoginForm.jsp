<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Henil
  Date: 06-01-2020
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Login Form</title>
</head>
<body>
<center>
    <table cellspacing="10px" cellpadding="10px">
        <br/><br/><h3 style="text-align:center">Student Login Page</h3><br/><br/>
    <form:form method="post" action="loginCheck" class="container" modelAttribute="error">
        <tr><td>Enter Username : </td><td><input type="text" class="form-control" name="user" required /></td></tr>
        <tr><td>Enter Password : </td><td><input type="password" class="form-control" name="pass" required /></td></tr>
        <tr><td colspan="2">
            <c:if test="${error != ''}">
                <h4 style="color: red"><c:out value="${error}" /></h4>
            </c:if>
        </td></tr>
        <tr><td colspan="2"><input type="submit" class="btn btn-outline-warning" value="Login" /></td></tr>
    </form:form></table>
</center>
</body>
</html>
