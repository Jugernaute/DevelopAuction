<%@ page import="ua.com.entity.Lot" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Auctione | Корзина</title>
    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/cart_style.css">
    <script src="../js/cart.js" defer></script>
    <script src="../js/main.js" defer></script>
</head>
<body>
<div id="conversationDiv"></div>
<div class="auction">
    <header>
        <div class="wrapper">
            <div class="logo"><a href="index.html"><img src="../img/logo.png"></a></div>
            <nav>
                <input type="search" placeholder="ПОШУК ТОВАРІВ">
                <ul class="menu">
                    <li class="user-id"><a href="goToCabinet">${user.getUsername()}</a></li>
                    <li class="sell"><a href="/goToSell">Продати</a></li>
                    <li class="favorits"><a href="#">Обрані</a></li>
                    <%--<li class="cart"><a href="#">Корзина</a></li>--%>
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
    <section class="product-cart">
        <c:forEach items="${infoProd}" var="info">
            <c:set var = "nameProduct" scope="session" value="${info.getProduct().getNameProduct()}"/>
            <c:set var = "modelProduct" scope = "session" value = "${info.getProduct().getModelProduct()}"/>
            <%--<c:set var = "manufProd" scope = "session" value = "${info.getProduct().getManufacturer()}"/>--%>
            <c:set var = "curentPrice" scope = "session" value = "${info.getProduct().getLot().getCurrentPrice()}"/>
            <%--<c:set var = "userName" scope="session" value="${info.getProduct().getUserOwner().getFirstNameUser()}"/>--%>
            <%--<c:set var = "userPhone" scope="session" value="${info.getProduct().getUserOwner().getPhone()}"/>--%>
            <%--<c:set var = "userEmail" scope="session" value="${info.getProduct().getUserOwner().getEmail()}"/>--%>

            <div class="product-container">
                <div class="product-photo">
                    <a href="lot/${img.getProduct().getId_Product()}" class="get-id"><img src="../img/product_Img/${img.getLinkOfImage()}" height="130" width="130"/>
                    </a>
                </div>
                <div class="product-descrition">
                    <div class="product-seller">
                        <p class="product-manufacturer">Назва : <c:out value="${nameProduct}"/></p>
                        <p class="product-model">Модель : <c:out value="${modelProduct}"/></p>

                    </div>
                    <%--<p class="userName">Name : <c:out value="${userName}"/></p>--%>
                    <p id="userPhone">Phone nomber</p>
                    <p id="userEmail">Email</p>
                </div>
                <div class="product-price">
                    <h4 class="cont_price">Ціна : <span>${curentPrice} грн.</span></h4>
                </div>
            </div>
        </c:forEach>
    </section>
    <div class="product-line"></div>
    <input id="nextBay" type="button" name="continue-bye" value="Продовжити покупки">
    <button id="test" class="test">test</button>


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