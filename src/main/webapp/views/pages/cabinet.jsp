<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>cabinet</title>
    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/stylePasha.css">
    <link rel="stylesheet" href="../style/cabinet_style.css">
    <script src="../js/cabinet.js" defer></script>
    <script src="../js/main.js" defer></script>
    <script src="../js/script.js" defer></script>
</head>
<body>
<div class="auction">
    <header>
        <div class="wrapper">
            <div class="logo"><a href="/logout"><img src="../img/logo.png"></a></div>
            <nav>
                <input type="search" placeholder="ПОШУК ТОВАРІВ">
                <ul class="menu">

                    <li class="user-id"><a href="#">${user.getUsername()}</a></li>
                    <li class="sell"><a href="/goToSell">Продати</a></li>
                    <li class="favorits"><a href="#">Обрані</a></li>
                    <li class="cart"><a href="#">Корзина</a></li>
                    <li class="exit"><a href="/logout">Вийти</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section class="products">
        <div class="wrapper_products">
            <ul class="products_list">
                <li class="households"><a href="#">Побутова техніка</a></li>
                <li class="computers"><a href="#">комп’ютери</a></li>
                <li class="photo"><a href="#">Фотоапарати</a></li>
                <li class="phone"><a href="#">Телефони</a></li>
            </ul>
        </div>
    </section>
    <section class="options">
            <ul class="options-list">
                <li id="sell">Продаж</li>
                <li id="buy">Купівля</li>
                <li id="history">Історія</li>
                <li id="settings">Налаштування</li>
                <li id="balans">Баланс</li>
                <li id="mesagges">Повідомлення</li>
            </ul>
        <div class="option-list-show">
            <div class="sell-item">Продаж</div>
            <div class="buy hidden">Купівля</div>
            <div class="history hidden">History</div>
            <div class="settings hidden">
                <ol>
                    <li>Настройки учетной записи</li>
                    <ul>
                        <li>Логін(нік).......................<%--${user.getUsername()}--%><span class="resultUserName"></span>  </li>
                        <li >Е-мейл...........................<%--<a ></a>--%><span class="userEmail"></span></li>
<%--// change email      start--%>
                            <input class="changeEmail" type="email" placeholder="new Email" name="email" required>
                            <button type="submit" class="saveChangeEmail">save change</button>
<%--// change email      end--%>


<%--// change password    start--%>
                                    <li style="text-align: center"> Змінити пароль</li>

                            <input class="oldPassword" type="password" placeholder="старий пароль" name="oldPassword" required><br>
                            <input class="password" type="password" placeholder="новий пароль" name="password" required><br>
                            <input class="repeatPassword" type="password" placeholder="повторіть пароль" name="repeatPassword" required><br>

                            <a class="resultChangePassword"></a><br>

                            <button type="submit" class="saveChangePassword">save change</button>
<%--// change password    end--%>

                        <li>Сторінка про мене................  </li>
                        <form action="change_AboutMe" method="post">
                            <input type="text" placeholder="не працює ще" name="description" required>
                            <button type="submit" class="save">save change</button>
                        </form>
                        <li>Телефон.......................... <a class="resultUserPhone"></a> </li>
<%--// change phone      start--%>
                        <%--<form>--%>
                        <input class="inputChangePhone" type="text" placeholder="new phone" name="phone" required>
                        <button class="saveChangePhone" type="submit" disabled="disable">save change</button>
                        <%--</form>--%>
<%--// change phone      end--%>
                    </ul>
                </ol>


            </div>
            </div>
            <div class="balans hidden">balans</div>
            <div class="mesagges hidden">masegges</div>
        <%--</div>--%>
    </section>











    <footer>
        <div class="about"></div>
        <div class="social">
            <div id="twitter">
                <img src="../img/twitter.png" alt="twitter"/>
            </div>
            <div id="google">
                <img src="../img/google.png" alt="googe"/>
            </div>
            <div id="facebook">
                <img src="../img/facebook.png" alt="facebook"/>
            </div>
            <div id="linkedin">
                <img src="../img/linkedin.png" alt="linkedin"/>
            </div>
        </div>
        <div class="addres"></div>
    </footer>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>


</script>
</body>
</html>