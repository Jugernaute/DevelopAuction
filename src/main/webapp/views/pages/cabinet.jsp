<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.09.2018
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="user" scope="session" value="${user}"></c:set>
<%--<c:set var="userNick" scope="session" value="${userNick}"></c:set>--%>
<h1>Сторінка Користувача - <em>${user.getUsername()}</em></h1>
<hr>
<br>
<p><a href="/goToSale">Виставити товар на аукціон</a></p>
<hr>
<ul class="">
    <li class="enter"><a href="#">Лоты</a></li>
    <li class="registation"><a href="#">Сделки</a></li>
    <li class="sell"><a href="#">Настройки</a></li>
    <li class="favorits"><a href="#">Баланс</a></li>
    <li class="cart"><a href="#">Сообщения</a></li>
</ul>
<hr>
<p>Настройки</p>
<ol>
    <li>Настройки учетной записи</li>
    <ul>
        <li>Логін(нік).......................  <a href="change_Login">(змінити)</a> </li>
        <li>Е-мейл...........................  <a href="change_Email">(змінити)</a></li>
        <li>Пароль...........................  <a href="change_Password">(змінити)</a></li>
        <li>Сторінка про мене................  <a href="change_Login">(змінити)</a></li>
        <li>Телефон..........................  <a href="change_Phone">(змінити)</a></li>
    </ul>
</ol>


</body>
</html>
