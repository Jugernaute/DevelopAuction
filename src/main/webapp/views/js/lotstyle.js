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

let heart = $('.lot-nav-add');

heart.on('click', function () {
    $('#heart-empty').toggleClass('hidden');
    $('#heart-full').toggleClass('hidden')
});

/*
* timer
* */
let number = $('#test').text();
let x = setInterval(function() {

    let now = new Date().getTime();
    let countDownDate = Date.parse(number.toString());
    let distance =countDownDate-now;

    let days = Math.floor(distance / (1000 * 60 * 60 * 24));
    let hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    let minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    let seconds = Math.floor((distance % (1000 * 60)) / 1000);

    document.getElementById("timer").innerHTML = days + "дн " + hours + "г "
        + minutes + "хв " + seconds + "с";

    if (distance < 0) {
        clearInterval(x);
        document.getElementById("timer").innerHTML = "EXPIRED";
    }
}, 1000);

/*end timer*/

$('.cont_img').on('change',function () {
    let val = $(this).val();
    console.log(val+"id");
});

let bet = $('#bet-input');
let error = $('#error-bet');
let price = $('#price');

bet.on('click',function () {
   error.empty();
   if (bet.val().length > 0) {
       error.empty();
   }
});
let bet1 = $('.bet-btn1');
let bet2 = $('bet-btn2');
$('#btn-bet').on('click',function () {
    let srcImg=imgContainer.find('img').attr('src');
    let srcLink = srcImg.toString().replace("http://localhost:8080/img/product_Img/","");
    let betUps = $('#bet-input').val();

    $.ajax({
        url: "http://localhost:8080/lot/betUp",
        type: 'post',
        data: {betUps, srcLink},

        success:function (result) {
            // console.log(result);
            $.each(result, function(key, value) {
                if (key === "errorBet") {
                    error.empty();
                    bet.focus();
                    bet.val("");
                    bet.attr('placeholder',value);
                    bet.addClass('red');
                    error.append("Введіть ставку не меншу 10% від поточної ціни - ")
                }
                if (key === "price"){
                    price.empty();
                    price.append(value)
                }
                if ((key === "placeholder")) {
                    bet.focus();
                    bet.attr('placeholder',value)
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
                if (key ==="user"){
                    bet2.empty();
                    bet2.append(value)
                }
            })
            }
    })
});
let $bet = $('#bet');
let lot = $('.lot-about-bet');
$bet.on('click',function () {
    let srcImg=imgContainer.find('img').attr('src');
    let srcLink = srcImg.toString().replace("http://localhost:8080/img/product_Img/","");

    $.ajax({
        url:'http://localhost:8080/lot/listBet',
        type: 'get',
        data: {linkOfImage: srcLink},
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

            // debugger;


    })
});
