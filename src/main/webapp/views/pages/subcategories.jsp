<%--
  Created by IntelliJ IDEA.
  User: Lena
  Date: 09.10.2018
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../style/bootstrap.min.css" rel="stylesheet">
    <link href="../style/default.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
          integrity="sha384-DmABxgPhJN5jlTwituIyzIUk6oqyzf3+XuP7q3VfcWA2unxgim7OSSZKKf0KSsnh" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Admin</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/dashboard">Dashboard</a></li>
                <li><a href="/users">Users</a></li>
                <li><a href="/categories">Categories</a></li>
                <li class="active"><a href="#">Subcategories</a></li>
                <li><a href="/main">Main page</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Welcome, Admin</a></li>
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<header id="header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1><i class="fas fa-cog"></i> Manage Your Site</h1>
            </div>
        </div>
    </div>
</header>

<section id="breadcrumb">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="#">Dashboard</a></li>
            <li class="active">Subcategories</li>
        </ol>
    </div>
</section>

<section class="main">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading main-color-bg">
                        <h3 class="panel-title">Subcategories</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form action="/createSubcategory" method="post">
                                    Select a Category:&nbsp;
                                    <select name="id_CommonCategory" class="form-control-lg form-control">
                                        <c:forEach items="${categories}" var="c">
                                            <option name="category"
                                                    value="${c.id_CommonCategory}">${c.nameCommonCategory}</option>
                                        </c:forEach>
                                    </select>
                                    <br>
                                    <input class="form-control" name="nameSubCategory" type="text"
                                           placeholder="Subсategory name" required>
                                    <button class="btn btn-danger form-control" type="submit">Create subCategory</button>
                                </form>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <h3>Subcategory name</h3>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach var="subcategory" items="${subcategories.content}">
                                <div class="col-md-2">
                                <span>${subcategory.id_SubCategory}</span>
                            </div>
                                <div class="col-md-4">
                                    <span>${subcategory.nameSubCategory}</span>
                                </div>
                                <div class="col-md-6">
                                    <a href="/subcategories/delete/${subcategory.id_SubCategory}"
                                       class="btn btn-danger form-control">delete</a>
                                </div>
                            </c:forEach>
                        </div>



                    </div>
                    <div class="pagination">
                    <ul class="list_page">
                        <%--<li><a href="" class="previous">&laquo;</a></li>--%>
                        <c:forEach var="i" begin="1" end="${totalPages-1}" step="1" >
                            <li class="a_page"><a href=""><c:out value="${i}"/></a></li>
                        </c:forEach>
                        <%--<li><a href="" class="next">&raquo;</a></li>--%>
                    </ul>
                </div>
                </div>
            </div>
        </div>
    </div>
</section>

<footer id="footer">
    <p>Copyright Admin, &copy; 2018</p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/subcategoryAdmin.js"></script>
</body>
</html>
