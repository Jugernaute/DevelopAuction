// $(document).ready(function() {
// //     $(window).keydown(function(event){
// //         if(event.keyCode == 13) {
// //             event.preventDefault();
// //             return true;
// //         }
// //     });
// // });

let hotLot = $('.hot_lot');
$('.comm-product-main').on('click', function () {
    let elem = $(this).find('a');
    // console.log('asd' === 'asd');
    getOnControllerFromFilter(elem);

});


$('.sub-category-title').find('a').on('click', function () {
    $.ajax({
        url:'http://localhost:8080/filter/allLot',
        success: function (result) {
            parseSetFromController(result,"false");
        }
    })
});


$('.sub-category').on('click','.comm-product',function () {
        let elem = $(this).find('a');
        getOnControllerFromFilter(elem, "true");
});

$('.sub-category').on('click','.sub-product',function () {
    let el = $(this).find('a');
    let text = el.text();
    let message = text.indexOf("(");
    let nameSubProduct = text.substring(0, message);
    // console.log(nameSubProduct);
    $.ajax({
        url: 'http://localhost:8080/sub/'+nameSubProduct,
        success: function (result) {
            hotLot.empty();
            el.toggleClass('change');
            $.each(result, function (a,b) {
                parseListOfLotFromControllerOnView(b);
            });
        if (hotLot.has('div').length===0) {
                // console.log("ok");
                hotLot.append('<h2 class="text-no-div">По Вашому запиту немає жодного результату</h2>')
            }
            // console.log(hotLot.has('div').length);
        }
    })
});

$('.type-lot li').on('click',function () {
    // let find = $(this).text();
    $(this).toggleClass('change');
});

$('#region-lot').on('change',function () {
    // console.log($(this).find('option:selected').text());
    if($(this).find('option:selected').val()!=='0'){
        $('.div-region-lot').addClass('change');
    }
    else if ($(this).find('option:selected').val() === '0') {
        $('.div-region-lot').removeClass('change');
    }
});

$('.filter-price-btn').on('click',function () {
    let priceFrom = $('.filter-price-from').val();
    let priceTo = $('.filter-price-to').val();
    if (priceFrom !=='' && priceTo!==''){
        $('.div-input').addClass('change');
    }else {
        $('.div-input').removeClass('change')
    }
});

$('.select-data-start').on('change',function () {
    let $select = $('.select-data-start option:selected');
    // console.log($select.text());
    if ($select.val()!=='0') {
        $('.filter-data-start').addClass('change');
    }else{
        $('.filter-data-start').removeClass('change');
    }
});

$('.select-data-end').on('change',function () {
    let $select = $('.select-data-end option:selected');
    // console.log($select.text());
    if ($select.val()!=='0') {
        $('.filter-data-end').addClass('change');
    }else{
        $('.filter-data-end').removeClass('change');
    }
});

let classes = [];
// $('.div1').on('.click',function () {
//     console.log("ok");
//     console.log(document.getElementsByClassName('change'));
//     for (let i = 0; i < classes.length; i++) {
//         console.log(classes[i]);
//     }
// });
$('.div1').find('*').each(function(){
    console.log($(this));
});



//--------------------------- functions  -------------------------//

function getOnControllerFromFilter(elem) {
    let text = elem.text();
    let message = text.indexOf("(");
    let nameCommProduct = text.substring(0, message);
    $.ajax({
        url: 'http://localhost:8080/filter/comm/'+nameCommProduct,
        success: function (result) {

            parseSetFromController(result, "true");
        }
    });
}

function parseSetFromController(result, boolean) {
    /*if boolean is 'true':
    *       this need for return class = "sub-product"
    *       else return class = "comm-product"
    *       */

    hotLot.empty();
    $('.sub-category').empty();
    $.each(result, function(a, b) {
        if (a === 0) {
            $.each(b, function (x, y) {
                if (boolean === "true") {
                    $('.sub-category').append('<li class="sub-product"><a href="#">'+x+'('+y+')</a></li>')
                }else if (boolean === "false") {
                    $('.sub-category').append('<li class="comm-product"><a href="#">'+x+'('+y+')</a></li>')
                }
            })
        }
        else if (a>0 && b.idProduct!=null) {
            parseListOfLotFromControllerOnView(b);
        }
    });
}

function parseListOfLotFromControllerOnView(b) {
    $('.hot_lot').append('<div class="hot_lot_wrapper">' +
        '<div class="cont_img">' +
        '<a href="lot/'+b.idProduct+'" class="get-id"><img' +
        ' src="../img/product_Img/'+b.imgLink+'" height="200" width="200"/></a></div>' +
        '<div class="container">' +
        '<h2 class="cont_titel"><b>' +
        '<p>'+b.nameProduct +" "+b.modelProduct+'</p>' +
        '</b></h2>' +
        '<p class="text-end">завершення :</p>' +
        '<div class="cont_timer">' +
        '<p>'+b.dataEndLot+'</p>' +
        '</div>' +
        '<h4 class="cont_price">Ціна : <span>'+b.currentPrice +' грн.</span></h4>' +
        '</div>' +
        '</div>')
}