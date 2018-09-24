let nameCommonCategory;     // select commonCategory
let subCategory;            // select subCategory
let nameProduct;            // select product
let stateProduct;           // result stateProduct in index !!!
let files;                  // image of product




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
    if($(this).val()==2) {
        console.log($(this).val());
        $('.blic').css('display', 'block');
    }else $('.blic').css('display', 'none');
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
stateProduct = ($(this).val());                     // виводить індекс stateProduct
console.log(stateProduct);
});

//------------------------------------------отримуємо інфу від чекбоксів-------

$('.resultDelivery').on('change', function () {
    // $(this).empty();
    if ($(this).is(':checked')){
   console.log($(this).val())}
});
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
let data;
$('.imageLoad').on('change',function () {
    files = this.file;
    console.log(typeof files);
    // data = new FormData();
    // $.each(files, function (key, value) {
    //     data.append(key, value);
    // });
});

    // Отправляем запрос
$('.loadImg').on( 'click', function( event ){

    event.stopPropagation(); // остановка всех текущих JS событий
    event.preventDefault();  // остановка дефолтного события для текущего элемента - клик для <a> тега

    // ничего не делаем если files пустой
    if( typeof files == 'undefined' ) return;

    // создадим объект данных формы
    let data = new FormData();

    // заполняем объект данных файлами в подходящем для отправки формате
    $.each( files, function( key, value ){
        data.append( key, value );
    });

    // добавим переменную для идентификации запроса
    data.append( 'my_file_upload', 1 );

    // AJAX запрос
    $.ajax({
        url         : 'http://localhost:8080/loadImg',
        type        : 'POST', // важно!
        data        : data,
        cache       : false,
        dataType    : 'json',
        // отключаем обработку передаваемых данных, пусть передаются как есть
        processData : false,
        // отключаем установку заголовка типа запроса. Так jQuery скажет серверу что это строковой запрос
        contentType : false,
        // функция успешного ответа сервера
        success     : function( respond, status, jqXHR ){

            // ОК - файлы загружены
            if( typeof respond.error === 'undefined' ){
                // выведем пути загруженных файлов в блок '.ajax-reply'
                let files_path = respond.files;
                let html = '';
                $.each( files_path, function( key, val ){
                    html += val +'<br>';
                } );

                $('.ajax-respond').html( html );
            }
            // ошибка
            else {
                console.log('ОШИБКА: ' + respond.error );
            }
        },
        // функция ошибки ответа сервера
        error: function( jqXHR, status, errorThrown ){
            console.log( 'ОШИБКА AJAX запроса: ' + status, jqXHR );
        }

    });

});

