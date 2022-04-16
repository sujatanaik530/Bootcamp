<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/80ef1619da.js" crossorigin="anonymous"></script>
    <style>
        form {
            width: 50%;
            margin: auto;
        }
    </style>
</head>
<body>
<div class="container">
    <sec:authorize access="!isAuthenticated()">
        <a href="/login/login" title="Login"><i class="fa-solid fa-arrow-right-to-bracket"></i>&nbsp;&nbsp;Login</a> &nbsp; | &nbsp;
    </sec:authorize>
    <a href="/index">Index</a> &nbsp; | &nbsp;
    <a href="/upload">Upload</a> &nbsp; | &nbsp;
    <a href="/ajax">AJAX Example</a> &nbsp; | &nbsp;
    <a href="/user/register">Sign Up</a> &nbsp; | &nbsp;
    <sec:authorize access="hasAuthority('ADMIN')">
        <!-- Just this will not stop anyone from typing the URL and accessing the page. -->
        <!-- Changes are required in the controller. -->
        <a href="/user/search">Search</a> &nbsp; | &nbsp;
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        &nbsp; | &nbsp;<a href="/login/logout" title="Logout"><i class="fa-solid fa-arrow-right-from-bracket"></i>&nbsp;&nbsp;Logout</a>
        &nbsp;&nbsp;<em><sec:authentication property="principal.username"></sec:authentication></em>
    </sec:authorize>
    <hr>
</div>