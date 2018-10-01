<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01.09.2018
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Create Common Category (буде створювати та заповнювати адмін)</h3>
<form action="/saveCommonCategory" method="post">
    <input type="text" name="nameCommonCategory" placeholder="nameCommonCategory">
    <input type="submit" value="save CommonCategory">
</form>


<h3>Create Subcategory (буде створювати та заповнювати адмін)</h3>
<form action="/saveSubCategory" method="post">
    <input type="text" name="nameSubCategory" placeholder="nameSubCategory">
    <input type="text" name="id_CommonCategory" placeholder="id_CommonCategory">
    <input type="submit" value="save Subcategory">
</form>

<h3>Create Manufacturer (буде створювати та заповнювати адмін)</h3>
<form action="/saveManufacturer" method="post">
    <input type="text" name="nameManufacturer" placeholder="nameManufacturer">
    <input type="submit" value="save Manufacturer">
</form>

<h3>Create method delivery (буде створювати адмін)</h3>
<form action="/createDelivery" method="post">
    <input type="text" name="methodDelivery" placeholder="methodDelivery">
    <input type="submit" value="save method of Delivery">
</form>

<h3>Create method payment (буде створювати адмін)</h3>
<form action="/createPayment" method="post">
    <input type="text" name="methodPayment" placeholder="methodPayment">
    <input type="submit" value="save method of Payment">
</form>

<h3>Create Client</h3>
<form action="/saveUser1" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="text" name="userBalance" placeholder="userBalance">
    <input type="submit" value="save User">
</form>


<h3>Create Product</h3>
<form action="/saveProduct" method="post">
    <input type="text" name="nameProduct" placeholder="nameProduct"><br>
    <input type="text" name="modelProduct" placeholder="modelProduct"><br>
    <input type="text" name="descriptionProduct" placeholder="descriptionProduct"><br>
    <input type="text" name="id_SubCategory" placeholder="id_SubCategory"><br>
    <input type="text" name="id_Manufacturer" placeholder="id_Manufacturer"><br>
    <input type="text" name="id_User" placeholder="id_User"><br>
    <input type="submit" value="save Product">
</form>

<h3>Delet Product (видалення продукту до початку аукціону)</h3>
<form action="/deleteProduct" method="get">
    <input type="text" name="idProduct" placeholder="idProduct"><br>
    <input type="submit" value="delete Product">
</form>

<h3>Create Lot</h3>
<form action="/createLot" method="post">
    <input type="text" name="dataStartLot" placeholder="dataStartLot">
    <input type="text" name="dataEndLot" placeholder="dataEndLot">
    <input type="text" name="id_Product" placeholder="id_Product">
    <input type="text" name="startPrice" placeholder="startPrice">
    <input type="text" name="hotPrice" placeholder="hotPrice">
    <input type="text" name="idDelivery" placeholder="idDelivery">
    <input type="text" name="idPayment" placeholder="idPayment">
    <input type="submit" value="Create new Lot">
</form>

<h3>Delete Lot </h3>
<p>(видалення лоту без ставок, лот створений продавцем)</p>
<p>Лот видаляється продукт лишається</p>
<form action="/deleteLot" method="get">
    <input type="text" name="idLot" placeholder="idLot"><br>
    <input type="submit" value="delete Lot">
</form>


<h3>Create the Bet (робить покупець)</h3>
<form action="/createBet" method="post">
    <input type="text" name="id_Lot" placeholder="id_Lot">
    <input type="text" name="id_User" placeholder="id_User">
    <input type="text" name="sum_of_the_bet" placeholder="sum_of_the_bet">
    <input type="submit" value="Join to Auction">
</form>
<h3>Delete Bet </h3>
<p>(видалення ставки)</p>
<p>ставка видаляється, лот і продукт лишаються</p>
<form action="/deleteBet" method="get">
    <input type="text" name="idBet" placeholder="idBet"><br>
    <input type="submit" value="delete Bet">
</form>

<h3>Delet User</h3>
<form action="/deleteUser" method="get">
    <input type="text" name="idUser" placeholder="idUser"><br>
    <input type="submit" value="delete User">
</form>



</body>
</html>
