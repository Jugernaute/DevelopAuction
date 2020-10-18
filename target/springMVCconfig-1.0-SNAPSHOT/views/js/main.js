

    let loginForm = $('.enter_form');
    let regForm = $('.registration_form');
    let auction = $('.auction');
    let resultRegistration = $('.resultRegistration');
    let $username = $('.enterUsername');
    let $email = $('.enterEmail');

    $('.enter').on('click', function (e) {// animation for login form
        loginForm.css('display', 'block');
        regForm.css('display', 'none');
        auction.addClass('blur');
    });

    $('.registation').on('click', function () { //animation for registaration form
        regForm.css('display', 'block');
        loginForm.css('display', 'none');
        $('.auction').addClass('blur');
    });

    $('.cancelbtn').on('click',function () {
        regForm.css('display', 'none');
        auction.removeClass('blur');
        $(this).parent().parent().find('input').val('');
    });

    $('.close').on('click',function () { // close login & registr form
        loginForm.css('display', 'none');
        regForm.css('display', 'none');
        auction.removeClass('blur');
        $(this).parent().parent().find('input').val('');
        $(this).parent().parent().find('#psw-must-have').css({
            'font-weight': 'normal',
            'color' : 'black'
        });
        $(this).parent().parent().find('input[name="psw-repeat"]').prop('placeholder',"Повторіть пароль");
    });

    $('.btn_alt_reg').on('click', function () { //open reg form from login form
        loginForm.css('display', 'none');
        regForm.css('display', 'block');
    });
    
    $('.signupbtn').on('click', function (event) {      //password validation
        // debugger;
        let psw = $(this).parent().parent().find('input[name="psw"]');
        let password = $('.enterPassword').val();
        let psw_repeat = $('.enterRepeatPassword').val();
        let email = $email.val();
        let pswRepeat = $(this).parent().parent().find('input[name="psw-repeat"]');
        let passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,20}$/;
        let emailRegs = /^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$/;
        if ($username.val().length<3){
            $username.focus();
        }
        if (psw.val() != pswRepeat.val()){
            pswRepeat.val('');
            pswRepeat.prop('placeholder',"ПАРОЛІ НЕ ЗБІГАЮТЬСЯ!!!");
        } else if (!password.match(passw)){
            psw.focus();
            psw.val('');
            $(this).parent().parent().find('#psw-must-have').css({
                    'font-weight': 'bold',
                    'color' : 'red'
                });
        }else if (password === psw_repeat) {
        $('.resultRegistration').empty();
        }

        $('.reg_container').css('display','none');
        $('.registration_form').addClass('success-login');
        $('#img_loading').css('display','block');
        let username = $username.val();



        event.preventDefault();
        $.ajax({
            url: 'http://localhost:8080/registrationUser',
            type: 'post',
            data: {username, email, password, psw_repeat},
            dataType: 'text',

            success: function (result) {
                    console.log("ok");
                    resultRegistration.css('display','block');
                    $('#img_loading').css('display','none');
                    resultRegistration.append(result+'<br>'+'<a href="">Main Page</a>')
            },
            error: function (error) {
                    $('.reg_container').css('display','block');
                    $('.registration_form').removeClass('success-login');
                    $('#img_loading').css('display','none');
                console.log(error)
            }
        })
    });

    //social network animation

    let socialImg = $('.social img');
    socialImg.on('mouseover',function () {
        $(this).css({
            'margin-top' : 0,
            'transition' : 350+ 'ms'
        })
    });
    socialImg.on('mouseleave',function () {
        $(this).css({
            'margin-top' : -38 +'px',
            'transition' : 350 + 'ms'
        })
    });
    // rest security



///category list///////////

    // $('.products_list').on('click', () => {
    //     $('.category-list').toggleClass('hidden')
    // });
    //
    // $('.category-list-parent').on('mouseover', ()=> {
    //    $(this).next().toggleClass('hidden')
    // });

    $('.households').on('click',function () {
        let nameCategory = $(this).find('a').text();
        // console.log(nameCategory);
        $.ajax({
           url:'http://localhost:8080/category/'+nameCategory,
           success: function (result) {
               // debugger;
               $('.hot_lot').empty();
               $('select option[value="0"]').attr('selected',true); // <- change select 'filter-nav' on default value "0"
                                                                   // if selected another value
                $.each(result, function(a, b) {
                   appendResultMapFromController(b)
                   });
                if ($('.hot_lot').has('div').length===0){
                   // console.log("ddddd");
                   $('.hot_lot').append('<h2 class="text-no-div">По Вашому запиту немає жодного результату</h2>')
               }
           }
       })
    });


$('.cont_img').on('click',function () {
    let message = $(this).find('a').attr('href');
    let idProductInSession = message.replace("lot/","");
    sessionStorage.setItem("idLot",idProductInSession);
});

/*main filter for non-register user*/

$('.filter-nav').on('change', function () {
    let select = $(this).val();
    /* @select="0" Виберіть
       @select="1" Всі аукціони
       @select="2" Аукціони, що вже тривають
       @select="3" Завершені аукціони
       @select="4" Ще не розпочаті аукціони
       */
    $('select option[value="0"]').attr('selected',false); // return for default   !!!
    $.ajax({
        /*
        * send to RestMainController
        */
        // $('select option[value="0"]').attr('selected',true);
        url: 'http://localhost:8080/main/select',
        type: 'post',
        data: {select},
        success: function (result) {
            $('.hot_lot').empty();
            $.each(result, function(a, b) {
                appendResultMapFromController(b);
            });
        }
    })
});

    $('#sbm-srch').on('click', function () {
        let search_text = $('#srch').val();
        $.ajax({
            url: 'http://localhost:8080/main/search',
            type: 'post',
            data: {search_text},
            success: function (result) {
                $('.hot_lot').empty();
                $.each(result, function(a, b) {
                    appendResultMapFromController(b)
                });
            }
        })

    });




function appendResultMapFromController(b) {
    $('.hot_lot').append('<div class="hot_lot_wrapper">' +
    '<div class="cont_img">' +
    '<a href="lot/'+b.idProduct+'" class="get-id"><img' +
    ' src="../img/product_Img/'+b.imgLink+'" height="200" width="200"/></a></div>' +
    '<div class="container">' +
    '<h2 class="cont_titel"><b>' +
    '<p>'+b.nameProduct +'</p>' +
    '<p>'+b.modelProduct+'</p>' +
    '</b></h2>' +
    '<p class="text-end">завершення :</p>' +
    '<div class="cont_timer">' +
    '<p>'+b.dataEndLot+'</p>' +
    '</div>' +
    '<h4 class="cont_price">Ціна : <span>'+b.currentPrice +' грн.</span></h4>' +
    '</div>' +
    '</div>')
}

