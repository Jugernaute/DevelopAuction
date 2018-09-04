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
<h3>Create Common Category</h3>

<form action="/saveCommonCategory" method="post">
    <input type="text" name="nameCommonCategory" placeholder="nameCommonCategory">
    <input type="submit" value="save CommonCategory">
</form>



<h3>Create Subcategory</h3>
<form action="/saveSubCategory" method="post">
    <input type="text" name="nameSubCategory" placeholder="nameSubCategory">
    <input type="text" name="id_CommonCategory" placeholder="id_CommonCategory">
    <input type="submit" value="save Subcategory">
</form>

<h3>Create Manufacturer</h3>
<form action="/saveManufacturer" method="post">
    <input type="text" name="nameManufacturer" placeholder="nameManufacturer">
    <input type="submit" value="save Manufacturer">
</form>


<h3>Create Client</h3>
<form action="/saveClient" method="post">
    <input type="text" name="nameClient" placeholder="nameClient">
    <input type="text" name="surNameClient" placeholder="surNameClient">
    <input type="text" name="emailClient" placeholder="emailClient">
    <input type="submit" value="save Client">
</form>


<h3>Create Product</h3>
<form action="/saveProduct" method="post">
    <input type="text" name="nameProduct" placeholder="nameProduct"><br>
    <input type="text" name="modelProduct" placeholder="modelProduct"><br>
    <input type="text" name="priceProduct" placeholder="priceProduct"><br>
    <input type="text" name="descriptionProduct" placeholder="descriptionProduct"><br>
    <input type="text" name="id_SubCategory" placeholder="id_SubCategory"><br>
    <input type="text" name="id_Manufacturer" placeholder="id_Manufacturer"><br>
    <input type="text" name="id_Client" placeholder="id_Client"><br>
    <input type="submit" value="save Product">
</form>

<h3>Create Auction</h3>
<form action="/createAuction" method="post">
    <input type="text" name="dataStartAuction" placeholder="dataStartAuction">
    <input type="text" name="dataCloseAuction" placeholder="dataCloseAuction">
    <input type="text" name="id_Product" placeholder="id_Product">
    <input type="submit" value="Create new Auction">
</form>

<h3>Join new buyer to Auction</h3>
<form action="/joinBuyerToAuction" method="post">
    <input type="text" name="id_Auction" placeholder="id_Auction">
    <input type="text" name="id_Client" placeholder="id_Client">
    <input type="submit" value="Join to Auction">
</form>



</body>
</html>
