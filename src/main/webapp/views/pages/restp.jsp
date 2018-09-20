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

<button id="allproduct">allProduct</button>
<input type="text" id="nameProduct" placeholder=""/>
<input type="text" id="modelProduct" placeholder=""/>
<input type="text" id="linkOnImageProduct" placeholder=""/>
<input type="text" id="descriptionProduct" placeholder=""/>
<input type="text" id="idManufacturer" placeholder=""/>
<input type="text" id="idSubCategory" placeholder=""/>
<input type="text" id="userId" placeholder=""/>
<button id="addproduct">addProduct</button>

<button id="alldelivery">alldelivery</button>
<input type="" id="methodDelivery" placeholder="">
<button id="adddelivery">addDelivery</button>

<button id="allbet">allbet</button>
<input type="text" id="sumOfTheBet" placeholder="">
<input type="text" id="stapeBet" placeholder="">
<input type="text" id="idLot" placeholder="">
<%--<input type="text" id="userId" placeholder="">--%>
<button id="addbet">addbet</button>

<button id="allCommonCategory">allCommonCategory</button>
<input type="text" id="nameCommonCategory" placeholder="">
<button id="addCommonCategory">addCommonCategory</button>

<button id="allSubCategory">allSubCategory</button>
<input type="text" id="nameSubCategory" placeholder="">
<button id="addSubCategory">addSubCategory</button>

<button id="allManufacturer">allManufacturer</button>
<input type="text" id="nameManufacturer" placeholder="">
<button id="addManufacturer">addManufacturer</button>

<button id="allPayment">allPayment</button>
<input type="text" id="mathodPayment" placeholder="">
<button id="addPayment">addPayment</button>

<button id="allLot">allLot</button>
<input type="text" id="dataStartLot" placeholder="">
<input type="text" id="dataEndLot" placeholder="">
<input type="text" id="startPrice" placeholder="">
<input type="text" id="hotPrise" placeholder="">
<input type="text" id="idDelivery" placeholder="">
<input type="text" id="idPaytment" placeholder="">
<input type="text" id="idProduct" placeholder="">
<button id="addLot">addLot</button>

<button id="allUser">allUser</button>
<input type="text" id="firstname" placeholder="">
<input type="text" id="surname" placeholder="">
<input type="text" id="balans" placeholder="">
<input type="text" id="userPostAdress" placeholder="">
<button id="addUser">addUser</button>

<div id="conversationDiv"></div>
<script>

    /////////////////   User            //////////////

    $('#addUser').click(function () {
        $("#conversationDiv").empty();

        let $x = $('#firstname');
        let firstname = $x.val();
        $x.val(' ');
        let $x1 = $('#surname');
        let surname = $x1.val();
        $x1.val(' ');
        let $x2 = $('#balans');
        let balans = $x2.val();
        $x2.val(' ');
        let $x3 = $('#userPostAdress');
        let userPostAdress = $x3.val();
        $x3.val(' ');
        let user = JSON.stringify({firstname, surname, balans, userPostAdress});
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
            url : '/allUsert',
            type : 'get',
            contentType : 'application/json',
            success : function (result) {
                for (let obj of result) {
                    let user = $('<div/>', {text : obj.firstname + ' ' + obj.surname + ' ' + obj.balans + ' ' + obj.userPostAdress});
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
        let $x3 = $('#hotPrise');
        let hotPrise = $x3.val();
        $x3.val(' ');
        let $x4 = $('#idDelivery');
        let idDelivery = $x4.val();
        $x4.val(' ');
        let $x5 = $('#idPaytment');
        let idPaytment = $x5.val();
        $x5.val(' ');
        let $x6 = $('#idProduct');
        let idProduct = $x6.val();
        $x6.val(' ');
        let lot = JSON.stringify({dataStartLot, dataEndLot, startPrice, hotPrise, idDelivery, idPaytment, idProduct});
        $.ajax({
            url : '/addLot',
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
                    let lot = $('<div/>', {text : obj.dataStartLot + ' ' + obj.dataEndLot + ' ' + obj.startPrice + ' ' + obj.hotPrise + ' ' + obj.idDelivery + ' ' + obj.idPaytment + ' ' + obj.idProduct});
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

        let $x = $('#mathodPayment');
        let mathodPayment = $x.val();
        $x.val(' ');
        let payment = JSON.stringify({mathodPayment});
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
                    let payment = $('<div/>', {text : obj.mathodPayment});
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
        let subCategory = JSON.stringify({nameSubCategory});
        $.ajax({
            url : '/addSubCategory',
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

        let $input = $('#sumOfTheBet');
        let sumOfTheBet = $input.val();
        $input.val(' ');
        let $input1 = $('#stapeBet');
        let stapeBet = $input1.val();
        $input1.val(' ');
        let $input2 = $('#idLot');
        let idLot = $input2.val();
        $input2.val(' ');
        let $input3 = $('#userId');
        let userId = $input3.val();
        $input3.val(' ');
        let bet = JSON.stringify({sumOfTheBet, stapeBet, idLot, userId});
        $.ajax({
            url : '/addBet',
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
                    let bet = $('<div/>', {text : obj.sumOfTheBet + ' ' + obj.stapeBet + ' ' + obj.idLot + ' ' + obj.userId});
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

        let $x = $("#nameProduct");
        let nameProduct = $x.val();
        $x.val(' ');
        let $x1 = $("#modelProduct");
        let modelProduct = $x1.val();
        $x1.val(' ');
        let $x2 = $("#linkOnImageProduct");
        let linkOnImageProduct = $x2.val();
        $x2.val(' ');
        let $x3 = $("#descriptionProduct");
        let descriptionProduct = $x3.val();
        $x3.val(' ');
        let $x4 = $("#idManufacturer");
        let idManufacturer = $x4.val();
        $x4.val(' ');
        let $x5 = $("#idSubCategory");
        let idSubCategory = $x5.val();
        $x5.val(' ');
        let $x6 = $("#userId");
        let userId = $x6.val();
        $x6.val(' ');
        let product = JSON.stringify({nameProduct, modelProduct, linkOnImageProduct, descriptionProduct, idSubCategory, idManufacturer, userId});
console.log(product);
        $.ajax({
            url:"/addProduct",
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "put",
            data: product,
            contentType : 'application/json',
            dataType: 'json',          //передаєм
            // success: function (result) {
            //    console.log(result);
            //     for (let obj of result) {
            //         let prod = $('<div/>', {text: obj.nameProduct + " " + obj.modelProduct + " " + obj.linkOnImageProduct + " " + obj.descriptionProduct});
            //         prod.appendTo($("#conversationDiv"));
            //     }
            // },
            // error: function (error) {
            //     console.log(error);
            // }
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
