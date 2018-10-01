<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Auction | lostpassword</title>
    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/lostpassword_style.css">
</head>
<body>

<div class="enter_form">
    <div class="modal-content">
        <div class="close_cont">
            <span class="close">&times;</span>
        </div>
        <form class="login_form" action="#">
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
                <a href="#" style="color:white" class="btn">Забули пароль?</a>
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
            <div class="logo"><a href="home"><img src="../img/logo.png"></a></div>
            <nav>
                <p>Пошук: <input type="search"></p>
                <ul class="menu">
                    <li class="enter"><a href="#">Вхід</a></li>
                    <li class="registation"><a href="#">Реєстрація</a></li>
                    <li class="sell"><a href="sell.jsp">Продати</a></li>
                    <li class="favorits"><a href="#">Обрані</a></li>
                    <li class="cart"><a href="#">Корзина</a></li>
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
    <section class="lost-password">
            <div class="lost-password_enter-password">
                <h2>Введіть ваш e-mail на який прийде ключ</h2>
                <input type="email" id="curent_email" name="email" required>
                <input id="lost-password_send"  type="submit" value="Відправити">
            </div>
            <div class="lost-password_check-email hidden">
                <h2>Введіть ключ</h2>
                <input type="text" class="number_lost-psw" name="randomStr" required>
                <input  id="lost-password_ok" type="submit" name="ok" value="ok">
                <input class="hidden" id="lost-password_send-again" type="button" name="send_again" value="Надіслати ще раз">
            </div>
        <div class="resultPsw"></div>
        <div class="mainPage">
            <a href="home">ПЕРЕЙТИ НА ГОЛОВНУ СТОІНКУ</a>
        </div>
        <div class="lost-password_new-password hidden">
                <h2>Виберіть новий пароль</h2>
                <input type="password" name="password" required>
                <input type="password" name="repeatPassword" required>
                <p id="psw-must">Пароль повинен містити:<br> Мінімум 1 велику букву, 1 маленьку букву ,1 цифру, від 3 до 20 символів</p>
                <input class="lost-password_submit" type="submit" name="save">
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


<script src="../js/lostpassword.js"></script>
<script src="../js/main.js"></script>
</body>
</html>