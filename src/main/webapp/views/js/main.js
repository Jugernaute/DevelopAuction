

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
        let pswRepeat = $(this).parent().parent().find('input[name="psw-repeat"]');
        let passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{3,20}$/;
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
        let email = $email.val();
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
        let hotLot = $('.hot_lot');
        let nameCategory = $(this).find('a').text();
        // console.log(idCategory);
        $.ajax({
           url:'http://localhost:8080/category/'+nameCategory,
           success: function (result) {

               $.each(result, function(a, b) {
                       // hotLot.empty();
                       console.log(b);


                       //===============================================================
                       // '<li data-grid-id="' + item.CategoryId +
                       // '"><a href="#">' + item.CategoryDescription +
                       // '<span class="glyphicon glyphicon-chevron-right"></span></a></li>'
                       // hotLot.append('<li><a href="#">'+y+'</a></li>')
                       // ============================================================
                       // '<div className="hot_lot_wrapper">' +
                       //     '<div className="cont_img">' +
                       //          '<a href="lot/'+y.id_Product+'" className="get-id"><img' +
                       //          ' src="../img/product_Img/${img.getLinkOfImage()}" height="200" width="200"/></a></div>' +
                       //         '<div className="container">' +
                       //             '<h2 className="cont_titel"><b>' +
                       //             '<c:out value="${nameProd}"/>' +
                       //             '<c:out value="${modelProd}"/>' +
                       //             '<' +
                       //             '%--' +
                       //             '<c:out value="${manufProd}"/>' +
                       //             '--%></b></h2>' +
                       //         '<p className="text-end">завершення :</p>' +
                       //             '<div className="cont_timer">' +
                       //             '<c:out value="${startLot}"/>' +
                       //             '</div>' +
                       //     '<h4 className="cont_price">Ціна : <span>${curentPrice} грн.</span></h4>' +
                       //     '</div>' +
                       // '</div>'

                   });

               // });
           }
       })
    });


$('.cont_img').on('click',function () {
    let message = $(this).find('a').attr('href');
    let idProductInSession = message.replace("lot/","");
    sessionStorage.setItem("idLot",idProductInSession);
});




