///windows switch
    let optionList = $('.options-list li');
    let optionListShow = $('.slider');
    $('.settings').toggleClass('hidden');
    optionList.on('click', function () {
        for (let i = 0; i < optionList.length; i++) {
            optionList[i].style.borderBottom = 1 +'px solid gray';
        }
        $(this).css('border-bottom', 'none');

        for (let opt of optionListShow) {
            if (opt.classList.contains("settings")){
                console.log("popop");
            }
            opt.classList.add('hidden')
        }

        if ($(this).attr('id') === 'sell') {
            $('.sell-item').toggleClass('hidden');
        } else if ($(this).attr('id') === 'buy') {
            $('.buy').toggleClass('hidden');
        } else if ($(this).attr('id') === 'history') {
            $('.history').toggleClass('hidden');
        }else if ($(this).attr('id') === 'settings') {
            $('.settings').toggleClass('hidden');
        }else if ($(this).attr('id') === 'balans') {
            $('.balans').toggleClass('hidden');
        }else if ($(this).attr('id') === 'mesagges') {
            $('.mesagges').toggleClass('hidden');
        }
    });

    optionList.first().css('border-bottom', 'none');


let $changeEmail = $('.changeEmail');
let $saveChangeEmail = $('.saveChangeEmail');
let $saveChangePassword = $('.saveChangePassword');
let $send = $('.send-key');
let $verification1 = $('.verification-email-1');
let $verification2 = $('.verification-email-2');

             /// sel category

    $saveChangePassword.on('click',function (event) {
        event.preventDefault();
        let resultChangePassword = $('.resultChangePassword');
        resultChangePassword.empty();
        let oldPassword = $('.oldPassword').val();
        let password = $('.password').val();
        let repeatPassword = $('.repeatPassword').val();
        $.ajax({
            url: 'http://localhost:8080/change_Password',
            type: 'post',
            data: {oldPassword, password, repeatPassword},
            dataType: 'text',

            success: function (result) {
                resultChangePassword.append(result);
            },
            error: function (error) {

            }

        })
    });                 //..............................*change password  end*/


                        //                             change phone

    $('.saveChangePhone').on('click', function (event) {
        $('.resultChangePhone').empty();
        let val = $('.inputChangePhone').val();
        $('.resultUserPhone').empty();

        $.ajax({
            url: 'http://localhost:8080/changeUserPhone',
            type: 'put',
            data: val,

            success: function (result) {

                $('.resultUserPhone').append(result);
                $('.resultChangePhone').append("change phone - success")

            },
            error: function (error) {
            }
        })
    });

    //............................
let email;   // for change email, empty than (always)
$send.on('click',function () {
        email = $('.changeEmail').val();
        $.ajax({
            url: 'http://localhost:8080/sendKeys',
            data: email,
            type: 'put',
            success: function(){
                console.log("success");
                $verification2.removeClass('hidden');
                $verification1.addClass('hidden');
            }
        })
    });

$saveChangeEmail.on('click',function (event) {
    event.preventDefault();
    let randomKey = $('.enter-key').val();
    $('.userEmail').empty();
    // let randomKey = JSON.stringify("key", key);
    // let email = JSON.stringify("email", mail);

    $.ajax({
        url: 'http://localhost:8080/change_Email',
        type: 'post',
        data: {randomKey, email},
        dataType: 'text',

        success: function (result) {
            $('.userEmail').append(email);
            $('.resultChangeEmail').append(result);
            $verification1.removeClass('hidden');
            $verification2.addClass('hidden');
        },
        error: function (error) {
            // $verification1.removeClass('hidden');
            // $verification2.addClass('hidden');
            $('.resultChangeEmail').append("error enter email");
            console.log(error)
        }
    })
});

