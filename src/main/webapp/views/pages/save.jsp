<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: adminx
  Date: 07.09.2018
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>User</h3>
<form action="/save/user" method="post">
    <input type="text" name="firstname" placeholder="firstname"/>
    <input type="text" name="surname" placeholder="surname"/>
    <input type="text" name="balans" placeholder="balans"/>
    <input type="text" name="userPostAdress" placeholder="userPostAdress"/>
    <input type="submit" name="" placeholder="">
</form>
<h3>Manufacturer</h3>
<form action="/save/manufacturer" method="post">
    <input type="text" name="nameManufacturer" placeholder="nameManufacturer"/>
    <input type="submit" name="" placeholder="">
</form>
<h3>Payment</h3>
<form action="/save/payment" method="post">
    <input type="text" name="mathodPayment" placeholder="mathodPayment"/>
    <input type="submit" name="" placeholder="">
</form>
<h3>Lot</h3>
<form action="/save/lot" method="post">
    <input type="text" name="dataStartLot" placeholder="dataStartLot"/>
    <input type="text" name="dataEndLot" placeholder="dataEndLot"/>
    <input type="text" name="startPrice" placeholder="startPrice"/>
    <input type="text" name="hotPrise" placeholder="hotPrise"/>
    <input type="submit" name="" placeholder="">
</form>
<h3>Product</h3>
<form action="/save/product" method="post">
    <input type="text" name="nameProduct" placeholder="nameProduct"/>
    <input type="text" name="modelProduct" placeholder="modelProduct"/>
    <input type="text" name="linkOnImageProduct" placeholder="linkOnImageProduct"/>
    <input type="text" name="descriptionProduct" placeholder="descriptionProduct"/>
    <input type="text" name="stateProduct" placeholder="stateProduct"/>
    <input type="submit" name="" placeholder="">
</form>
<h3>Bet</h3>
<form action="/save/bet" method="post">
    <input type="text" name="sum_of_the_bet" placeholder="sum_of_the_bet"/>
    <input type="text" name="stapeBet" placeholder="stapeBet"/>
    <input type="submit" name="" placeholder="">
</form>
<h3>CommonCategory</h3>
<form action="/save/commonCategory" method="post">
    <input type="text" name="nameCommonCategory" placeholder="nameCommonCategory"/>
    <input type="submit" name="" placeholder="">
</form>
<h3>Delivery</h3>
<form action="/save/delivery" method="post">
    <input type="text" name="methodDelivery" placeholder="methodDelivery"/>
    <input type="submit" name="" placeholder="">
</form>
<h3>SubCategory</h3>
<form action="/save/subCategory" method="post">
    <input type="text" name="nameSubCategory" placeholder="nameSubCategory"/>
    <input type="submit" name="" placeholder="">
</form>

</body>
</html>