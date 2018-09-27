<%--
  Created by IntelliJ IDEA.
  User: adminx
  Date: 18.09.2018
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body>

<%--<form action="/addproduct" method="pust" id="my_form" enctype="multipart/form-data">--%>
<button id="allproduct">allProduct</button>
<input type="text" id="nameProduct" placeholder=""/>
<input type="text" id="modelProduct" placeholder=""/>
<input type="file" id="file" multiple="multiple" placeholder=""/>
<input type="text" id="descriptionProduct" placeholder=""/>
<input type="text" id="id_Manufacturer" placeholder=""/>
<input type="text" id="id_SubCategory" placeholder=""/>
<input type="text" id="userId" placeholder=""/>
<button id="addproduct">addProduct</button><br>
<%--</form>--%>

<button id="alldelivery">alldelivery</button>
<input type="" id="methodDelivery" placeholder="">
<button id="adddelivery">addDelivery</button><br>

<button id="allbet">allbet</button>
<input type="text" id="sum_of_the_bet" placeholder="">
<input type="text" id="stepBet" placeholder="">
<input type="text" id="id_Lot" placeholder="">
<input type="text" id="userId1" placeholder="">
<button id="addbet">addbet</button><br>

<button id="allCommonCategory">allCommonCategory</button>
<input type="text" id="nameCommonCategory" placeholder="">
<button id="addCommonCategory">addCommonCategory</button><br>

<button id="allSubCategory">allSubCategory</button>
<input type="text" id="nameSubCategory" placeholder="">
<input type="text" id="id_CommonCategory" placeholder="">
<button id="addSubCategory">addSubCategory</button><br>

<button id="allManufacturer">allManufacturer</button>
<input type="text" id="nameManufacturer" placeholder="">
<button id="addManufacturer">addManufacturer</button><br>

<button id="allPayment">allPayment</button>
<input type="text" id="methodPayment" placeholder="">
<button id="addPayment">addPayment</button><br>

<button id="allLot">allLot</button>
<input type="text" id="dataStartLot" placeholder="">
<input type="text" id="dataEndLot" placeholder="">
<input type="text" id="startPrice" placeholder="">
<input type="text" id="hotPrice" placeholder="">
<input type="text" id="id_Delivery" placeholder="">
<input type="text" id="id_Payment" placeholder="">
<input type="text" id="id_Product" placeholder="">
<button id="addLot">addLot</button><br>

<button id="allUser">allUser</button>
<input type="text" id="firstNameUser" placeholder="">
<input type="text" id="surNameUser" placeholder="">
<input type="text" id="userBalance" placeholder="">
<input type="text" id="userPostAddress" placeholder="">
<button id="addUser">addUser</button><br>

