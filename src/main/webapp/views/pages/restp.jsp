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
<h3> restp</h3>
<button id="x">xxxxx</button>

<input type="text" name="nameProduct" placeholder="nameProduct"/>
<input type="text" name="modelProduct" placeholder="modelProduct"/>
<button id="add">add</button>
<div id="conversationDiv"></div>
<script>

    $("#add").click(function () {
        $("#conversationDiv").empty();

        let nameProduct = $("#nameProduct").val();
        let modelProduct = $("#modelProduct").val();
        let obj = {nameProduct, modelProduct}
        let jsonProduct = JSON.stringify(obj);

        $.ajax({
            url:"/saveProduct",
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "post",
            data: jsonProduct,
            dataType: 'json',
            success: function (result) {
               console.log(result);
                for (let obj of result) {
                    let $prod = $('<div/>', {text: obj.nameProduct + " " + obj.modelProduct});
                    $prod.appendTo($("#conversationDiv"));
                }
            },
            error: function (error) {
                console.log(error);
            }
        })

    })

$("#x").click(function () {
    $("#conversationDiv").empty();

    $.ajax({
        url : '/giveProduct',
        type : 'get',
        contentType : 'application/json',
        // data :'data'
        success : function (result) {
            console.log(result);
            for (let obj of result) {
                let $prod = $('<div/>',{text: obj.nameProduct + " " + obj.modelProduct});
                $prod.appendTo($("#conversationDiv"));
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
