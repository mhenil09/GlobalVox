<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Henil
  Date: 16-01-2020
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Form</title>
    <style>
        .error{
            color : red;
        }
    </style>
</head>
<body>
    <center>
        <h1>Customer Details Form</h1>
        <form:form method="get" modelAttribute="cust" action="cust_confirm">
            Email Id<span style="color: red">*</span> : <form:input type="email" path="email" /> <form:errors path="email" cssClass="error" />
            <br/>First Name<span style="color: red">*</span> : <form:input path="fname" /> <form:errors path="fname" cssClass="error" />
            <br/>Last Name<span style="color: red">*</span> : <form:input path="lname" /> <form:errors path="lname" cssClass="error" />
            <input type="submit" value="Submit" />
        </form:form>
    </center>
</body>
</html>
