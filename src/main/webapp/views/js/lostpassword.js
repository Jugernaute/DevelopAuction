let enterPsw = $('.lost-password_enter-password');
let passKey = $('.lost-password_check-email');
let saveNewPsw = $('.lost-password_new-password');
let email="";

$('#lost-password_send').on('click', function () {
     email = $('#curent_email').val();

    $.ajax({
       url: 'http://localhost:8080/sendKeys',
        type:'put',
        data: email,
        contentType: 'text/plain',
        success: function (result) {
            console.log("ok")
        }
    });


    if (/\S+@\S+\.\S+/.test(email)) {
            enterPsw.toggleClass('hidden');
            passKey.toggleClass('hidden');
            setTimeout(function () {
                $('#lost-password_send-again').toggleClass('hidden');
            },5000)
    } else {
        enterPsw.find('p').remove();
        enterPsw.append('<p>try again</p>')
    }
});


$('#lost-password_send-again').on('click', function () {
    let email = $('#curent_email').val();

    $.ajax({
        url: 'http://localhost:8080/sendKeys',
        type: 'put',
        data: email,
        contentType: 'text/plain',
        success: function (result) {
            console.log("ok")
        }
    });
});


$('#lost-password_ok').on('click', function () {
    let randomStr = $('.number_lost-psw').val();
    $.ajax({
       url:'http://localhost:8080/enterKey',
        type:'post',
        data: {randomStr, email},
        success: function (result) {
           console.log(result);
            if(result=="ok")
            {
                console.log("ok");
                passKey.toggleClass('hidden');
                saveNewPsw.toggleClass('hidden');
            }
        },
        error: function () {
           console.log("error");

        }
    });
});

///^[A-Za-z\s]+$/.test(name) && /\S+@\S+\.\S+/.test(email)

$('.lost-password_submit').on('click', function (event) {      //password validation
    let psw = $(this).parent().find('input[name="password"]');
    let pswRepeat = $(this).parent().find('input[name="repeatPassword"]');
    let passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,20}$/;
    let password = psw.val();
    let repeatPassword = pswRepeat.val();

    if (password !== repeatPassword){
        pswRepeat.val('');
        pswRepeat.prop('placeholder',"ПАРОЛІ НЕ ЗБІГАЮТЬСЯ!!!");
        event.preventDefault();
    } else if (!password.match(passw)){
        psw.focus();
        psw.val('');
        $(this).parent().find('#psw-must').css({
            'font-weight': 'bold',
            'color' : 'red'
        });
        event.preventDefault();
    }
    else{
        $.ajax({
            url:'http://localhost:8080/enter-lost_Password',
            type: 'post',
            data: {password, repeatPassword, email},
            success: function (result) {
                $('.resultPsw').append('<p style="color: green; font-size: 200%">' + result + '<p>')
                $('.lost-password_new-password').toggleClass('hidden');
                $('.mainPage').css('display', 'block')
            },
            error: function (error) {
                console.log("error")
            }
        })
    }
    email="";
});