<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Auctione | Корзина</title>
    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/cart_style.css">
    <script src="../js/cart.js" defer></script>
    <script src="../js/main.js" defer></script>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<body>
<div class="auction">
    <header>
        <div class="wrapper">
            <div class="logo"><a href="index.html"><img src="../img/logo.png"></a></div>
            <nav>
                <input type="search" placeholder="ПОШУК ТОВАРІВ">
                <ul class="menu">

                    <li class="user-id"><a href="#">userID</a></li>
                    <li class="sell"><a href="sell.html">Продати</a></li>
                    <li class="favorits"><a href="#">Обрані</a></li>
                    <li class="cart"><a href="#">Корзина</a></li>
                    <li class="exit"><a href="#">Вийти</a></li>
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
    <section class="product-cart">
        <div class="product-container">
            <div class="product-photo">
            </div>
            <div class="product-descrition">
                <div class="product-seller">
                    <p>Виробник</p>

                    <p>Назва продукта</p>
                </div>
                <p>Name</p>
                <p>Phone nomber</p>
            </div>
            <div class="product-price">
                <p>4654</p>
            </div>
        </div>
    </section>
    <div class="product-line"></div>
    <input type="button" name="continue-bye" value="Продовжити покупки">
    <button class="test">test</button>


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