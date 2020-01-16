<%--
  Created by IntelliJ IDEA.
  User: Henil
  Date: 06-01-2020
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    Welcome ${user.username}, <br/>
        We will wish you on ${user.dob} <br/>
    Your email is ${user.email} <br/>
    <br/>Your Profile picture is as below : <br/>
    <img src="${user.profile_url}" alt="${user.profile_url}" />

</body>
</html>
