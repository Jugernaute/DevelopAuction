<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Auction | lot</title>
    <script src="https://use.fontawesome.com/a3f7924682.js"></script>
    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/lot_Style.css">
    <script src="../js/main.js" defer></script>
    <script src="../js/lot.js" defer></script>
    <%--<script src="../js/bet.js" defer></script>--%>
</head>
<body>

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
                <a href="goLostPsw" style="color:white" class="btn">Забули пароль?</a>
            </div>
        </div>
    </div>
</div>
<div class="registration_form">
    <div class="reg_container">
        <form class="reg_form" action="#">
            <div class="close_cont">
                <span class="close">&times;</span>
            </div>
            <h1>Реєстрація</h1>
            <p>Заповніть форму щоб створити акаунт</p>
            <hr>
            <h3>Логін</h3>
            <input type="text" placeholder="Ведіть логін" name="Login" required>
            <h3>Email</h3>
            <input type="email" placeholder="Ведіть пошту" name="Email" required>
            <h3>Пароль</h3>
            <input type="password" placeholder="Введіть пароль" name="psw" required>
            <h3>Повторіть пароль</h3>
            <input type="password" placeholder="Повторіть пароль" name="psw-repeat" required>
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
            <div class="logo"><a href="fromLogoToHome"><img src="../img/logo.png"></a></div>
            <nav>
                <label>
                    <input type="search">
                </label>
                <ul class="menu">
                    <li class="enter"><a href="#" class="for-remove-1">Вхід</a></li>
                    <li class="view-user"><a href="/goToCabinet" class="for-remove-2">${userFromSession}</a></li>
                    <li class="sell"><a href="/goToSell">Продати</a></li>
                    <li class="favorites"><a href="#">Обрані</a></li>
                    <li class="cart"><a href="#">Корзина</a></li>
                    <li class="exit"><a href="/logout">Вийти</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section class="products">
        <div class="wrapper_products">
            <ul class="products_list">
                <li class="list-line"></li>
                <li class="list-line"></li>
                <li class="list-line"></li>
            </ul>
        </div>
    </section>

    <section class="lot">
        <div class="lot-nav">
            <div class="lot-nav_category">
                <p><a href="#">${product.getNameProduct()}</a></p>
                <ul class="lot-nav-tree">
                    <li><a href="#">${nameCom}</a> > </li>
                    <li><a href="#">${nameSub}</a> > </li>
                </ul>
            </div>
            <div class="lot-nav-add">
                <img id="heart-empty" src="../img/empty-heart.png" height="16" width="16"/>
                <img id="heart-full" class="hidden" src="../img/if_heart-full.png" height="16" width="16"/>
            </div>
        </div>
        <hr>
        <div class="lot-wrapper">
            <div class="lot-slider">

                <div class="lot-slider-container img-lot">
                    <%--<img src="../img/product_Img/${image1.getLinkOfImage()}" alt="">--%>

                </div>
                <div class="lot-slider-row">
                    <div class="lot-slider-column">
                        <img src="../img/product_Img/${image1.getLinkOfImage()}" alt="${image1.getLinkOfImage()}">
                    </div>
                    <div class="lot-slider-column">
                        <img src="../img/product_Img/${image2.getLinkOfImage()}" alt="${image2.getLinkOfImage()}">
                    </div>
                    <div class="lot-slider-column">
                        <img src="../img/product_Img/${image3.getLinkOfImage()}" alt="${image3.getLinkOfImage()}">
                    </div>
                    <div class="lot-slider-column">
                        <img src="../img/product_Img/${image4.getLinkOfImage()}" alt="${image4.getLinkOfImage()}">
                    </div>
                </div>
            </div>
            <%--<jsp:useBean id="Product" class="ua.com.entity.Product" scope="page" />--%>
            <%--<jsp:setProperty name="Product" property="*" />--%>
            <div class="lot-info">
                <div class="lot-info-name">
                    <h3 id="lot-name">${product.getNameProduct()}</h3>

                    <h3 id="lot-description">${product.getModelProduct()}</h3>
                </div>
                <%--<c:set var="timeShow" scope="application" value="Oct 30, 2018 15:37:25"/>--%>
                <div class="lot-info-price">
                    <div class="lot-info-current-price">
                        <p>Поточна<br> ставка:</p>
                        <p id="price"><c:out value="${product.getLot().getCurrentPrice()}"/></p>
                        <span>грн</span>
                    </div>
                    <c:set value="${product.getLot().getCurrentPrice()}" var="price"/>
                    <div class="lot-info-price_bet">

                        <label>
                            <input type="number" size="4" name="sum_of_the_bet" id="bet-input" class="inp-style" placeholder="<c:out value="${nextPrice}"/>">
                        </label>
                        <p>Ваша<br>ставка</p>
                    </div>
                </div>

                <span id="error-bet"></span>
                <div class="lot-info-price_button">
                    <label>
                        <input id="btn-bet" class="inp-style" type="button" value="Зробити ставку">
                    </label>
                    <label>
                        <button id="btn-buy" disabled class="inp-style" type="button" value="">Купити<br class="br-class"><hr id="hr-btn"/><p id="p-btn">${hotPrice}</p></button>
                        <%--<div id="btn-buy" class="inp-style">Купити<br>678</div>--%>
                    </label>
                    <label>
                        <input id="send-massege" class="inp-style" type="button" value="Send Message">
                    </label>
                </div>
                <div class="lot-info-price-timer">
                    <p>Дата закінчення: <span id="test">${data}</span>  <br><span id="timer"></span></p>
                    <p>Тип доставки: <span></span></p>
                    <span>ставок:</span><button class="bet-btn1" disabled>${countOfBet}</button>
                    <span id="lider" class="inline">Зараз лідирує:<button class="bet-btn2" disabled>${userLider}</button></span>
                    <%--<a class="inline after-img" href=""><span class="inline inner-img"></span></a>--%>
                    <p>Місцезнаходення лоту: <span>${location.getRegionLot()} обл, ${location.getLocationLot()}</span></p>
                    <p>Продавець: <button class="bet-btn3" disabled>${userCreateLot}</button></p>
                </div>
            </div>
        </div>
        <hr>
        <div class="lot-about">
            <ul class="lot-about_options-list">
                <li id="descr">Опис</li>
                <li id="buy">Оплата і доставка</li>
                <li id="bet">Ставки</li>
            </ul>
            <div class="lot-about_option-list-show">
                <div class="lot-about_descr slider"></div>
                <div class="lot-about_buy hidden slider">Оплата і доставка</div>
                <div class="lot-about-bet hidden slider"></div>
            </div>
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