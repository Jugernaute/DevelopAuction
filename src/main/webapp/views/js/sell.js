
let stateProductError = $('#state-product-error');
let modelNameDescription = $('#modelNameDescription');
let $spanError = $('#span-error');
let $errorFormEnter = $('#error-form-enter');
let $blic = $('#blic-error');
let $listImageFiles = $('#listFiles');
let $imageError = $('#image-error');
let $startPrice = $('#start-price');
let $dateStart = $('#dateStart');
let $durationOfLot = $('#durationOfLot');
let $duratioLotnError = $('#duration-lot-error');
let $checkboxError = $('#checkbox-error');
let $changeBlic = $('#change-blic');
let $hotPrice = $('#hot-price');
let $region = $('#region-lot');
let region = $('#region-error');
let $place = $('#place-lot');
let place = $('#place-lot-error');



//------------------------кнопка вибору товарів (загрузка першої колонки селектів)--------
$('.btn-flex').on('click',function () {
    $('.sell-item-list-wrapper').css('display', 'flex');
    $(this).addClass('hidden');
    $('.sell-item-list-lvl1').empty();
    $.ajax({
        url: 'http://localhost:8080/loadCommonCategory',
        type: 'get',
        dataType : 'json',                    //  get
        // contentType: 'application/json',      // send

        success: function (result) {
            $(result).each(function (index, object) {
                let $div = $('<option/>',{text:object.nameCommonCategory});
                        $('.sell-item-list-lvl1').append($div)
            })
        },
    })
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

//-----------------------------(загрузка другої колонки селектів)-----------------------
$('.sell-item-list-lvl1').on('click',function () {
    nameCommonCategory = $(this).val();
    $('.sell-item-list-lvl2').empty();
    $('.sell-item-list-lvl3').empty();
    $.ajax({
        url: 'http://localhost:8080/loadSubCategory',
        type: 'post',
        data: nameCommonCategory,
        contentType: 'application/json',

        success: function (result) {
            $(result).each(function (index, value) {
                let $option = $('<option/>',{text:value.nameSubCategory});
                $('.sell-item-list-lvl2').append($option);
            })
        }
    });
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


//-------------------------------------------(загрузка третьої колонки селектів)--------

$('.sell-item-list-lvl2').on('click',function () {
    subCategory = $(this).val();
    $('.sell-item-list-lvl3').empty();
    $.ajax({
        url: 'http://localhost:8080/loadManufacturers',
        type: 'post',
        data: subCategory,
        contentType: 'application/json',

        success: function (result) {
            $(result).each(function (index, value) {
                let $option = $('<option/>',{text:value.nameManufacturer});
                $('.sell-item-list-lvl3').append($option);
            })
        }
    });
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

//---------------------------------Вибір товару з третьої колонки---------------
$('.sell-item-list-lvl3').on('dblclick',function () {
    $spanError.addClass('hidden');
    $errorFormEnter.addClass('hidden');
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


//--------------------------------------Вибір типу аукціону-----------------
$changeBlic.on('change',function () {
    let temp = $('#buy-now');
    $blic.addClass('hidden');
    if($(this).val() == "Аукціон з можливістю бліц-покупки") {
        temp.removeClass('hidden')
    }else {
        temp.addClass('hidden');
    }
});

$('#resultStateProduct').on('click',function () {
    // $(this).empty();
    stateProductError.addClass('hidden');
    $errorFormEnter.addClass('hidden');
});


//------------------------------------------отримуємо інфу від чекбоксів-------

let deliveryArray = [];
let check = $('.option-list-show-send-wrapper input[type="checkbox"]');
$(check).on('change', function () {
    $checkboxError.addClass('hidden');
    deliveryArray = [];
    for (let i = 0; i < check.length; i++) {
        if (check[i].checked) {
            deliveryArray.push(check[i].getAttribute('name'));
        }
    }
    console.log(deliveryArray);

});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
$durationOfLot.on('click',function () {
    $duratioLotnError.addClass('hidden');
    $errorFormEnter.addClass('hidden')
});
$region.on('click',function () {
    region.addClass('hidden');
    $errorFormEnter.addClass('hidden')
});
$place.on('click',function () {
    place.addClass('hidden');
    $errorFormEnter.addClass('hidden');
});

$('.add-product-sell').on('click',function (event) {
    event.preventDefault();
    $('#listFiles').empty();
    stateProductError.removeClass('hidden');
    $errorFormEnter.removeClass('hidden');
    $spanError.removeClass('hidden');
    // $blic.empty();
    let formData = new FormData($("#fileUploadForm")[0]);
    let change = $('#change-blic').val();
    let manufacturerProduct = $('.sell-item-list-lvl3').val();
    let nameCommonCategory = $('.sell-item-list-lvl1').val();
    let nameSubCategory = $('.sell-item-list-lvl2').val();
    let nameProduct = $('#name-product');
    let model = $('#model');
    let resultStateProduct = $('#resultStateProduct');
    let regionLot = $("#region-lot option:selected").text();
    // $region.
    if(manufacturerProduct===null || nameCommonCategory===null ||  nameSubCategory===null){
        $spanError.empty();
        $errorFormEnter.empty();
        $spanError.append("Виберіть категорію товару");
        $errorFormEnter.append("Форма заповнена не вірно");
        return;
    }else{
        $errorFormEnter.addClass('hidden');
        $spanError.addClass('hidden');
    }
     if(nameProduct.val()===""){
        nameProduct.addClass('red');
        nameProduct.focus();
        return;
    }
    if(resultStateProduct.val()==0){
        stateProductError.empty();
        stateProductError.append("Виберіть стан товару");
        $errorFormEnter.append("Форма заповнена не вірно");
        return;
    }
    if(modelNameDescription.val()===""){
        modelNameDescription.focus();
        modelNameDescription.addClass('red');
        return;
    }
    if($listImageFiles.children().length !== 0) {
        console.log($listImageFiles.children().length);
        $imageError.empty();
        $imageError.append("Загрузіть хоча б одну картинку");
        return;
    }
    if(change==0){
        $blic.removeClass('hidden');
        $blic.empty();
        $blic.append("Виберіть тип продажу");
        return;
    }
    if($startPrice.val()===""){
        $startPrice.focus();
        $startPrice.addClass('red');
        return;
    }
    if($dateStart.val()===""){
        $dateStart.focus();
        return;
    }
    if($durationOfLot.val()==0){
        $duratioLotnError.empty();
        $errorFormEnter.empty();
        $duratioLotnError.append("Введіть тривалість торгів");
        $duratioLotnError.removeClass('hidden');
        $errorFormEnter.removeClass('hidden');
        $errorFormEnter.append("Не вірно заповнена форма");
        return;
    }
    if($region.val()==0){
        region.empty();
        $errorFormEnter.empty();
        region.removeClass('hidden');
        $errorFormEnter.removeClass('hidden');
        region.append("Виберіть регіон");
        $errorFormEnter.append("Не вірно заповнена форма");
        return;
    }
    if($place.val()===""){
        place.empty();
        $errorFormEnter.empty();
        place.removeClass('hidden');
        $errorFormEnter.removeClass('hidden');
        $place.focus();
        $place.addClass("red");
        $errorFormEnter.append("Не вірно заповнена форма");
        return;
    }
    if(deliveryArray.length==0){
        $checkboxError.empty();
        $checkboxError.removeClass('hidden');
        $checkboxError.append("Виберіть спосіб доставки");
        return;
    }
    if($changeBlic.val()=="Аукцион з можливістю бліц-покупки" && $hotPrice.val()===""){
        $hotPrice.focus();
        $hotPrice.addClass('red');
        return;
    }
    formData.append("manufacturerProduct", manufacturerProduct);
    formData.append("nameCommonCategory", nameCommonCategory);
    formData.append("nameSubCategory", nameSubCategory);
    formData.append("nameProduct", nameProduct.val());
    formData.append("stateProduct", resultStateProduct.val());
    formData.append("descriptionProduct", modelNameDescription.val());
    formData.append("modelProduct", model.val());
    formData.append("regionLot", regionLot);
    formData.append("placeLot", $place.val());
    formData.append("typeSell", change);
    if(change==="Аукціон з можливістю бліц-покупки"){
        formData.append("hotPrice", $('#hot-price').val())
    }else {
        formData.append("hotPrice", "null")
    }
    formData.append("startPrice", $('#start-price').val());
    formData.append("dataStartLot", $('#dateStart').val());
    formData.append("durationOfLot",$('#durationOfLot').val());
    formData.append("methodDelivery", deliveryArray);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: 'http://localhost:8080/loadImg',
        data: formData,
        dataType: 'JSON',
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        success: (data) => {
            $("#listFiles").text(data);
            console.log("all ok - " +data)
        },
        error: (e) => {
            $("#listFiles").text(e.responseText);
            console.log("error")
        }
    });

    event.preventDefault();
});

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
function handleFileSelect(evt) {
    $('#image-error').empty();
     let files = evt.target.files; // FileList object

// Loop through the FileList and render image files as thumbnails.
    for (let i = 0, f; f = files[i]; i++) {

        // Only process image files.
        if (!f.type.match('image.*')) {
            $imageError.empty();
            $imageError.append("Загружайте тільки картинки");
            continue;
        }

        let reader = new FileReader();

        // Closure to capture the file information.
        reader.onload = (function(theFile) {
            return function(e) {

                if ($listImageFiles.children().length < 4){
                    // console.log($listImageFiles.children().length);
                    // Render thumbnail.
                    let span = document.createElement('span');
                    span.innerHTML = ['<img class="thumb" src="', e.target.result,
                        '" title="', theFile.name, '"/>'].join("");
                    document.getElementById('listFiles').insertBefore(span, null);
                }else{
                    $('#image-error').empty();
                    $('#image-error').append("Ви не можете загрузити більше 4 картинок");
                    return false;
                }

            };
        })(f);

        // Read in the image file as a data URL.
        reader.readAsDataURL(f);
    }
}

document.getElementById('uploadfile').addEventListener('change', handleFileSelect, false);



// // Проверяем поддержку различных файлов API.
// if ( window . File && window . FileReader && window . FileList && window . Blob ) { alert('all ok') }
//     else {
// alert ( 'API-интерфейсы файлов не поддерживаются полностью в этом браузере.' ); }

$('.add-product-sell2').on('click', function () {
    // let val = $('#dateStart').val();
    // let date = new Date(val);
    // let s = date.toLocaleStringt();
    // let s1 = date.toTimeString();
    // let s2 = date.toUTCString();
    //     console.log(new FormData($("#fileUploadForm")[0]));

    // var x = this.options[].text;/
    // var options = this.getElementsByTagName("option");
    // var optionHTML = options[this.selectedIndex].innerText;
    let message = $("#region-lot option:selected").text();
    console.log($region.val());
    // console.log(message.get());

});