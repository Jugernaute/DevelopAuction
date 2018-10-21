<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta charset="UTF-8">
    <title>sell</title>
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
                <p>Пошук: <input type="search"></p>
                <ul class="menu">

                    <li class="user-id"><a href="goToCabinet">${user.getUsername()}</a></li>
                    <li class="sell"><a href="#">Продати</a></li>
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
    <div class="option-list-show">
        <div class="sell-item slider">
            <div class="sell-item-list">
                <p class="required">Категорія: </p>
                <button class="btn-flex">Вибрати</button>
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
                    <option>Новий</option>
                    <option>Вживаний</option>
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
                            <option <%--value="2"--%>>Аукціон з можливістю бліц-покупки</option>
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
                        <input type="checkbox" name="Нова Пошта"><p>Нова Пошта</p>
                    </label>
                    <label>
                        <input type="checkbox" name="При зустрічі"><p>При зустрічі</p>
                    </label>
                    <label>
                        <input type="checkbox" name="Самовивіз"><p>Самовивіз</p>
                    </label>
                    <label>
                        <input type="checkbox" name="По домовленості"><p>По договору</p>
                    </label>
                    <span id="checkbox-error"></span>
                </div>
            </div>
            <input class="add-product-sell" type="submit" name="addProduct" value="Створити">
            <span id="error-form-enter"></span>
            <input class="add-product-sell2" type="submit" name="addProduct" value="Створити2">
        </div>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>