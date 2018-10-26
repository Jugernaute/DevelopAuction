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

// function loadImage(){
//     imgContainer.append('<img src="'+imgFirstChildSrc.prop('src')+'" alt="'+imgFirstChildSrc.prop('alt')+'">');
// }


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


$('#heart-empty').on('click',function () {
    let $lot = $('.lot-slider-column');
    imgContainer.empty();
    $lot.empty();

    $.ajax({
       url: 'http://localhost:8080/lot/loadImg',
        type: 'put',

        success: function (result) {
            $lot.append('<img src="../img/product_Img/'+result+'">');
            imgContainer.append('<img src="../img/product_Img/'+result+'">');
            // imgContainer.append('<img src="'+result+'" alt="'+tempAlt+'">')
            // loadImage();
            console.log(result);
        },
        error: function (error) {
            console.log(error)
        }
    });


});
