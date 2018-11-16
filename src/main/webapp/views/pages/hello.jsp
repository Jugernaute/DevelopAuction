<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.10.2018
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>

<c:forEach var="image" items="${images}">
    <img src="${image}" height="200px" width="200px"> <br>
</c:forEach>

</body>
</html>
