    //
    // let changeEmail = $('.ChangeEmail'); /*pasha*/
    // let loginForms = $('.login_form');

        let saveChangePassword = $('.saveChangePassword');
        // let resultChangePassword = $('.resultChangePassword');


    let optionList = $('.options-list li');
    let optionListShow = $('.option-list-show div');
    optionList.on('click', function () {
        for (let i = 0; i < optionList.length; i++) {
            optionList[i].style.borderBottom = 1 +'px solid gray';
        }
        $(this).css('border-bottom', 'none');

        for (let j = 0; j < optionListShow.length; j++){
            optionListShow[j].classList.add('hidden')

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
       /* if ($(this).attr('id') === 'sell') {
            $('.sell').css('display', 'block');
        } else if ($(this).attr('id') === 'buy') {
            $('.buy').css('display', 'block');
        } else if ($(this).attr('id') === 'history') {
            $('.history').css('display', 'block');
        }else if ($(this).attr('id') === 'settings') {
            $('.settings').css('display', 'block');
        }else if ($(this).attr('id') === 'balans') {
            $('.balans').css('display', 'block');
        }else if ($(this).attr('id') === 'mesagges') {
            $('.mesagges').css('display', 'block');
        }*/
    });

    optionList.first().css('border-bottom', 'none');

                                         // ne vudalyatu!!!!!     -----------                pasha start

                                         //            change email
    let saveChangeEmail = $('.saveChangeEmail');
    let userEmail = $('.userEmail');

    (saveChangeEmail).on('click', function (event){
        // event.preventDefault();
        let email = $('.changeEmail').val();
        userEmail.empty();
        $.ajax({
            url: 'http://localhost:8080/change_Email',
            type: 'put',
            data: email,
            contentType: 'text/plain',

            success: function(result){
                    userEmail.append(result);
            },
            error: function (error) {
                console.log("error")
            }
        });

});                 //.............................*change email end*/


                                        //          change password

    saveChangePassword.on('click',function (event) {
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
    });                 //..............................*change password       end*/


                        //                             change phone

    $('.saveChangePhone').on('click', function (event) {
        let val = $('.inputChangePhone').val();
        $('.resultUserPhone').empty();

        $.ajax({
            url: 'http://localhost:8080/changeUserPhone',
            type: 'put',
            data: val,

            success: function (result) {

                $('.resultUserPhone').append(result)

            },
            error: function (error) {
            }
        })
    });                 //............................ change phone end

//------------------        save first name     start
    $('.saveFirstName').on('click',function () {
        let val = $('.inputFirstName').val();
        $('.resultFirstName').empty();
        $.ajax({
            url: 'http://localhost:8080/saveFirstName',
            type: 'put',
            data: val,
            dataType: 'text',

            success: function (result) {
                $('.resultFirstName').append(result)
            },
            error: function (error) {
              console.log(error)
            }
        })
    });
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxx save first name end

    //................................save surname start
    $('.saveSurName').on('click',function () {
        let val = $('.inputSurNameUser').val();
        $('.resultSurName').empty();
        $.ajax({
            url: 'http://localhost:8080/saveSurName',
            type: 'put',
            data: val,
            dataType: 'text',

            success: function (result) {
                $('.resultSurName').append(result)
            },
            error: function (error) {
                console.log(error)
            }
        })
    });
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx save surname end


    //.....................................save postAddress  start
     $('.savePostAddress').on('click',function () {
        let val = $('.inputPostAddress').val();
        $('.resultPostAddress').empty();
        $.ajax({
            url: 'http://localhost:8080/savePostAddress',
            type: 'put',
            data: val,
            dataType: 'text',

            success: function (result) {
                $('.resultPostAddress').append(result)
            },
            error: function (error) {
                console.log(error)
            }
        })
    });
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx   save postAddress end

                        //                  заповнення сторінки користувача полями з БД     start

    $('#settings').on('click', function () {
        userEmail.empty();
        $('.resultUserPhone').empty();
        $('.resultUserName').empty();
        $.ajax({
            url: 'http://localhost:8080/getCurrent_Email_Phone_Username',
            type: 'get',
            success: function (result) {

                $.each(result, function(key, value) {
                    if(key==="username"){
                        $('.resultUserName').append(value);
                    }
                    if(key==="email"){
                        userEmail.append(value);
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
                });
            }
        });
    });             //................................заповнення сторінки користувача полями з БД       end


    $('.inputChangePhone').keyup(function(){
        if($(this).val().length > 0) {
            $('.saveChangePhone').removeAttr('disabled');
        } else {
            $('.saveChangePhone').attr('disabled','disable');
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





