

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
    
    $('.signupbtn').on('click', function (event) {      //password validation
        // let psw = $(this).parent().parent().find('input[name="psw"]');
        // let pswRepeat = $(this).parent().parent().find('input[name="psw-repeat"]');
        // var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,20}$/;
        // if (psw.val() != pswRepeat.val()){
        //     pswRepeat.val('');
        //     pswRepeat.prop('placeholder',"ПАРОЛІ НЕ ЗБІГАЮТЬСЯ!!!")
        //     event.preventDefault();
        // } else if (!psw.val().match(passw)){
        //     psw.focus();
        //     psw.val('');
        //     $(this).parent().parent().find('#psw-must-have').css({
        //             'font-weight': 'bold',
        //             'color' : 'red'
        //         });
        //     event.preventDefault();
        // }

        //rest security -------------------------pasha start
        $('.resultRegistration').empty();
        let username = $('.enterUsername').val();
        let email = $('.enterEmail').val();
        let password = $('.enterPassword').val();
        let psw_repeat = $('.enterRepeatPassword').val();
        event.preventDefault();
        $.ajax({
            url: 'http://localhost:8080/registrationUser',
            type: 'post',
            data: {username, email, password, psw_repeat},
            dataType: 'text',

            success: function (result) {

              $('.resultRegistration').append(result)
            },
            error: function (error) {
                console.log(error)
            }
        })
    });        //-----------------------------------------------pasha end

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

    // let countDownDate = 11111111111110;
    // let countDownDate = new Date("Oct 30, 2018 15:37:25").getTime();
    //
    // let x = setInterval(function() {
    //
    //     let now = new Date().getTime();
    //
    //     let distance = countDownDate - now;
    //     // console.log($('#test').innerHTML);
    //
    //     // console.log(distance);
    //     let days = Math.floor(distance / (1000 * 60 * 60 * 24));
    //     let hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    //     let minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    //
    //     let seconds = Math.floor((distance % (1000 * 60)) / 1000);
    //
    //     document.getElementById("timer").innerHTML = days + "дн " + hours + "г "
    //         + minutes + "хв " + seconds + "с";
    //     if (distance < 0) {
    //         clearInterval(x);
    //         document.getElementById("timer").innerHTML = "EXPIRED";
    //     }
    // }, 1000);

    // rest security





