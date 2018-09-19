
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
    let nameCommonCategory = $(this).val();
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
    let nameProduct = $(this).val();
    $('#sellFromSelectThrid').empty();
    $.ajax({
        url: 'http://localhost:8080/loadManufacturers',
        type: 'post',
        data: nameProduct,
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
