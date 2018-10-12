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
    <script src="../js/sell.js" defer></script>
</head>
<body>
<div class="auction">
    <header>
        <div class="wrapper">
            <div class="logo"><a href="/logout"><img src="../img/logo.png"></a></div>
            <nav>
                <input type="search" placeholder="ПОШУК ТОВАРІВ">
                <ul class="menu">

                    <li class="user-id"><a href="#">userID</a></li>
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
            <div class="sell-item slider">
                <div class="sell-item-list">
                    <p class="required">Категорія: </p>
                    <div class="sell-item-list-wrapper">
                        <select class="sell-item-list-lvl1" size="6">

                        </select>
                        <select class="sell-item-list-lvl2" size="6">
                        </select>
                        <select class="sell-item-list-lvl3" size="6">
                        </select>
                    </div>
                </div>
                <span id="span-error"></span>
            <%--<span id="sell-item-list-wrapper-error"></span>--%>
                <div class="sell-item-container">
                    <p >Модель: </p>
                    <label>
                        <input type="text" id="model" placeholder="Введіть модель товару">
                    </label>
                </div>
                <div class="sell-item-container">
                    <p class="required">Назва продукту: </p>
                    <label>
                        <input type="text" name="modelName" id="name-product" placeholder="Введіть назву товару">
                    </label>
                </div>
                <div class="sell-item-container">
                    <p class="required">Стан товару: </p>
                        <select id="resultStateProduct">
                            <option value="0">Виберіть</option>
                            <option <%--value="1" name="Новий"--%>>Новий</option>
                            <option <%--value="2" name="Вживаний"--%>>Вживаний</option>
                        </select>
                </div>
                <span id="state-product-error"></span>
                <div class="sell-item-container">
                    <p class="required">Опис: </p>
                    <label>
                        <textarea type="text" id="modelNameDescription" placeholder="Опишіть Ваш товар" ></textarea>
                    </label>
                </div>
                <div class="sell-item-container">
                    <p class="required">Фотографія: </p>
                    <form method="POST" enctype="multipart/form-data" id="fileUploadForm">
                        <div class="form-group">
                            <%--<label class="control-label" for="uploadfile">Upload File:</label>--%>
                            <input type="file" class="form-control" id="uploadfile" placeholder="Upload File"  name="uploadfile" multiple>
                        </div>
                    </form>
                </div>
                <span id="image-error"></span>
                <div class="sell-item-container " id="listFiles">

                </div>
                <div class="option-list-show-type">
                    <div class="option-list-show-type-wrapper">
                        <p class="required">Тип продажу: </p>
                        <label>
                            <select id="change-blic">
                                <option value="0">Вибрати</option>
                                <option <%--value="1"--%>>Простий аукціон</option>
                                <option <%--value="2"--%>>Аукцион з можливістю бліц-покупки</option>
                            </select>
                        </label>
                    </div>
                    <span id="blic-error"></span>
                    <div class="option-list-show-type-wrapper">
                        <p class="required">Стартова ціна: </p>
                        <label>
                            <input type="number" id="start-price" placeholder="Введіть стартову ціну товару">
                        </label>
                    </div>
                    <div class="hidden" id="buy-now">
                        <div class="option-list-show-type-wrapper" >
                            <p class="required">Ціна купити зараз: </p>
                            <label>
                                <input type="number" id="hot-price" placeholder="Введіть ціну">
                            </label>
                        </div>
                    </div>
                    <div class="option-list-show-type-wrapper">
                        <p class="required">Початок торгів : </p>
                        <label>
                            <input type="datetime-local" id="dateStart">
                        </label>
                    </div>
                    <div class="option-list-show-type-wrapper">
                        <p class="required">Тривалість торгів: </p>
                        <label>
                            <select id="durationOfLot">
                                <option value="0">Виберіть</option>
                                <option value="1">1</option>
                                <option value="3">3</option>
                                <option value="5">5</option>
                                <option value="7">7</option>
                                <option value="9">9</option>
                                <option value="11">11</option>
                                <option value="14">14</option>
                            </select>
                        </label>
                    </div>
                    <span id="duration-lot-error"></span>
                </div>
                <div class="option-list-show-send">
                    <p class="required">Спосіб доставки : </p>
                    <div class="option-list-show-send-wrapper">
                        <label>
                            <input type="checkbox" name="nova-poshta"><p>Нова Пошта</p>
                        </label>
                        <label>
                            <input type="checkbox" name="meeting"><p>При зустрічі</p>
                        </label>
                        <label>
                            <input type="checkbox" name="self"><p>Самовивіз</p>
                        </label>
                        <label>
                            <input type="checkbox" name="deal"><p>По домовленості</p>
                        </label>
                        <span id="checkbox-error"></span>
                    </div>
                </div>
                <input class="add-product-sell" type="submit" name="addProduct" value="Створити">
                <span id="error-form-enter"></span>
                <input class="add-product-sell2" type="submit" name="addProduct" value="Створити2">
            </div>
            <div class="buy hidden slider">Купівля</div>
            <div class="history hidden slider">History</div>
            <div class="settings hidden slider">
                <h3>Налаштування облікового запису</h3>
                <p>Введіть новий email:</p>
                <label>
                    <input type="email">
                </label>
                <p>Змінити пароль:</p>
                <label>
                    <input type="password" placeholder="Старий пароль" name="old-password">
                </label>
                <label>
                    <input type="password" placeholder="Новий пароль" name="new-password">
                </label>
                <label>
                    <input type="password" placeholder="Повторіть новий пароль" name="repit-password">
                </label>
                <p>Сторінка про мене:</p>
                <label>
                    <input type="text" name="about-me">
                </label>
                <p>Телефон:</p>
                <label>
                    <input type="text" name="phone-num">
                </label>
                <p>Ім’я:</p>
                <label>
                    <input type="text" name="first-name">
                </label>
                <p>Прізвище:</p>
                <label>
                    <input type="text" name="last-name">
                </label>
                <p>Пошта:</p>
                <label>
                    <input type="text" name="post">
                </label>
                <label>
                    <input class="add-product" type="submit" value="Зберегти">
                </label>
            </div>
            <div class="balans hidden slider"></div>
            <div class="mesagges hidden slider"></div>
        </div>
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
</body>
</html>