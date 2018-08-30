

    var modal = $('.enter_form');
    var btn = $('.enter');
    var span = $('.close');

    btn.on('click', function () {
        modal.css('display', 'block')
    });
    span.on('click',function () {
        modal.css('display', 'none')
    })
    $(window).on('click', function (event) {
        console.log('sdfgse');
        if (event.target == modal) {
            modal.css('display', 'none')
        }
    })


