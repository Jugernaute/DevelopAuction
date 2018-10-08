let nameCommonCategory;     // select commonCategory
let subCategory;            // select subCategory
let nameProduct;            // select product
let stateProduct;           // result stateProduct (enum)
let files;                  // image of product
let changeBlic;             // change type of sell (enum)
let resultDelivery=[];




//------------------------кнопка вибору товарів (загрузка першої колонки селектів)--------
$('.btn_Category').on('click',function () {
    $('.categoryStaticList').css('display','block');
    $('#sellFromSelectFirst').empty();
    $.ajax({
        url: 'http://localhost:8080/loadCommonCategory',
        type: 'get',
        dataType : 'json',                    //  get
        // contentType: 'application/json',      // send

        success: function (result) {
            $(result).each(function (index, object) {
                let $div = $('<option/>',{text:object.nameCommonCategory});
                        $('#sellFromSelectFirst').append($div)
            })
        },
    })
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

//-----------------------------(загрузка другої колонки селектів)-----------------------
$('#sellFromSelectFirst').on('click',function () {
    nameCommonCategory = $(this).val();
    $('#sellFromSelectSecond').empty();
    $('#sellFromSelectThrid').empty();
    $.ajax({
        url: 'http://localhost:8080/loadSubCategory',
        type: 'post',
        data: nameCommonCategory,
        contentType: 'application/json',

        success: function (result) {
            $(result).each(function (index, value) {
                let $option = $('<option/>',{text:value.nameSubCategory});
                $('#sellFromSelectSecond').append($option);
            })
        }
    });
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


//-------------------------------------------(загрузка третьої колонки селектів)--------

$('#sellFromSelectSecond').on('click',function () {
    subCategory = $(this).val();
    $('#sellFromSelectThrid').empty();
    $.ajax({
        url: 'http://localhost:8080/loadManufacturers',
        type: 'post',
        data: subCategory,
        contentType: 'application/json',

        success: function (result) {
            $(result).each(function (index, value) {
                let $option = $('<option/>',{text:value.nameManufacturer});
                $('#sellFromSelectThrid').append($option);
            })
        }
    });
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

//---------------------------------Вибір товару з третьої колонки---------------
$('#sellFromSelectThrid').on('dblclick',function () {
    nameProduct = $(this).val();
    console.log(nameProduct)
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


//--------------------------------------Вибір типу аукціону-----------------
$('#change-blic').on('change',function () {
    changeBlic = "";
    if($(this).val()==2) {
        changeBlic="Аукцион з можливістю бліц-покупки";
        console.log(changeBlic==="Аукцион з можливістю бліц-покупки");
        console.log($(this).val());
        $('.blic').css('display', 'block');
    }else
    {
        changeBlic="Простий аукціон";
        $('.blic').css('display', 'none');
    }
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


//--------------------------------------Вибір типу продукту(б.у\новий)--------
$('.stateProduct').on('click',function () {
    // $('.stateProduct').empty();
    $.ajax({
        url: 'http://localhost:8080/loadStateProduct',
        type: 'put',
        // data: nameCommonCategory,
        contentType: 'application/json',

        success: function (result) {

            $(result).each(function (index, value) {

                let $option = $('<option/>',{text:value});
                // $('#resultStateProduct').append($option);

            });
        }
    });
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

$('#resultStateProduct').on('change',function () {
// stateProduct = ($(this).val());                     // виводить індекс stateProduct
    stateProduct = "";
    if($(this).val()==1) {
        stateProduct="Новий";
        $('.blic').css('display', 'block');
    }else {
        stateProduct = "Вживаний";
    }
});

//------------------------------------------отримуємо інфу від чекбоксів-------

$('.resultDelivery').on('change', function () {
    // $(this).empty();
    // resultDelivery = [];
    if ($(this).is(':checked')){
        console.log($(this).val());
   // console.log($(this).attr('name'));
        resultDelivery.push($(this).val())
    }
    // console.log(resultDelivery)
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


$('#btnSubmit').on('click',function (event) {
    event.preventDefault();
    nameProduct = $('#inputProduct').val();
    let descriptionProduct = $('#descriptionProduct').val();
    let modelProduct = $('.modelProduct').val();

    let formData = new FormData($("#fileUploadForm")[0]);

    formData.append("nameProduct", nameProduct);
    formData.append("nameCommonCategory", nameCommonCategory);
    formData.append("nameSubCategory", subCategory);
    formData.append("stateProduct", stateProduct);
    formData.append("descriptionProduct", descriptionProduct);
    formData.append("modelProduct", modelProduct);
    formData.append("typeSell", changeBlic);
    if(changeBlic==="Аукцион з можливістю бліц-покупки"){
        formData.append("hotPrice", $('#hotPrice').val())
    }else {
        formData.append("hotPrice", "")
    }
    formData.append("startPrice", $('#startPrice'));
    formData.append("dataStartLot", $('#dateStart').val());
    formData.append("durationOfLot",$('#durationOfLot').val());
    formData.append("methodDelivery", resultDelivery);


    let val = $('#listFiles').val();
    console.log(val);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: 'http://localhost:8080/loadImg',
        data: formData,
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
     files = evt.target.files; // FileList object

// Loop through the FileList and render image files as thumbnails.
    for (let i = 0, f; f = files[i]; i++) {

        // Only process image files.
        if (!f.type.match('image.*')) {
            continue;
        }

        let reader = new FileReader();

        // Closure to capture the file information.
        reader.onload = (function(theFile) {
            return function(e) {
                // Render thumbnail.
                let span = document.createElement('span');
                span.innerHTML = ['<img class="thumb" src="', e.target.result,
                    '" title="', theFile.name, '"/>'].join('');
                document.getElementById('listFiles').insertBefore(span, null);
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

$('.createLotForm').on('click', function () {
    let val = $('#dateStart').val();
    let date = new Date(val);
    let s = date.toLocaleString();
    let s1 = date.toTimeString();
    let s2 = date.toUTCString();
   //  console.log(s);
   //  console.log(s1);
   //  console.log(s2);
   // console.log(date.getTime()/1000);
   // console.log($('#dayOfSell').val());
   console.log(resultDelivery);
   resultDelivery=[];
   $('input[type=checkbox]').prop('checked',false);
});