

    let loginForm = $('.enter_form');
    let regForm = $('.registration_form');
    let auction = $('.auction');
    let resultRegistration = $('.resultRegistration');
    let username = $('.enterUsername');
    let email = $('.enterEmail');

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
        let psw = $(this).parent().parent().find('input[name="psw"]');
        let password = $('.enterPassword').val();
        let psw_repeat = $('.enterRepeatPassword').val();
        let pswRepeat = $(this).parent().parent().find('input[name="psw-repeat"]');
        let passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,20}$/;
        if (username.val().length<3){
            username.focus();
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
        
        $('.reg_container').css('display','none');
        $('.registration_form').addClass('success-login');
        $('#img_loading').css('display','block');
        event.preventDefault();
            $.ajax({
                url: 'http://localhost:8080/registrationUser',
                type: 'post',
                data: {username, email, password, psw_repeat},
                dataType: 'text',

                success: function (result) {
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
        }
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

    $('.products_list').on('click', () => {
        $('.category-list').toggleClass('hidden')
    });

    $('.category-list-parent').on('mouseover', ()=> {
       $(this).next().toggleClass('hidden')
    });






