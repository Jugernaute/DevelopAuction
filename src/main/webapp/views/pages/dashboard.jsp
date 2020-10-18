<%--
  Created by IntelliJ IDEA.
  User: adminx
  Date: 27.02.2019
  Time: 21:46
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
                <li class="active"><a href="/dashboard">Dashboard</a></li>
                <li><a href="/users">Users</a></li>
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
    </div>
</header>

<section id="breadcrumb">
    <div class="container">
        <ol class="breadcrumb">
            <li class="active">Dashboard</li>
        </ol>
    </div>
</section>

<section class="main">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="list-group">
                    <a href="#" class="list-group-item active main-color-bg">
                        <i class="fas fa-cog"></i> Dashboard
                    </a>
                    <a href="/categories" class="list-group-item">
                        <i class="fas fa-align-center"></i>
                        Categories <span class="badge">${categoryCount}</span>
                    </a>
                    <a href="/users" class="list-group-item">
                        <i class="fas fa-users"></i>
                        Users <span class="badge">${userCount}</span>
                    </a>
                    <a href="/lots" class="list-group-item">
                        <i class="fas fa-th-large"></i>
                        Lots <span class="badge">${lotCount}</span>
                    </a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="panel panel-default">
                    <div class="panel-heading main-color-bg">
                        <h3 class="panel-title">Website Overview</h3>
                    </div>
                    <div class="panel-body">
                        <div class="col-md-3">
                            <div class="well dash-box">
                                <h2><i class="fas fa-users"></i>
                                    <span>${userCount}</span>
                                </h2>
                                <h4>Users</h4>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="well dash-box">
                                <h2><i class="fas fa-align-center"></i>
                                    <span>${categoryCount}</span>
                                </h2>
                                <h4>Categories</h4>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="well dash-box">
                                <h2><i class="fas fa-th-large"></i>
                                    <span>${lotCount}</span>
                                </h2>
                                <h4>Lots</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">All Users</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <h3>User id</h3>
                </div>
                <div class="col-md-3">
                    <h3>User name</h3>
                </div>
                <div class="col-md-3">
                    <h3>User phone</h3>
                </div>
                <div class="col-md-3">
                    <h3>User email</h3>
                </div>
            </div>
            <div class="row">
                <c:forEach var="u" items="${users}">
                    <div class="col-md-3">
                        <span>${u.userId}</span>
                    </div>
                    <div class="col-md-3">
                        <span>${u.username}</span>
                    </div>
                    <div class="col-md-3">
                        <span>${u.phone}</span>
                    </div>
                    <div class="col-md-3">
                        <span>${u.email}</span>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>

<footer id="footer">
    <p>Copyright Admin, &copy; 2018</p>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
