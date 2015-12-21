<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration Form</title>


    <link href="<c:url value="/resources/css/editbox.css"/>" rel="stylesheet">

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/resources/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/assets/css/form-elements.css">
    <link rel="stylesheet" href="/resources/assets/css/style.css">

    <link rel="shortcut icon" href="/resources/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/resources/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/resources/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/resources/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/resources/assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>
<div class="top-content" style="background-color: rgba(46, 47, 58, 0.98)">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text" >
                    <h1><strong>SFO</strong> Registration</h1>
                    <div class="description">
                        <p>
                            Register Here to get your oun static!
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 book">
                    <img src="/resources/assets/img/ebook.png" alt="">
                </div>
                <div class="col-sm-5 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Register</h3>
                            <p>Fill in the form below to get access:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-pencil"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/register" method="post" class="registration-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-first-name">Name</label>
                                <input type="text" name="name" value="${user.name}" placeholder="Name..."
                                       class="form-first-name form-control" id="form-first-name">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-last-name">Password</label>
                                <input type="text" value="${user.email}" name="email" placeholder="Email..."
                                       class="form-last-name form-control" id="form-last-name">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-email">Email</label>
                                <input type="password" name="password" placeholder="Password..."
                                       class="form-email form-control" id="form-email">
                            </div>
                            <button type="submit" class="btn">Register</button>
                            <button type="button" onclick="window.location.href='/login/'" class="btn">Login</button>
                        </form>
                        <c:if test="${not empty error}">
                            <div class="msg">${error}</div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="/resources/assets/js/jquery-1.11.1.min.js"></script>
<script src="/resources/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/assets/js/jquery.backstretch.min.js"></script>
<script src="/resources/assets/js/retina-1.1.0.min.js"></script>
<script src="/resources/assets/js/scripts.js"></script>

</body>

</html>