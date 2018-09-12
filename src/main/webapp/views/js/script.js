

    let loginForm = $('.enter_form');
    let regForm = $('.registration_form');
    let auction = $('.auction');
    let sendKey = $('.sendKey');




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
    });

    $('.close').on('click',function () { // close login & registr form
        loginForm.css('display', 'none');
        regForm.css('display', 'none');
        auction.removeClass('blur');
    });

    $('.btn_alt_reg').on('click', function () { //open reg form from login form
        loginForm.css('display', 'none');
        regForm.css('display', 'block');
    });

    // pasha change

    // let forgot = $('.forgot_psw_css');
    // let enterKey = $('.enterKeyfromEmail_inp');
    // let enterKey_btn = $('.enterKeyfromEmail_btn');
    //
    $('.forgot_div').on('click', function () { // for change password if forgot
        sendKey.toggleClass('sendKey')
    });

    sendKey.on('click', function () {
        $('.forgot_psw_css').removeClass('forgot_psw_css')

    });



    // $('.sendKey').on('click', function () {
    //     enterKey.css('display', 'block');
        // enterKey_btn.css('display', 'block');
    // });

    sendKey.on('click', function (event){
        sendKey.toggleClass('sendKey');
            event.preventDefault();
            $.ajax({
                url: 'http://localhost:8080/sendKeys' ,
                type: 'POST',
                // data:

                success: function(result){
                    console.log(result)
                },
                error: function (error) {
                    console.log("jjhk")
                }
            });

        });

