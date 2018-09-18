// categoryStaticList

$('.btn_Category').on('click',function () {
    // $('.categoryHandleList').css('display','block');
    $.ajax({
        url: 'http://localhost:8080/upBD',
        type: 'get',
        // data: status,

        success: function (result) {
            console.log(result)
        },
        error: function (error) {

        }
    })
});

// sendKey.on('click', function (event){
//     sendKey.toggleClass('sendKey');
//     event.preventDefault();
//     $.ajax({
//         url: 'http://localhost:8080/sendKeys' ,
//         type: 'POST',
//         // data:
//
//         success: function(result){
//             console.log(result)
//         },
//         error: function (error) {
//             console.log("jjhk")
//         }
//     });
//
// });

// $('.btn_Category')