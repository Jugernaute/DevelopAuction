<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19.11.2018
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>googpage</title>
</head>
<body>
<form action="/goog/login" method="POST">
    <input type="submit">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<p>
    ${principal}
</p>
<sec:authorize access="isAuthenticated()">
    "now you are autorized"
</sec:authorize>



</body>
</html>
