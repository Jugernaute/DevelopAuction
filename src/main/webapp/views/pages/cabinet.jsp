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
<script src="https://use.fontawesome.com/a3f7924682.js"></script>
<link rel="stylesheet" href="../style/stylePasha.css">
<script src="../js/script.js" defer></script>
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

<%--<script>--%>
        <%--$save.click(function () {--%>
        <%--$target.empty();--%>
        <%--let name = $('#username').val();--%>
        <%--let user = JSON.stringify(name);--%>

        <%--$.ajax({--%>
        <%--url: 'http://localhost:8080/userSave',--%>
        <%--type: 'PUT',--%>
        <%--data: user,--%>
        <%--contentType: 'application/json',--%>

        <%--error: function (err) {--%>
        <%--// console.log(err)--%>
        <%--},--%>

        <%--success:function (result) {--%>

        <%--$(result).each(function (index, object) {--%>
        <%--let $div = $('<div/>',{text:object.name, id:object._id});--%>
        <%--$target.append($div);--%>
        <%--})--%>
        <%--}--%>
        <%--});--%>

<%--</script>--%>













        <li>Пароль...........................</li>
        <form action="change_Password" method="post">
            <input type="password" placeholder="старий пароль" name="oldPassword" required><br>
            <input type="password" placeholder="новий пароль" name="password" required><br>
            <input type="password" placeholder="повторіть пароль" name="repeatPassword" required><br>

            <c:choose>
                <c:when test="${errors!=null}">
                    <c:forEach items="${errors}" var="item">
                    ${item}<br>
                    </c:forEach>
                    ${error=null}
                </c:when>
                <c:otherwise>

                </c:otherwise>
            </c:choose>

            <c:forEach items="${error}" var="item">
                ${item}<br>
            </c:forEach>

            <button type="submit" class="save">save change</button>
        </form>


        <div class = "forgot_div">
            <p ><a href="#">forgot password?</a> </p>
        </div>
        <p>message will be send to your email, than enter the key from message </p>
        <form action="sendKeys"  method="post">
            <button type="submit" class="sendKey">send key</button>
        </form>

        <div class="forgot_psw_css" >
        <form action="forgot_psw" class="enterKeyfromEmail_inp" method="post">
            <input type="text"  placeholder="enter key" name="key" required>
            <button type="submit" >enter</button>
        </form>
        </div>

        <%--${key}--%>
        <%--<form action="enterKey" method="post">--%>
            <%--<input type="text" name="key" placeholder="enter key" required>--%>
            <%--<input type="submit" value="enter">--%>
        <%--</form>--%>


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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>