//------------------        save first name     start
    $('.saveFirstName').on('click',function () {
        $('.resultChangeName').empty();
        let val = $('.inputFirstName').val();
        $('.resultFirstName').empty();
        $.ajax({
            url: 'http://localhost:8080/saveFirstName',
            type: 'put',
            data: val,
            dataType: 'text',

            success: function (result) {
                $('.resultFirstName').append(result);
                $('.resultChangeName').append("change name - success")
            },
            error: function (error) {
              console.log(error)
            }
        })
    });
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxx save first name end

    //................................save surname start
    $('.saveSurName').on('click',function () {
        $('.resultChangeSurName').empty();
        let val = $('.inputSurNameUser').val();
        $('.resultSurName').empty();
        $.ajax({
            url: 'http://localhost:8080/saveSurName',
            type: 'put',
            data: val,
            dataType: 'text',

            success: function (result) {
                $('.resultSurName').append(result);
                $('.resultChangeSurName').append("change surname - success")
            },
            error: function (error) {
                console.log(error)
            }
        })
    });
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx save surname end


    //.....................................save postAddress  start
     $('.savePostAddress').on('click',function () {
         $('.resultChangePostAddress').empty();
         $('.resultPostAddress').empty();
         $('.resultCountry').empty();
         $('.resultCity').empty();
         $('.resultState').empty();
        let address = $('.inputPostAddress').val();
        let country = $('.countries').val();
        let state = $('.states').val();
        let cities = $('.cities').val();
        $.ajax({
            url: 'http://localhost:8080/savePostAddress',
            type: 'post',
            data: {address, country, cities, state},
            dataType: 'text',

            success: function (result) {
                $('.resultPostAddress').append(address);
                $('.resultCountry').append(country+", ");
                $('.resultCity').append(cities+", ");
                $('.resultState').append(state+", ");
                $('.resultChangePostAddress').append("change location - success")
            },
            error: function (error) {
                console.log(error)
            }
        })
    });
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx   save postAddress end

                        //                  заповнення сторінки користувача полями з БД     start

    $('#settings').on('click', function () {
        $('.userEmail').empty();
        $('.resultUserPhone').empty();
        $('.resultUserName').empty();
        $('.resultFirstName').empty();
        $('.resultSurName').empty();
        $('.resultPostAddress').empty();
        $('.resultCountry').empty();
        $('.resultCity').empty();
        $('.resultState').empty();
        $.ajax({
            url: 'http://localhost:8080/allInfoAboutUser',
            type: 'get',
            success: function (result) {

                $.each(result, function(key, value) {
                    if(key==="about"){
                        $(".text-area").val(value);
                    }
                    if(key==="username"){
                        $('.resultUserName').append(value);
                    }
                    if(key==="email"){
                        $('.userEmail').append(value);
                    }
                    if(key==="phone"){
                        $('.resultUserPhone').append(value);
                    }
                    if(key==="firstname"){
                        $('.resultFirstName').append(value);
                    }
                    if (key==="surname"){
                        $('.resultSurName').append(value);
                    }
                    if(key==="postadsress"){
                        $('.resultPostAddress').append(value);
                    }
                    if (key === "country") {
                        $('.resultCountry').append(value + ", ");
                    }
                    if(key==="city"){
                        $('.resultCity').append(value+", ");
                    }
                    if(key==="state"){
                        $('.resultState').append(value+", ");
                    }
                    if(key==="postAddress"){
                        $('.resultPostAddress').append(value);
                    }
                });
            }
        });
    });             //................................заповнення сторінки користувача полями з БД       end

    $('.saveAboutMe').on('click',function () {
        $('.resultChangeAboutMe').empty();
       let val = $('.text-area').val();
       $.ajax({
           url: 'http://localhost:8080/changeAboutMe',
           data: val,
           type: 'put',
           dataType: 'text',
           success: function (success) {
               $('.resultChangeAboutMe').append(success);
           },
           error: function (error) {
               $('.resultChangeAboutMe').append(error);
           }
       })
    });

    $('.inputChangePhone').keyup(function(){
        if($(this).val().length > 0) {
            $('.saveChangePhone').removeAttr('disabled');
        } else {
            $('.saveChangePhone').attr('disabled','disable');
        }
    });

    $changeEmail.keyup(function(){
        if($(this).val().length > 0) {
            $('.resultChangeEmail').empty();
            $('.send-key').removeAttr('disabled');
        } else {
            $('.send-key').attr('disabled','disable');
        }
    });

( $('.repeatPassword')).keyup(function () {
    $('.resultChangePassword').empty();
    if($(this).val().length > 0 ) {
        $('.saveChangePassword').removeAttr('disabled');
    } else {
        $('.saveChangePassword').attr('disabled','disable');
    }
});

$changeEmail.keyup(function(){
    if($(this).val().length > 0) {
        $('.resultChangeEmail').empty();
        $('.saveChangeEmail').removeAttr('disabled');
    } else {
        $('.saveChangeEmail').attr('disabled','disable');
    }
});


    $('.inputFirstName').keyup(function(){
        if($(this).val().length > 0) {
            $('.saveFirstName ').removeAttr('disabled');
        } else {
            $('.saveFirstName ').attr('disabled','disable');
        }
    });

    $('.inputSurNameUser').keyup(function(){
        if($(this).val().length > 0) {
            $('.saveSurName ').removeAttr('disabled');
        } else {
            $('.saveSurName ').attr('disabled','disable');
        }
    });

    $('.inputPostAddress').keyup(function(){
        if($(this).val().length > 0) {
            $('.savePostAddress ').removeAttr('disabled');
        } else {
            $('.savePostAddress ').attr('disabled','disable');
        }
    });

    $('.text-area').keyup(function(){
        if($(this).val().length > 5) {
            $('.saveAboutMe ').removeAttr('disabled');
        } else {
            $('.saveAboutMe ').attr('disabled','disable');
        }
    });





