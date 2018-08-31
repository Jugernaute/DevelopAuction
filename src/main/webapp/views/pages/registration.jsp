<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Registration</h1>
<%--<form action="go_login" name="" method="get">--%>
   <p>if you are have not login, you must be <a href="go_login">Login</a></p>
<%--</form>--%>
<%--<p>перейти на сторінку  <a th:href="@{/go_login}">Login</a> </p>--%>

<form action="save" method="get">
    <input name="username" placeholder="username">
    <input name="password" placeholder="password">
    <input type="submit" value="registration">
</form>

<%--<div th:if="${error}">--%>
    <%--[[${error}]]--%>
<%--</div>--%>


</body>
</html>