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


                    <%--<div class="row">--%>
                        <div class="col-xs-2">
                            <p style="float: left">Категорія*</p>
                        </div>
                        <div class="col-xs-10">
                            <button class="btn_Category">Вибрати</button>
                            <div class="categoryStaticList">
                                <ul class="categoryHandleList">
                                    <li>
                                        <select size="10" class="form" name="selectFirst" id="sellFromSelectFirst">
                                            <option class="result">Виберіть</option>

                                        </select>
                                    </li>
                                    <li>
                                        <select size="10" class="form" name="selectSecond" id="sellFromSelectSecond">

                                        </select>
                                    </li>
                                    <li>
                                        <select size="10" class="form" name="selectThird" id="sellFromSelectThrid">

                                        </select>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="both"></div>
                    <%--</div>--%>

<br>
                        <div class="row">
                            <div class="col-xs-2">
                                <p style="float: right">Модель</p>
                            </div>
                            <div class="col-xs-10">
                                <input type="text" class="modelProduct" placeholder="модель продукту">
                            </div>
                        </div>

                        <br>

                        <div class="row">
                            <div class="col-xs-2">
                                <p style="float: right">Назва*</p>
                            </div>
                                <div class="col-xs-10">
                                    <input class="descrProduct" id="inputProduct" name="nameProduct" placeholder="введіть назву продукту">
                                </div>
                        </div>
<br>
                        <div class="row">
                            <div class="col-xs-2">
                                <p style="float: right">Стан товару</p>
                            </div>
                            <div class="col-xs-10" >
                                <%--<button>Виберіть</button>--%>
                                <select   style="width: 100px !important;" class="stateProduct" id="resultStateProduct" name="stateProductName">
                                    <option value="0">Виберіть</option>
                                    <option value="1">Новий</option>
                                    <option value="2">Вживаний</option>
                                </select>

                            </div>
                        </div>

<br>

                        <div class="row">
                            <div class="col-xs-2">
                                <p style="float: right">Опис товару</p>
                            </div>
                            <div class="col-xs-10">
                                <textarea id="descriptionProduct"></textarea>
                            </div>
                        </div>

<br>

                        <div class="row" >
                            <div class="col-xs-2">
                                <p style="float: right">Фотографія*</p>
                            </div>
                            <div class="col-xs-10">

                                <form method="POST" enctype="multipart/form-data" id="fileUploadForm">
                                    <div class="form-group">
                                        <label class="control-label" for="uploadfile">Upload File:</label>
                                        <input type="file" class="form-control" id="uploadfile" placeholder="Upload File"  name="uploadfile" multiple>
                                    </div>
                                    <button type="submit" class="btn btn-default" id="btnSubmit">Upload</button>
                                </form>
                                <div id="listFiles"></div>

                        <h6>Тип продажу</h6>
                <hr>


                        <div class="row" >
                            <div class="col-xs-2">
                                <p style="float: right">Тип продажу:</p>
                            </div>
                            <div class="col-xs-10">
                                <select id="change-blic">
                                    <option value="0">Вибрати</option>
                                    <option value="1">Простий аукціон</option>
                                    <option value="2">Аукцион з можливістю бліц-покупки</option>
                                </select>
                            </div>
                        </div>

                        <div class="row" >
                            <div class="col-xs-2">
                                <p style="float: right">Ціна стартова</p>
                            </div>
                            <div class="col-xs-10">
                                <input type="text" id="startPrice">
                            </div>
                        </div>

                        <div class="row blic" >
                            <div class="col-xs-2">
                                <p style="float: right">Ціна купити зараз</p>
                            </div>
                            <div class="col-xs-10">
                                <input type="text" id="hotPrice">
                            </div>
                        </div>

                <div class="type-sell-head">
                    <div class="start-sell">Дата початку торгів</div>
                    <div class="form-dataSell">

                            <label for="dateStart">Дата</label>
                            <input type="datetime-local" id="dateStart" name="dataStartLot"/>
                    </div>



                </div>
                        <div class="both"></div>
                        <div class="type-sell-head">
                            <div class="start-sell">Тривалість торгів</div>
                            <div class="form-dataSell">
                                <select id="dayOfSell">
                                    <option value="0">Виберіть</option>
                                    <option value="1">1</option>
                                    <option value="3">3</option>
                                    <option value="5">5</option>
                                    <option value="7">7</option>
                                    <option value="9">9</option>
                                    <option value="11">11</option>
                                    <option value="14">14</option>
                                </select>

                            </div>
                        </div>
                        <div class="both"></div>

                <h6 style="margin-top: 20px">Оплата і доставка</h6>
<hr>

                        <div class="row">
                            <div class="col-xs-2">
                                <p style="float: right">Спосіб доставки</p>
                            </div>
                            <div class="col-xs-10 delivery-checkbox">
                                <%--<div class="delivery-checkbox"></div>--%>
                                           <div class="resultDelivery">

                                <label >
                                    <input class="resultDelivery" type="checkbox" value="1">
                                </label >Нова Пошта<br>

                                    <label >
                                        <input class="resultDelivery" type="checkbox" value="2">
                                    </label>При зустрічі<br>


                                    <label >
                                    <input class="resultDelivery" type="checkbox" value="3">
                                </label>Самовивіз<br>
                                <label>
                                    <input class="resultDelivery" type="checkbox" value="4">
                                </label>По договору<br>
                                           </div>

                            </div>
                        </div>

                        <br>
                <button class="createLotForm" type="submit">Створити</button>
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
            <div class="balans hidden">balans</div>
            <div class="mesagges hidden">masegges</div>


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