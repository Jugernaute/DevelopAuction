charset='UTF-8';
let idProductSession = sessionStorage.getItem("idLot");

let bet = $('#bet-input');
let error = $('#error-bet');
let price = $('#price');
let btn = $('#btn-buy');
let heart = $('.lot-nav-add');
let $view = $('.view-user');



let optionList = $('.lot-about_options-list li');
let optionListShow = $('.slider');
optionList.on('click', function () {
    for (let i = 0; i < optionList.length; i++) {
        optionList[i].style.borderBottom = 1 +'px solid gray';
    }
    $(this).css('border-bottom', 'none');

    for (let opt of optionListShow) {
        opt.classList.add('hidden')
    }


    if ($(this).attr('id') === 'descr') {
        $('.lot-about_descr').toggleClass('hidden');
    } else if ($(this).attr('id') === 'buy') {
        $('.lot-about_buy').toggleClass('hidden');
    } else if ($(this).attr('id') === 'bet') {
        $('.lot-about-bet').toggleClass('hidden');
    }
});

optionList.first().css('border-bottom', 'none');


///gallery
let imgContainer = $('.lot-slider-container');
let imgFirstChildSrc = $('.lot-slider-column:first-child').children();

function loadImage(){
    imgContainer.append('<img src="'+imgFirstChildSrc.prop('src')+'" alt="'+imgFirstChildSrc.prop('alt')+'">');
}
loadImage();

$('.lot-slider-column').on('click', function () {
    imgContainer.children().remove();

    let tempImg = $(this).children().prop('src');
    let tempAlt = $(this).children().prop('alt');

    imgContainer.append('<img class="imgSrc" src="'+tempImg+'" alt="'+tempAlt+'">').addClass("create");
});

///heart

heart.on('click', function () {
    $('#heart-empty').toggleClass('hidden');
    $('#heart-full').toggleClass('hidden')
});

/*
* timer
* */


let number = $('#test').text();
let nowDate;
let lotDateEnd;

let x = setInterval(function() {
    nowDate = new Date().getTime();
    lotDateEnd = Date.parse(number.toString());
    let distance =lotDateEnd-nowDate;

    let days = Math.floor(distance / (1000 * 60 * 60 * 24));
    let hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    let minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    let seconds = Math.floor((distance % (1000 * 60)) / 1000);

    document.getElementById("timer").innerHTML = days + "дн " + hours + "г "
        + minutes + "хв " + seconds + "с";

    if (nowDate >= lotDateEnd) {
        endAuction()
    }

    if (distance < 0) {
        clearInterval(x);
        document.getElementById("timer").innerHTML = "EXPIRED";
        $.ajax({
            url: "/timerEnd",
            type: "get",
            data: {idProductSession},
            success: function (result) {
                console.log("success");
            }
        })
    }
}, 1000);

/*end timer*/


bet.on('click',function () {
   error.empty();
   if (bet.val().length > 0) {
       error.empty();
   }
});

/*
* up bet
* */
let bet1 = $('.bet-btn1');
let bet2 = $('.bet-btn2');

$('#btn-bet').on('click',function () {
    // let srcImg=imgContainer.find('img').attr('src');
    // let srcLink = srcImg.toString().replace("http://localhost:8080/img/product_Img/","");
    let betUps = $('#bet-input').val();

    $.ajax({
        url: "http://localhost:8080/lot/betUp",
        type: 'post',
        data: {betUps, idProductSession},

        success:function (result) {
            // console.log(result);
            $.each(result, function(key, value) {
                if (key === "errorBet") {
                    error.empty();
                    bet.focus();
                    bet.val("");
                    bet.attr('placeholder',value);
                    bet.addClass('red');
                    error.append("Введіть ставку не меншу 10% від поточної ціни")
                }
                if (key === "price"){
                    price.empty();
                    price.append(value)
                }
                if ((key === "endData")) {
                    bet.focus();
                    error.empty();
                    error.append(value);
                }
                if (key==="nextCurrentPrice"){
                    bet.removeClass("red");
                    bet.attr('placeholder',"");
                    bet.val("");
                    bet.attr('placeholder',value)
                }
                if (key ==="sizeLot"){
                    bet1.empty();
                    bet1.append(value)
                }
                if (key ==="userFromSession"){
                    bet2.empty();
                    bet2.append(value)
                }
                if (key==="registration"){
                    error.empty();
                    error.append(value)
                }
            })
            }
    })
});
/*
* up bet end
* */

