<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta charset="UTF-8">
    <title>sell</title>
    <link rel="stylesheet" href="<c:url value="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"/>">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

    <link rel="stylesheet" href="../style/main.css">
    <link rel="stylesheet" href="../style/cabinet_style.css">
    <script src="../js/cabinet.js" defer></script>
    <script src="../js/main.js" defer></script>
    <script src="../js/createLot.js" defer></script>
</head>
<body>
<a href="lot">lot</a>
<div class="auction">
    <header>
        <div class="wrapper">
            <div class="logo"><a href="/fromLogoToHome"><img src="../img/logo.png"></a></div>
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
                            <div id="btn-img">
                                <a><label for="uploadfile">Add files..</label></a>
                            </div>
                        <input type="file" style="visibility: hidden" class="form-control" id="uploadfile" placeholder="Upload File"  name="uploadfile" multiple>
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

            <div class="option-list-show-type-wrapper">
                <p class="required">Регіон : </p>
                <label>
                    <select id="region-lot">
                        <option value="0">Виберіть</option>
                        <option value="98">А.Р.Крым</option>
                        <option value="99">Винницкая</option>
                        <option value="100">Волынская</option>
                        <option value="101">Днепропетровская</option>
                        <option value="102">Донецкая</option>
                        <option value="103">Житомирская</option>
                        <option value="104">Закарпатская</option>
                        <option value="105">Запорожская</option>
                        <option value="106">Ивано-Франковская</option>
                        <option value="108">Киевская</option>
                        <option value="109">Кировоградская</option>
                        <option value="110">Луганская</option>
                        <option value="112">Львовская</option>
                        <option value="146">Не из Украины</option>
                        <option value="113">Николаевская</option>
                        <option value="114">Одесская</option>
                        <option value="115">Полтавская</option>
                        <option value="116">Ровненская</option>
                        <option value="118">Сумская</option>
                        <option value="119">Тернопольская</option>
                        <option value="120">Харьковская</option>
                        <option value="121">Херсонская</option>
                        <option value="122">Хмельницкая</option>
                        <option value="123">Черкасская</option>
                        <option value="125">Черниговская</option>
                        <option value="126">Черновицкая</option>
                        <option value="107">г. Киев</option>
                        <option value="117">г. Севастополь</option>
                    </select>
                    <div id="region-error"></div>
                </label>
                </div>
            <div class="option-list-show-type-wrapper">
                <p class="required">Місцеположення : </p>
                <label>
                    <input type="text" id="place-lot" placeholder="де знаходиться ваш товар">
                    <div id="place-lot-error"></div>
                </label>
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

    <script id="template-upload" type="text/x-tmpl">
            {% for (var i=0, file; file=o.files[i]; i++) { %}
            <tr class="template-upload fade">
            <td class="preview"><span class="fade"></span></td>
            <td class="name"><span>{%=file.name%}</span></td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            {% if (file.error) { %}
            <td class="error" colspan="2"><span class="label label-important">{%=locale.fileupload.error%}</span> {%=locale.fileupload.errors[file.error] || file.error%}</td>
            {% } else if (o.files.valid && !i) { %}
            <td>
            <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="bar" style="width:0%;"></div></div>
            </td>
            <td class="start">{% if (!o.options.autoUpload) { %}
            <button class="btn btn-primary">
            <i class="icon-upload icon-white"></i>
            <span>{%=locale.fileupload.start%}</span>
            </button>
            {% } %}</td>
            {% } else { %}
            <td colspan="2"></td>
            {% } %}
            <td class="cancel">{% if (!i) { %}
            <button class="btn btn-warning">
            <i class="icon-ban-circle icon-white"></i>
            <span>{%=locale.fileupload.cancel%}</span>
            </button>
            {% } %}</td>
            </tr>
            {% } %}
        </script>
    <!-- The template to display files available for download -->
    <script id="template-download" type="text/x-tmpl">
            {% for (var i=0, file; file=o.files[i]; i++) { %}
            <tr class="template-download fade">
            {% if (file.error) { %}
            <td></td>
            <td class="name"><span>{%=file.name%}</span></td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            <td class="error" colspan="2"><span class="label label-important">{%=locale.fileupload.error%}</span> {%=locale.fileupload.errors[file.error] || file.error%}</td>
            {% } else { %}
            <td class="preview">{% if (file.thumbnail_url) { %}
            <a href="{%=file.url%}" title="{%=file.name%}" rel="gallery" download="{%=file.name%}"><img src="{%=file.thumbnail_url%}"></a>
            {% } %}</td>
            <td class="name">
            <a href="{%=file.url%}" title="{%=file.name%}" rel="{%=file.thumbnail_url&&'gallery'%}" download="{%=file.name%}">{%=file.name%}</a>
            </td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            <td colspan="2"></td>
            {% } %}
            <td class="delete">
            <button class="btn btn-danger" data-type="{%=file.delete_type%}" data-url="{%=file.delete_url%}">
            <i class="icon-trash icon-white"></i>
            <span>{%=locale.fileupload.destroy%}</span>
            </button>
            <input type="checkbox" name="delete" value="1">
            </td>
            </tr>
            {% } %}
        </script>











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