<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.10.2018
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>pagebf</title>
</head>
<body>
<form action="/fb/login" method="POST">
    <input type="submit">
    <input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<p>
    ${principal}
</p>
<sec:authorize access="isAuthenticated()">
    pussy
</sec:authorize>

</body>
</html>
