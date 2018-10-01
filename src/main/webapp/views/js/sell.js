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
$('.imageLoad').on('change',function (evt) {

    files = evt.target.files;
    console.log( files);

});

$('.loadImg').on('click',function (event) {

    event.stopPropagation(); // остановка всех текущих JS событий
    event.preventDefault();  // остановка дефолтного события для текущего элемента - клик для <a> тега
    console.log(files);
    // ничего не делаем если files пустой
    if( typeof files == 'undefined' ) return;

    // создадим объект данных формы
    let data = new FormData();

    // заполняем объект данных файлами в подходящем для отправки формате
    $.each( files, function( key, value ){
        data.append( key, value );
    });
console.log(data);
    // добавим переменную для идентификации запроса
    data.append( 'my_file_upload', 1);
// обработка и отправка AJAX запроса при клике на кнопку upload_files

    $.ajax({
       url: 'http://localhost:8080/loadImg',

            type        : 'POST', // важно!
            data        : data,
            cache       : false,
            dataType    : 'json',
            // отключаем обработку передаваемых данных, пусть передаются как есть
            processData : false,
            // отключаем установку заголовка типа запроса. Так jQuery скажет серверу что это строковой запрос
            // contentType : false,
            // функция успешного ответа сервера
            success     : function( respond/*, status, jqXHR */){
                if( typeof files == 'undefined' ) return;
                console.log(respond);
                if( typeof respond.error === 'undefined' ){
                    // ОК - файлы загружены
                    console.log("all ok!!!! uraaaaaaaaaa");
                    // выведем пути загруженных файлов в блок '.ajax-reply'
                    let files_path = respond.files;
                    let html2 = '';
                    $.each( files_path, function( key, val ){
                        // console.log(val);
                        html2 += val +'<br>';
                        let $div = $('<div/>',val);
                        $('.pop').append( $div );
                    } );


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
                document.getElementById('list').insertBefore(span, null);
            };
        })(f);

        // Read in the image file as a data URL.
        reader.readAsDataURL(f);
    }
}

document.getElementById('files').addEventListener('change', handleFileSelect, false);
// $('#files').on('change', function () {
//     handleFileSelect()
// });


// // Проверяем поддержку различных файлов API.
// if ( window . File && window . FileReader && window . FileList && window . Blob ) { alert('all ok') }
//     else {
// alert ( 'API-интерфейсы файлов не поддерживаются полностью в этом браузере.' ); }
