<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/29/2018
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="shortcut icon" type="image/png" href="css/favicon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/park_system.css">
</head>
<body>
<div class="container">
    <c:if test="${sessionScope.user eq 'forester'}">
        <jsp:forward page="jsp/homeForester.jsp"/>
    </c:if>
    <c:if test="${sessionScope.user eq 'owner'}">
        <jsp:forward page="jsp/homeOwner.jsp"/>
    </c:if>
    <h1 class="header">Welcome to the Park system!</h1>
    <form action="home" method="POST">
        <div class="row">
            <div class="form-group col-4">
                <label for="login">Login:</label>
                <input type="text" class="form-control" id="login" name="login" placeholder="Enter your login..."/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-4">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password"
                       placeholder="Enter your password..."/>
            </div>
        </div>
        <input type="submit" class="btn btn-success" value="Log in"/>
        <input type="reset" class="btn btn-success" value="Reset"/>
    </form>
    <c:if test="${errorLoginPassMessage ne null}">
        <div class="text-danger">${errorLoginPassMessage}</div>
    </c:if>
    <p>Don't have an account?</p>
    <p>
        <a href="registration" class="btn btn-success">Register</a>
    </p>
</div>
</body>
</html>