/*
* get from DB list of lots bet*/
let $bet = $('#bet');
let lot = $('.lot-about-bet');
let p = $('#p-btn');

$bet.on('click',function () {
    // let srcImg=imgContainer.find('img').attr('src');
    // let srcLink = srcImg.toString().replace("http://localhost:8080/img/product_Img/","");

    $.ajax({
        url:'http://localhost:8080/lot/listBet',
        type: 'get',
        data: {idProduct: idProductSession},
        dataType: "json",
        // contentType: "application/json/*; charset=utf-8*/",

        success: function (data) {
            console.log("ok");
            lot.empty();
            let num=0;
            $.each(data, function(k, v) {
                num++;
                console.log(k+" "+v);
                let $div = '<p class="list-bet-out">'+num+" - "+k+"грн "+'<em><b>'+v+'</b></em>' +" "+'</p><br>';

                lot.append($div)
            });

        },
        error: function (error) {
            console.log(error)
        }
    })
});
/*
* end
* */


/*
* get from DB description of product
* */
let $descript = $('#descr');
let $lotDescript = $('.lot-about_descr');

$descript.on('click',function () {
    let srcImg=imgContainer.find('img').attr('src');
    let srcLink = srcImg.toString().replace("http://localhost:8080/img/product_Img/","");

    $.ajax({
        url:'http://localhost:8080/lot/lotDescription',
        type: 'get',
        data: {linkImg: srcLink},

        success: function (result) {
            $lotDescript.empty();
            // console.log(result.lastIndexOf('\n'));
            // let replace = result.replace('\n',"<br>");

            $lotDescript.append(result)
        },
        error:function (error) {
            console.log(error);
        }
    })

});
/*
* end
* */
function endAuction(){
    $('#btn-bet').prop("disabled", true);
    $('#btn-buy').prop("disabled", true);
    $('#send-massege').prop("disabled", true);
    bet.attr("placeholder","");
    $('#bet-input').prop("disabled", true);
}
/*
* if hot price of product isn't present in lot(=='0'), than button is disable  &&
* if user isn't anonymous, than button 'Вхид' append display block
* && update page
* using window.load
* */


$(window).on('load',function () {

    let hotPrice = $('#p-btn').text();

    if ($('.for-remove-2').text()!=='anonymousUser') {
        $view.css('display','block');
        $('.enter').css('display','none')
    }else{
    }
    if (hotPrice!== "0") {
        btn.prop("disabled", false);
    }else {
        p.empty();
        p.append("Не доступно");
    }

    /*
    * update page of lot every 10sec
    * for update information about Lot
    * */
    if (nowDate < lotDateEnd) {
        setInterval(function () {
            $.ajax({
                url: 'http://localhost:8080/lot/updatePage',
                data: {idProduct: idProductSession},
                success: function (result) {
                    console.log(result);
                    $.each(result, function (key, value) {
                        if (key === "price") {
                            price.empty();
                            price.append(value)
                        }
                        if (key === "nextCurrentPrice") {
                            bet.removeClass("red");
                            bet.attr('placeholder', "");
                            bet.val("");
                            bet.attr('placeholder', value)
                        }
                        if (key === "betsLot") {
                            bet1.empty();
                            bet1.append(value)
                        }
                        if (key === "userLider") {
                            bet2.empty();
                            bet2.append(value)
                        }
                    })
                },
                error: function (error) {

                }
            })
        }, 10000);
    }
});
/*
* end
* */

btn.on('click',function () {
    let userName = $view.text();
    if(userName==="anonymousUser"){
        error.empty();
        error.append("Ви повинні спочатку авторизуватися")
    }else{

    let srcImg=imgContainer.find('img').attr('src');
    let srcLink = srcImg.toString().replace("http://localhost:8080/img/product_Img/","");

    $.ajax({
        url:'http://localhost:8080/lot/hotPrice',
        type: 'get',
        data: {linkImg: srcLink},


        success: function (result) {
            error.empty();
            error.append(result);
            console.log(result);
            endAuction();
        }
    })
    }
});
