<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Auction</title>
    <script src="https://use.fontawesome.com/a3f7924682.js"></script>
    <link rel="stylesheet" href="../style/style.css">
    <script src="../js/script.js" defer></script>
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
                    <input class="input_login" type="submit" value="Увійти">
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
                <h3>Email</h3>
                <input type="email" placeholder="Ведіть пошту" name="Email" required>
                <h3>Пароль</h3>
                <input type="password" placeholder="Введіть пароль" name="psw" required>
                <h3>Повторіть пароль</h3>
                <input type="password" placeholder="Повторіть пароль" name="psw-repeat" required>
                <label>
                    <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Запам’ятати
                </label>
                <p>Створюючи акаунт ви погоджуйтесь з <a href="#">правилами ресурсу</a>.</p>
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
                    <div class="logo"><img src="../img/logo.png"></div>
                    <nav>
                        <p>Пошук: <input type="search"></p>
                        <ul class="menu">
                            <li class="enter"><a href="#">Вхід</a></li>
                            <li class="registation"><a href="#">Реєстрація</a></li>
                            <li class="sell"><a href="#">Продати</a></li>
                            <li class="favorits"><a href="#">Обрані</a></li>
                            <li class="cart"><a href="#">Корзина</a></li>
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
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
                <div class="hot_lot_wrapper">
                    <div class="cont_img"><img src="../img/1120757261_w0_h0_cid2701730_pid684521632-b9c8d61c.jpg" height="200" width="200"/></div>
                    <div class="container">
                        <h2 class="cont_titel">Iphone X</h2>
                        <div class="cont_timer">00:00:00</div>
                        <h4 class="cont_price">Стартова ціна: <span>20 000 грн</span></h4>
                    </div>
                </div>
            </section>





            <footer>
                <div class="about"></div>
                <div class="social">
                    <img src="../img/twitter.png" height="32" width="33" alt="twitter"/>
                    <img src="../img/google.png" height="32" width="31" alt="googe"/>
                    <img src="../img/facebook.png" height="31" width="31" alt="facebook"/>
                    <img src="../img/linkedin.png" height="31" width="31" alt="linkedin"/>
                </div>
                <div class="addres"></div>
            </footer>
        </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>