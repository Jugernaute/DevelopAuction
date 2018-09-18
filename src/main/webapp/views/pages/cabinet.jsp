<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>cabinet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" integrity="2hfp1SzUoho7/TsGGGDaFdsuuDL0LX2hnUp6VkX3CUQ2K4K+xjboZdsXyp4oUHZj" crossorigin="anonymous">
    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/stylePasha.css">
    <link rel="stylesheet" href="../style/cabinet_style.css">
    <script src="../js/cabinet.js" defer></script>
    <script src="../js/main.js" defer></script>
    <script src="../js/script.js" defer></script>
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

                    <li class="user-id"><a href="#">${user.getUsername()}</a></li>
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
                <li class="households"><a href="#">Побутова техніка</a></li>
                <li class="computers"><a href="#">комп’ютери</a></li>
                <li class="photo"><a href="#">Фотоапарати</a></li>
                <li class="phone"><a href="#">Телефони</a></li>
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
            <div class="sell-item">

                <label class="sell-category">


                </label>


                <div class="container">
                    <div class="row">
                        <div class="col-xs-2">
                            <p style="float: left">Категорія*</p>
                        </div>
                        <div class="col-xs-10">
                            <button class="btn_Category">Вибрати</button>
                            <div class="categoryStaticList">
                                <ul class="categoryHandleList">
                                    <li>
                                        <select size="10" class="form" name="selectFirst" id="sellFromSelectFirst">
                                            <option value="00001">Telephone, smartphone</option>
                                            <option value="00002">Pobutova tehnika</option>
                                            <option value="00003">Sport</option>
                                            <option value="00004">Auto</option>
                                        </select>
                                    </li>
                                    <li>
                                        <select size="10" class="form" name="selectSecond" id="sellFromSelectSecond">
                                            <option value="00100">Telephone</option>
                                            <option value="00101">Smartphone</option>
                                        </select>
                                    </li>
                                    <li>
                                        <select size="10" class="form" name="selectThird" id="sellFromSelectThrid">
                                            <option value="01000">Asus</option>
                                            <option value="01001">Samsung</option>
                                        </select>
                                    </li>
                                </ul>
                        </div>
                        <%--<div class="col-sm-6">--%>
                            <%--One of three columns--%>
                        <%--</div>--%>
                    <%--</div>--%>
                </div>











            </div>
            <div class="buy hidden">Купівля</div>
            <div class="history hidden">History</div>
            <div class="settings hidden">
                <ol>
                    <li>Настройки учетной записи</li>
                    <ul>
                        <li>Логін(нік).......................<%--${user.getUsername()}--%><span class="resultUserName"></span>  </li>
                        <li >Е-мейл...........................<%--<a ></a>--%><span class="userEmail"></span></li>
<%--// change email      start--%>
                            <input class="changeEmail" type="email" placeholder="new Email" name="email" required>
                            <button type="submit" class="saveChangeEmail">save change</button>
<%--// change email      end--%>


<%--// change password    start--%>
                                    <li style="text-align: center"> Змінити пароль</li>

                            <input class="oldPassword" type="password" placeholder="старий пароль" name="oldPassword" required><br>
                            <input class="password" type="password" placeholder="новий пароль" name="password" required><br>
                            <input class="repeatPassword" type="password" placeholder="повторіть пароль" name="repeatPassword" required><br>

                            <span class="resultChangePassword"></span><br>

                            <button type="submit" class="saveChangePassword">save change</button>
<%--// change password    end--%>

                        <li>Сторінка про мене................  </li>

                            <input type="text" placeholder="не працює ще" name="description" required>
                            <button type="submit" class="save">save change</button>

                        <li>Телефон.......................... <span class="resultUserPhone"></span> </li>
<%-- change phone      start--%>

                        <input class="inputChangePhone" type="text" placeholder="new phone" name="phone">
                        <button class="saveChangePhone" type="submit" disabled="disable">save change</button>

<%-- change phone      end--%>

<%--set firstname user       start--%>
                        <li>Ваше імя........................<span class="resultFirstName"></span> </li>
                        <input class="inputFirstName" type="text" placeholder="ввести імя" name="firstNameUser">
                        <button class="saveFirstName" type="submit" disabled="disable">save name</button>
<%--set firstname user       end--%>

<%--set surname user       start--%>
                        <li>Ваша фамілія.....................<span class="resultSurName"></span> </li>
                        <input class="inputSurNameUser" type="text" placeholder="ввести фамілію" name="surNameUser">
                        <button class="saveSurName" type="submit" disabled="disable">save surname</button>
<%--set surname user       end--%>

<%--set adress user       start--%>
                        <li>Ваш поштовий адрес......................<span class="resultPostAddress"></span> </li>
                        <input class="inputPostAddress" type="text" placeholder="ввести поштовий адрес" name="userPostAddress">
                        <button class="savePostAddress" type="submit" disabled="disable">save adress</button>
<%--set adress user       end--%>

                    </ul>
                </ol>


            </div>
            </div>
            <div class="balans hidden">balans</div>
            <div class="mesagges hidden">masegges</div>
        <%--</div>--%>

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
<script>


</script>
</body>
</html>