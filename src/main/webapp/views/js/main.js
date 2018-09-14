

    let loginForm = $('.enter_form');
    let regForm = $('.registration_form');
    let auction = $('.auction');

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
    
    // $('.signupbtn').on('click', function (event) {      //password validation
    //     let psw = $(this).parent().parent().find('input[name="psw"]');
    //     let pswRepeat = $(this).parent().parent().find('input[name="psw-repeat"]');
    //     var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,20}$/;
    //     if (psw.val() != pswRepeat.val()){
    //         pswRepeat.val('');
    //         pswRepeat.prop('placeholder',"ПАРОЛІ НЕ ЗБІГАЮТЬСЯ!!!")
    //         event.preventDefault();
    //     } else if (!psw.val().match(passw)){
    //         psw.focus();
    //         psw.val('');
    //         $(this).parent().parent().find('#psw-must-have').css({
    //                 'font-weight': 'bold',
    //                 'color' : 'red'
    //             });
    //         event.preventDefault();
    //     }
    // });

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



