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

        // sendKey.toggleClass('sendKey');
    });

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
                console.log(result)
            },
            error: function (error) {

            }

        })
    });

    $('#settings').on('click', function () {
        userEmail.empty();
        $('.resultUserPhone').empty();
        $('.resultUserName').empty();
        $.ajax({
            url: 'http://localhost:8080/getCurrent_Email_Phone_Username',
            type: 'get',
            success: function (result) {
                let array = [];
                $.each(result, function(key, value) {
                    array.push(value);
                });
                console.log(array[1]);
                    userEmail.append(array[0]);
                    $('.resultUserPhone').append(array[1]);
                    $('.resultUserName').append(array[2]);

            }
        });
    });


    $('.inputChangePhone').keyup(function(){
        if($(this).val().length > 0) {
            $('.saveChangePhone').removeAttr('disabled');
        } else {
            $('.saveChangePhone').attr('disabled','disable');
        }
    });


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
               // console.log(error)
           }
       })
    });



  //     ------------------------------------------        pasha end