<div id="conversationDiv"></div>
<script>

    /////////////////   User            //////////////

    $('#addUser').click(function () {
        $("#conversationDiv").empty();

        let $x = $('#firstNameUser');
        let firstNameUser = $x.val();
        $x.val(' ');
        let $x1 = $('#surNameUser');
        let surNameUser = $x1.val();
        $x1.val(' ');
        let $x2 = $('#userBalance');
        let userBalance = $x2.val();
        $x2.val(' ');
        let $x3 = $('#userPostAddress');
        let userPostAddress = $x3.val();
        $x3.val(' ');
        let user = JSON.stringify({firstNameUser, surNameUser, userBalance, userPostAddress});
        $.ajax({
            url : '/addUser',
            type : 'put',
            contentType : 'application/json',
            data : user,
            dataType : 'json'
        })
    })

    $('#allUser').click(function () {
        $("#conversationDiv").empty();

        $.ajax({
            url : '/allUser',
            type : 'get',
            contentType : 'application/json',
            success : function (result) {
                for (let obj of result) {
                    let user = $('<div/>', {text : obj.firstNameUser + ' ' + obj.surNameUser + ' ' + obj.userBalance + ' ' + obj.userPostAddress});
                    user.appendTo('#conversationDiv');
                }
            },
            error : function (error) {
                console.log(error);
            }
        })
    })
    /////////////////    Lot            //////////////

    $('#addLot').click(function () {
        $("#conversationDiv").empty();

        let $x = $('#dataStartLot');
        let dataStartLot = $x.val();
        $x.val(' ');
        let $x1 = $('#dataEndLot');
        let dataEndLot = $x1.val();
        $x1.val(' ');
        let $x2 = $('#startPrice');
        let startPrice = $x2.val();
        $x2.val(' ');
        let $x3 = $('#hotPrice');
        let hotPrice = $x3.val();
        $x3.val(' ');
        let $x4 = $('#id_Delivery');
        let id_Delivery = $x4.val();
        $x4.val(' ');
        let $x5 = $('#id_Payment');
        let id_Payment = $x5.val();
        $x5.val(' ');
        let $x6 = $('#id_Product');
        let id_Product = $x6.val();
        $x6.val(' ');
        let lot = JSON.stringify({dataStartLot, dataEndLot, startPrice, hotPrice, id_Delivery, id_Payment, id_Product});
        $.ajax({
            url : '/addLot?id_Delivery=' + id_Delivery + '&id_Payment=' + id_Payment + '&id_Product=' + id_Product,
            type : 'put',
            contentType : 'application/json',
            data : lot,
            dataType : 'json'
        })
    })
    $('#allLot').click(function () {
        $("#conversationDiv").empty();

        $.ajax({
            url : '/allLot',
            type : 'get',
            contentType : 'application/json',
            success : function (result) {
                for (let obj of result) {
                    let lot = $('<div/>', {text : obj.dataStartLot + ' ' + obj.dataEndLot + ' ' + obj.startPrice + ' ' + obj.hotPrice + ' ' + obj.id_Product + ' ' + obj.id_Payment + ' ' + obj.id_Delivery});
                    lot.appendTo('#conversationDiv');
                }
            },
            error : function (error) {
                console.log(error);
            }
        })
    })

    /////////////////    Payment         ////////////

    $('#addPayment').click(function () {
        $("#conversationDiv").empty();

        let $x = $('#methodPayment');
        let methodPayment = $x.val();
        $x.val(' ');
        let payment = JSON.stringify({methodPayment});
        $.ajax({
            url : '/addPayment',
            type : 'put',
            contentType : 'application/json',
            data : payment,
            dataType : 'json'
        })
    })
    $('#allPayment').click(function () {
        $("#conversationDiv").empty();

        $.ajax({
            url : '/allPayment',
            type : 'get',
            contentType : 'application/json',
            success : function (result) {
                for (let obj of result) {
                    let payment = $('<div/>', {text : obj.methodPayment});
                    payment.appendTo('#conversationDiv');
                }
            },
            error : function (error) {
                console.log(error);
            }
        })
    })

    /////////////////   Manufacturer    ///////////////

    $('#addManufacturer').click(function () {
        $("#conversationDiv").empty();

        let $x = $('#nameManufacturer');
        let nameManufacturer = $x.val();
        $x.val(' ');
        let manufacturer = JSON.stringify({nameManufacturer});
        $.ajax({
            url : '/addManufacturer',
            type : 'put',
            contentType : 'application/json',           // отримуєм
            data : manufacturer,
            dataType: 'json'          //передаєм
        })
    })
    $('#allManufacturer').click(function () {
        $("#conversationDiv").empty();

        $.ajax({
            url : '/allManufacturer',
            type : 'get',
            contentType : 'application/json',
            success : function (result) {
                for (let obj of result) {
                    let manufacturer = $('<div/>', {text : obj.nameManufacturer});
                    manufacturer.appendTo('#conversationDiv');
                }
            },
            error : function (error) {
                console.log(error);
            }
        })
    })

    ////////////////   SubCategory    ///////////////

    $('#addSubCategory').click(function () {
        $("#conversationDiv").empty();

        let $x = $('#nameSubCategory');
        let nameSubCategory = $x.val();
        $x.val(' ');
        let $x1 = $('#id_CommonCategory');
        let id_CommonCategory = $x1.val();
        $x1.val(' ');
        let subCategory = JSON.stringify({nameSubCategory});
        $.ajax({
            url : '/addSubCategory?id_CommonCategory='+id_CommonCategory,
            type : 'put',
            contentType : 'application/json',
            data : subCategory
        })
    })
        $('#allSubCategory').click(function () {
            $("#conversationDiv").empty();

            $.ajax({
                url : '/allSubCategory',
                type : 'get',
                contentType : 'application/json',
                success : function (result) {
                    for (let obj of result) {
                        let subCategory = $('<div/>', {text : obj.nameSubCategory});
                        subCategory.appendTo('#conversationDiv');
                    }
                },
                error : function (error) {
                    console.log(error);
                }
            })
        })

    ///////////////   CommonCategory   ///////////////////

    $('#addCommonCategory').click(function () {
        $("#conversationDiv").empty();

        let $input = $('#nameCommonCategory');
        let nameCommonCategory = $input.val();
        $input.val(' ');
        let commonCategory = JSON.stringify({nameCommonCategory});
        $.ajax({
            url : '/addCommonCategory',
            type : 'put',
            contentType : 'application/json',
            data : commonCategory
        })
    })
    $('#allCommonCategory').click(function () {
        $("#conversationDiv").empty();

        $.ajax({
            url : '/allCommonCategory',
            type : 'get',
            contentType : 'application/json',
            success : function (result) {
                for (let obj of result) {
                    let commonCategory = $('<div/>', {text : obj.nameCommonCategory});
                    commonCategory.appendTo('#conversationDiv');
                }
            },
            error : function (error) {
                console.log(error);
            }
        })
    })

    ///////////////////   BET   /////////////////////////

    $('#addbet').click(function () {
        $("#conversationDiv").empty();

        let $input = $('#sum_of_the_bet');
        let sum_of_the_bet = $input.val();
        $input.val(' ');
        let $input1 = $('#stepBet');
        let stepBet = $input1.val();
        $input1.val(' ');
        let $input2 = $('#id_Lot');
        let id_Lot = $input2.val();
        $input2.val(' ');
        let $input3 = $('#userId1');
        let userId1 = $input3.val();
        $input3.val(' ');
        let bet = JSON.stringify({sum_of_the_bet, stepBet, id_Lot, userId1});
        $.ajax({
            url : '/addBet?id_Lot=' + id_Lot + '&userId=' + userId1,
            type : 'put',
            contentType : 'application/json',
            data : bet
        })
    })

    $('#allbet').click(function () {
        $("#conversationDiv").empty();

        $.ajax({
            url : '/allBet',
            type : 'get',
            contentType : 'application/json',
            success : function (result) {
                for (let obj of result) {
                    let bet = $('<div/>', {text : obj.sum_of_the_bet + ' ' + obj.stepBet + ' ' + obj.id_Lot + ' ' + obj.userId1});
                    bet.appendTo('#conversationDiv');
                }
            },
            error : function (error) {
                console.log(error);
            }
        })
    })

