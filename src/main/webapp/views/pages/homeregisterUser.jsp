<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Auction</title>
    <script src="https://use.fontawesome.com/a3f7924682.js"></script>
    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/style.css">
    <script src="../js/main.js" defer></script>
    <%--<script src="../js/lot.js" defer></script>--%>
</head>
<body>
<a href="qwe">regina</a><br>
<a href="goToSell">fast-start</a>
<div class="enter_form">
    <div class="modal-content">
        <div class="close_cont">
            <span class="close">&times;</span>
        </div>
        <form class="login_form" action="/login" method="post">
            <div class="col_login">
                <a href="#" class="fb btn">
                    <i class="fa fa-facebook fa-fw"></i> Увійти за допомогою Facebook
                </a>
                <a href="#" class="twitter btn">
                    <i class="fa fa-twitter fa-fw"></i> Увійти за допомогою Twitter
                </a>
                <a href="#" class="google btn">
                    <i class="fa fa-google fa-fw"></i> Увійти за допомогою Google+
                </a>
            </div>
            <div class="line">
            </div>
            <div class="col_login">
                <input class="input_login" type="text" name="username" placeholder="Username" required>
                <input class="input_login" type="password" name="password" placeholder="Password" required>
                <label>
                    <input type="checkbox" name="remember" style="margin-bottom:15px"> Запам’ятати
                </label>
                <button class="input_login" type="submit" value="Увійти">Увійти</button>
            </div>
        </form>
        <div class="login_bottom">
            <div class="col_login">
                <a href="#" style="color:white" class="btn btn_alt_reg">Зареєструватись</a>
            </div>
            <div class="col_login">
                <a href="/goLostPsw" style="color:white" class="btn">Забули пароль?</a>
            </div>
        </div>
    </div>
</div>
<div class="registration_form ">
    <p class="resultRegistration"></p>
    <img src="../img/ajax-loader.gif" id="img_loading">
    <div class=" reg_container">
        <form class="reg_form" <%--action="registration"  method="post"--%>>
            <div class=" close_cont">
                <span class="close">&times;</span>
            </div>
            <h1>Реєстрація</h1>
            <p>Заповніть форму щоб створити акаунт</p>
            <hr>
            <h3>Логін</h3>
            <input class="enterUsername" type="text" placeholder="Ведіть логін" name="username" required>
            <h3>Email</h3>
            <input class="enterEmail" type="email" placeholder="Ведіть пошту" name="email" required>
            <h3>Пароль</h3>
            <input class="enterPassword" type="password" placeholder="Введіть пароль" name="password" required>
            <h3>Повторіть пароль</h3>
            <input class="enterRepeatpassword" type="password" placeholder="Повторіть пароль" name="psw_repeat" required>
            <p id="psw-must-have">Пароль повинен містити:<br> Мінімум 1 велику букву, 1 маленьку букву ,1 цифру, від 3 до 20 символів</p>
            <label>
                <input type="checkbox" name="remember" style="margin-bottom:15px"> Запам’ятати
            </label>
            <p><b>Створюючи акаунт ви погоджуйтесь з <a href="#">правилами ресурсу</a>.</b></p>
            <div class="reg_btn">
                <button type="button" class="cancelbtn">Скасувати</button>
                <button type="submit" class="signupbtn">Зареєструватися</button>
            </div>
        </form>

    </div>
</div>
<div class="auction">
    <header>
        <div class="wrapper">
            <div class="logo"><a href="/fromLogoToHome"><img src="../img/logo.png"></a></div>
            <nav>
                <p>Пошук: <input type="search"></p>
                <ul class="menu">
                    <li class="user-id"><a href="goToCabinet">${user.getUsername()}</a></li>
                    <li class="sell"><a href="goToSell">Продати</a></li>
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
                <li class="households"><a href="#">Побутова техніка</a></li>
                <li class="computers"><a href="#">комп’ютери</a></li>
                <li class="photo"><a href="#">Фотоапарати</a></li>
                <li class="phone"><a href="#">Телефони</a></li>
            </ul>
        </div>
    </section>
    <section class="hot_lot">

        <c:forEach items="${imgLinks}" var="img">
            <c:set var = "nameProd" scope = "session" value = "${img.getProduct().getNameProduct()}"/>
            <c:set var = "modelProd" scope = "session" value = "${img.getProduct().getModelProduct()}"/>
            <c:set var = "manufProd" scope = "session" value = "${img.getProduct().getManufacturer()}"/>
            <c:set var = "startLot" scope = "session" value = "${img.getProduct().getLot().getDataStartLot()}"/>
            <c:set var = "curentPrice" scope = "session" value = "${img.getProduct().getLot().getCurrentPrice()}"/>
            <%--<p>Today's date: <%= (new java.util.Date()).getTime()%></p>--%>
            <%--<%--%>
            <%----%>
            <%--//                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dddd HH:mm");--%>
            <%--//                        LocalDateTime dateTime = LocalDateTime.of();--%>
            <%--//                        String formattedDateTime = dateTime.format(formatter); // "1986-04-08 12:30"--%>
            <%--%>--%>
            <%--<c:out value="${qwe}"//>--%>
            <div class="hot_lot_wrapper">
                <div class="cont_img" >
                    <a href="lot/${img.getProduct().getId_Product()}" class="get-id"><img src="../img/product_Img/${img.getLinkOfImage()}" height="200" width="200"/>
                    </a></div>
                <div class="container">
                    <h2 class="cont_titel"><b><c:out value = "${nameProd}"/> <c:out value="${modelProd}"/> <%--<c:out value="${manufProd}"/>--%></b></h2>

                    <p class="text-end">завершення :</p>
                    <div class="cont_timer"><c:out value="${startLot}"/></div>
                    <h4 class="cont_price">Ціна : <span>${curentPrice} грн.</span></h4>
                </div>


            </div>
        </c:forEach>
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