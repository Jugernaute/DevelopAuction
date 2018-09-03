<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.09.2018
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="createAuctionItem" method="post">
    <h1>Створення аукціонного товару</h1>
    <p><a href="goToCabinet">Перейти в кабінет</a> </p>
    <p>Заповніть форму щоб створити товар</p>
    <hr>
    <h3>Дата виставлення аукціону</h3>
    <input type="datetime-local" placeholder="enter data and time" name="startDate" required>
    <h3>Дата закриття аукціону</h3>
    <input type="datetime-local"  placeholder="enter data and time" name="plannedCloseDate" required>
    <h3>Стартова ціна товару</h3>
    <input type="text" placeholder="Введіть price" name="reservePrice" required>
    <h3>Опис товару</h3>
    <textarea rows="10" cols="45" placeholder="Опишіть товар" name="description" required></textarea>


        <button type="button" class="cancelbtn">Скасувати</button>
        <button type="submit" class="signupbtn">Створити аукціон</button>

</form>

</body>
</html>
