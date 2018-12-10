<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Auction | Кабінет</title>
    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/cabinet_style.css">
    <script src="../js/cabinet.js" defer></script>
    <script src="../js/main.js" defer></script>
</head>
<body>
<div class="auction">
    <header>
        <div class="wrapper">
            <div class="logo"><a href="/fromLogoToHome"><img src="../img/logo.png"></a></div>
            <nav>
                <input type="search" placeholder="ПОШУК ТОВАРІВ">
                <ul class="menu">

                    <li class="user-id"><a href="#">${user.getUsername()}</a></li>
                    <li class="sell"><a href="/goToSell" id="sell1">Продати</a></li>
                    <li class="favorits"><a href="#">Обрані</a></li>
                    <li class="cart"><a href="/goToCart">Корзина</a></li>
                    <li class="exit"><a href="/logout">Вийти</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section class="products">
        <div class="wrapper_products">
            <ul class="products_list">

            </ul>
        </div>
    </section>
    <section class="options">
        <ul class="options-list">
            <li id="settings">Налаштування</li>
            <li id="buy">Купівля</li>
            <li id="history">Історія</li>
            <li id="balans">Баланс</li>
            <li id="mesagges">Повідомлення</li>
        </ul>
    </section>
    <div class="settings hidden slider">
        <h3>Налаштування облікового запису</h3>
        <ul>
            <li>Логін(нік).............................<span class="resultUserName green">${user.getUsername()}</span></li>
            <li >Е-мейл................................<span class="userEmail green">${user.getEmail()}</span></li>
            <li>Телефон.............................<span class="resultUserPhone green">${user.getPhone()}</span></li>
            <li>Імя.......................................<span class="resultFirstName green">${user.getFirstNameUser()}</span></li>
            <li>Прізвище.............................<span class="resultSurName green">${user.getSurNameUser()}</span></li>
            <li>Поштовий адрес.................<span class="resultCountry green">${country}</span>
                <span class="resultState green">${state}</span>
                <span class="resultCity green">${city}</span>
                <span class="resultPostAddress green">${address}</span>
                </li>
        </ul>
        <br>

        <p>Введіть новий email:</p>
        <label class="verification-email-1">
            <input class="changeEmail" type="email" placeholder="введіть нову електронну пошту" name="email" required>
            <button type="submit" class="send-key" disabled="disable">send key</button>
            <span class="resultChangeEmail error"></span>
        </label>
        <label class="verification-email-2 hidden">
            <em style="color: crimson">enter KEY from new e-mail -></em>
            <input style="width: 170px" class="enter-key" type="text" placeholder="key" name="randomKey" required>
            <button type="submit" class="saveChangeEmail" disabled="disable">save change</button>
        </label>
        <p>Змінити пароль:</p>
        <label>
            <input class="oldPassword" type="password" placeholder="старий пароль" name="oldPassword" required>
        </label>
        <label>
            <input class="password" type="password" placeholder="новий пароль" name="password" required>
        </label>
        <label>
            <input class="repeatPassword" type="password" placeholder="повторіть новий пароль" name="repeatPassword" required>
        </label>
        <button type="submit" class="saveChangePassword" disabled="disable">save change</button><br>
        <span class="resultChangePassword error"></span>

        <p>Сторінка про мене (не більше 50 символів!):</p>
        <label>
            <textarea class="text-area" name="about-me" placeholder="Інформація про мене"></textarea>
        </label>
        <button type="submit" class="saveAboutMe" disabled="disable">save change</button>
        <span class="resultChangeAboutMe error"></span>
        <p>Телефон:</p>
        <label>
            <input class="inputChangePhone" type="text" placeholder="введіть ваш номер телефону" name="phone">
        </label>
        <button class="saveChangePhone" type="submit" disabled="disable">save change</button>
        <span class="resultChangePhone error"></span>
        <p>Ім’я:</p>
        <label>
            <input class="inputFirstName" type="text" placeholder="ввести імя" name="firstNameUser">
            <button class="saveFirstName" type="submit" disabled="disable">save change</button>
            <span class="resultChangeName error"></span>
        </label>
        <p>Прізвище:</p>
        <label>
            <input class="inputSurNameUser" type="text" placeholder="ввести фамілію" name="surNameUser">
            <button class="saveSurName" type="submit" disabled="disable">save change</button>
            <span class="resultChangeSurName error"></span>
        </label><br>
        <p>Місцезнаходження:</p>
        <label>
            <select name="country" class="countries country-select" id="countryId">
                <option value="">Виберіть країну</option>
            </select><br>
            <select name="state" class="states country-select" id="stateId">
                <option value="">Виберіть область</option>
            </select><br>
            <select name="city" class="cities country-select" id="cityId">
                <option value="">Виберіть місто</option>
            </select>
            <input class="inputPostAddress" type="text" placeholder="вулиця, будинок, квартира" name="userPostAddress">
            <button class="savePostAddress" type="submit" disabled="disable">save change</button>
            <span class="resultChangePostAddress error"></span>
        </label>
    </div>


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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//geodata.solutions/includes/countrystatecity.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>