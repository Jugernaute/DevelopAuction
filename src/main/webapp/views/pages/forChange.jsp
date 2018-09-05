<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.09.2018
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="userNick" scope="session" value="${userNick}"></c:set>
<h1>Користувач - ${user}</h1>
<p>повернутись в особистий <a href="goToCabinet">кабінет</a></p>
<hr>
<p>Ваш текущий логин: ${userNick}</p>
<p>Введите новый логин. Внимание! Изменить логин в будущем будет невозможно.:</p>
<form action="/changeNick/${user}" method="post">
    <%--<input name="${user}">--%>
    <input type="text" placeholder="new nick" name="changeNick" required>
    <button type="submit">save</button>
</form>
</body>
</html>
