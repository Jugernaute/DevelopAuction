$('.list_page').on('click','.a_page',function (e) {
    e.preventDefault();
    // $(this).find('a').css('background','chartreuse');
    $('.list_page').find('a').removeClass('page_btn_color');
    $(this).find('a').addClass('page_btn_color');
    let el = $(this).find('a').text();
    $.ajax({
        url: '/subcategories/page',
        data: {page : el},
        type: 'get',
        contentType: 'application/json',
        success: function (result) {
            $('.main .container .panel-body .row:last-child').empty();
            $.each(result, function (k, v) {
                let obj =
                '<div class = "col-md-2"><span>'+v.id_SubCategory+ '</span></div>' +
                '<div class = "col-md-4"><span>' + v.nameSubCategory + '</span></div>' +
                '<div class = "col-md-6"><a href = "/subcategories/delete/' + v.id_SubCategory + '" class = "btn btn-danger form-control" > delete</a></div>';
                $('.main .container .panel-body .row:last-child').append(obj);
            })
        }
    })
});

// $('.previous').on('click', function (e) {
//     e.preventDefault();
//
//     let currentPage = $('.page_btn_color').text();
//     // console.log(currentPage);
//     // console.log($('.list_page').find('li:nth-child(currentPage)'));
//     let previousPage = $('.list_page').find('li:nth-child(currentPage)').addClass('page_btn_color');
//     // console.log(previousPage);
//
//     $('.list_page').find('a').removeClass('page_btn_color');
//     $.ajax({
//         url: '/subcategories/previous/'+currentPage,
//         success: function (result) {
//             // previousPage.addClass('page_btn_color');
//             $('.main .container .panel-body .row:last-child').empty();
//             $.each(result, function (k, v) {
//                 let obj =
//                     '<div class = "col-md-2"><span>'+v.id_SubCategory+ '</span></div>' +
//                     '<div class = "col-md-4"><span>' + v.nameSubCategory + '</span></div>' +
//                     '<div class = "col-md-6"><a href = "/subcategories/delete/' + v.id_SubCategory + '" class = "btn btn-danger form-control" > delete</a></div>';
//                 $('.main .container .panel-body .row:last-child').append(obj);
//             })
//         }
//     })
//
// });