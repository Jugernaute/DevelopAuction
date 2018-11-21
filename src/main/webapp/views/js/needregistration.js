let registrationForm = $('.registration_form');
let enterForm = $('.enter_form');

$('.btn_alt_reg').on('click',function () {
   enterForm.css('display','none');
   registrationForm.css('display', 'block');
    console.log("ok");
});
