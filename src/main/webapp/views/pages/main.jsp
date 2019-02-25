<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
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
<%--<a href="qwe">regina</a><br>--%>
    <div class="enter_form">
        <div class="modal-content">
            <div class="close_cont">
                <span class="close">&times;</span>
            </div>
            <form class="login_form" action="/login" method="post">
                <div class="col_login">
                    <a href="/goToFb" class="fb btn">
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
                        <p>Пошук: <input id="srch" type="search"></p><br>
                        <input type="submit" id="sbm-srch" value="найти">
                        <ul class="menu">
                            <li class="enter"><a href="#">Вхід</a></li>
                            <li class="registation"><a href="#">Реєстрація</a></li>
                            <li class="sell"><a href="goToSell">Продати</a></li>
                            <li class="favorits"><a href="#">Обрані</a></li>
                            <li class="cart"><a href="#">Корзина</a></li>
                        </ul>
                    </nav>
                </div>
            </header>
            <section class="products">
                <div class="wrapper_products">
                    <ul class="products_list">
                        <c:forEach items="${commonList}" var="list">
                            <li class="households"><a href="#">${list.getNameCommonCategory()}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </section>
            <div class="nav-sort">
                <select class="filter-nav" size="" >
                    <%--<option>Виберіть</option>--%>
                        <option value="0">Виберіть</option>
                        <option value="1">Всі аукціони</option>
                        <option value="2">Аукціони, що вже тривають</option>
                        <option value="3">Завершені аукціони</option>
                        <option value="4">Ще не розпочаті аукціони</option>
                </select>
                <%--<select class="filter-nav" size="" ></select>--%>
                <%--<select class="filter-nav" size="" ></select>--%>
            </div>
            <section class="hot_lot">

                <c:forEach items="${imgLinks}" var="img">
                <c:set var = "nameProd" scope = "session" value = "${img.getProduct().getNameProduct()}"/>
                <c:set var = "modelProd" scope = "session" value = "${img.getProduct().getModelProduct()}"/>
                <c:set var = "manufProd" scope = "session" value = "${img.getProduct().getManufacturer()}"/>
                <c:set var = "endLot" scope = "session" value = "${img.getProduct().getLot().getDataEndLot()}"/>
                <c:set var = "curentPrice" scope = "session" value = "${img.getProduct().getLot().getCurrentPrice()}"/>
                <c:set var = "dataNow" scope = "session" value = "${dataNow}"/>
                    <%--<%--%>
                        <%--DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss");--%>
                        <%--LocalDateTime dateTime = LocalDateTime.of(2018,11,25,3,35);--%>
                        <%--String formattedDateTime = dateTime.format(formatter); // "1986-04-08 12:30"--%>
                        <%--System.out.println(formattedDateTime);--%>
                    <%--%>--%>
                    <c:if test="${endLot<dataNow}">
                        <div class="hot_lot_wrapper">
                            <div class="cont_img" >
                                <a href="lot/${img.getProduct().getId_Product()}" class="get-id"><img src="../img/product_Img/${img.getLinkOfImage()}" height="200" width="200"/>
                                </a>
                            </div>
                            <div class="container">
                                <h2 class="cont_titel"><b><c:out value = "${nameProd}"/> <c:out value="${modelProd}"/></b></h2>
                                <p class="text-end">завершення :</p>
                                <div class="cont_timer">
                                    <fmt:parseDate value="${endLot}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
                                    <fmt:formatDate pattern="EEE, d MMM yyyy HH:mm" value="${ parsedDateTime }"/>
                                </div>
                                <h4 class="cont_price">Ціна : <span>${curentPrice} грн.</span></h4>
                            </div>
                        </div>
                    </c:if>
                    <%--<p>Today's date: <%= (new java.util.Date()).getTime()%></p>--%>

                    <%--<c:out value="${}"//>--%>

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
            <p style="text-align: center">Today's date: <%= (new java.util.Date().toLocaleString())%></p>
        </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>

