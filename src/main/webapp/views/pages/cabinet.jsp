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
        <li>Логін(нік).......................${user.getUsername()}  </li>
        <li>Е-мейл...........................${user.getEmail()}  </li>
        <form action="change_Email" method="post">
            <input type="email" placeholder="new Email" name="email" required>
            <button type="submit" class="save">save change</button>
        </form>
        <li>Пароль...........................</li>
        <form action="change_Password" method="post">
            <input type="password" placeholder="old password" name="password" required><br>
            <input type="password" placeholder="new password" name="password" required><br>
            <input type="password" placeholder="new password" name="password" required><br>
            <button type="submit" class="save">save change</button>
        </form>
        <li>Сторінка про мене................  </li>
            <form action="change_AboutMe" method="post">
                <input type="text" placeholder="не працює ще" name="description" required>
                <button type="submit" class="save">save change</button>
            </form>
        <li>Телефон.......................... ${user.getPhone()} </li>
            <form action="change_Phone" method="post">
                <input type="text" placeholder="new phone" name="phone" required>
                <button type="submit" class="save">save change</button>
            </form>
    </ul>
</ol>
<%--<div class="rest" style="width: 200px; height: 50px; border: solid #170c0b">--%>

</div>

</body>
</html>
