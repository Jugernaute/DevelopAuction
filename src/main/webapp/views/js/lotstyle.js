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

    imgContainer.append('<img src="'+tempImg+'" alt="'+tempAlt+'">')
});
///heart

let heart = $('.lot-nav-add');

heart.on('click', function () {
    $('#heart-empty').toggleClass('hidden');
    $('#heart-full').toggleClass('hidden')
});


// $('#heart-empty').on('click',function () {
//     let $lot = $('.lot-slider-column');
//     imgContainer.empty();
//     $lot.empty();
//
//     $.ajax({
//        url: 'http://localhost:8080/lot/loadImg',
//         type: 'put',
//
//         success: function (result) {
//             $lot.append('<img src="../img/product_Img/'+result+'">');
//             imgContainer.append('<img src="../img/product_Img/'+result+'">');
//             // imgContainer.append('<img src="'+result+'" alt="'+tempAlt+'">')
//             // loadImage();
//             console.log(result);
//         },
//         error: function (error) {
//             console.log(error)
//         }
//     });
// });


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
let idProduct;
$("a").click(function(event) {
    // alert("As you can see, the link no longer took you to jquery.com");
    let href = $(this).attr('href');
    // alert(href);
    let s = href.toString();
    idProduct = s.replace("lot/","");
    let s1 = idProduct.toString();



    // event.preventDefault();
});
// let alt;
// $('img').click(function () {
//     alt = $(this).attr("alt");
//     // alert(alt);
// });
let alt;
// $('.lot')
$ ("img"). attr ("title", function () {
    alt =   $ (this) .attr ("alt");
});

console.log(alt);

$('#btn-bet').on('click',function () {

    let betUps = $('#bet-input').val();

    $.ajax({
        url: "http://localhost:8080/lot/"+alt+"/betUp",
        type: 'post',
        data: betUps,
        dataType: 'text',
        contentType: 'application/json',

        success:function (success) {
            console.log("ok")
        }
    })
});