///////////////////    DELIVERY        /////////////////////////////////

    $('#adddelivery').click(function () {
        $("#conversationDiv").empty();

        let $input = $('#methodDelivery');
        let methodDelivery = $input.val();
        $input.val(' ');
        let delivery = JSON.stringify({methodDelivery});
        $.ajax({
            url: '/addDelivery',
            type: 'put',
            contentType : 'application/json',    //отримуєм
            data: delivery,
            // dataType: 'json'
            // success: function (result) {
            //     console.log(result);
            //     for (let obj of result) {
            //         let $div = $('<div/>', {text: obj.methodDelivery});
            //         $div.appendTo($("#conversationDiv"));
            //     }
            // },
            // error: function (error) {
            //     console.log(error);
            // }
        })

    })

    $("#alldelivery").click(function () {
        $("#conversationDiv").empty();

        $.ajax({
            url : '/allDelivery',
            type : 'get',
            contentType : 'application/json',
            // data :'data',
            success : function (result) {
                console.log(result);
                for (let obj of result) {
                    let delivery = $('<div/>', {text: obj.methodDelivery});
                    delivery.appendTo($("#conversationDiv"));
                }
            },
            error : function (error) {
                console.log(error);
            }


        })
    })

   //////////////////       PRODUCT      ////////////////////////////////


    $("#addproduct").click(function () {
        $("#conversationDiv").empty();

        let product = new FormData();

        let $x = $("#nameProduct");
        let nameProduct = $x.val();
        $x.val(' ');
        let $x1 = $("#modelProduct");
        let modelProduct = $x1.val();
        $x1.val(' ');

        var linkOnImageProduct;
        $('input[type=file]').change(function(){
            linkOnImageProduct = this.linkOnImageProduct;
            console.log(linkOnImageProduct);
        });

        // let $x2 = $("#linkOnImageProduct");
        // let linkOnImageProduct = $x2.val();
        // $x2.val(' ');
        let $x3 = $("#descriptionProduct");
        let descriptionProduct = $x3.val();
        $x3.val(' ');
        let $x4 = $("#id_Manufacturer");
        let id_Manufacturer = $x4.val();
        $x4.val(' ');
        let $x5 = $("#id_SubCategory");
        let id_SubCategory = $x5.val();
        $x5.val(' ');
        let $x6 = $("#userId");
        let userId = $x6.val();
        $x6.val(' ');

        let product = JSON.stringify({nameProduct, modelProduct, descriptionProduct, linkOnImageProduct, id_SubCategory, id_Manufacturer, userId});
console.log(product);


        $.ajax({
            url:'/addProduct?id_Manufacturer=' + id_Manufacturer + '&id_SubCategory=' + id_SubCategory + '&userId=' + userId,
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "put",
            data: product,
            processData : false,
            contentType : false,
            dataType: 'json',          //передаєм
        })
    })

$("#allproduct").click(function () {
    $("#conversationDiv").empty();

    $.ajax({
        url : '/allProduct',
        type : 'get',
        contentType : 'application/json',
        // data :'data'
        success : function (result) {
            console.log(result);
            for (let obj of result) {
                let prod = $('<div/>',{text: obj.nameProduct + " " + obj.modelProduct + " " + obj.linkOnImageProduct + " " + obj.descriptionProduct + ' ' + obj.userId + ' ' + obj.idManufacturer + ' ' + obj.idSubCategory});
                prod.appendTo($("#conversationDiv"));
            }
        },
        error : function (error) {
            console.log(error);
        }
    })
})

</script>

</body>
</html>
