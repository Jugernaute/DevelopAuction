<%--
  Created by IntelliJ IDEA.
  User: adminx
  Date: 27.02.2019
  Time: 21:47
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
                <li class="active"><a href="#">Users</a></li>
                <li><a href="/categories">Categories</a></li>
                <li><a href="/subcategories">Subcategories</a></li>
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
            <li class="active">Users</li>
        </ol>
    </div>
</section>

<section class="main">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading main-color-bg">
                        <h3 class="panel-title">Users</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-1">
                                <h3>Id</h3>
                            </div>
                            <div class="col-md-2">
                                <h3>Username</h3>
                            </div>
                            <div class="col-md-4">
                                <h3>Email</h3>
                            </div>
                            <div class="col-md-2">
                                <h3>Is non locked</h3>
                            </div>
                            <div class="col-md-3">
                                <h3>Delete</h3>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach var="u" items="${users}">
                                <div class="col-md-1">
                                    <span>${u.userId}</span>
                                </div>
                                <div class="col-md-2">
                                    <span>${u.username}</span>
                                </div>
                                <div class="col-md-4">
                                    <span>${u.email}</span>
                                </div>
                                <div class="col-md-2">
                                    <span>${u.accountNonLocked}</span>
                                </div>
                                <div class="col-md-3">
                                    <a href="/users/delete/${u.userId}"
                                       class="btn btn-danger form-control">delete</a>
                                </div>
                            </c:forEach>
                        </div>
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
<%--<script src="../js/bootstrap.min.js"></script>--%>
</body>
</html>
