<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/28/2018
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="shortcut icon" type="image/png" href="../css/favicon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/park_system.css">
</head>
<body>
<div class="container">
    <h1 class="header">Registration</h1>
    <form action="registration" method="post">
        <div class="form-group col-4">
            <label for="login">Login:</label>
            <input type="text" class="form-control" id="login" name="login" placeholder="Enter your login...">
            <div class="text-danger">${errorMap.login}</div>
        </div>
        <div class="form-group col-4">
            <label for="password">Password:</label>
            <input id="password" class="form-control" type="password" name="password"
                   placeholder="Enter your password...">
            <div class="text-danger">${errorMap.password}</div>
        </div>
        <div class="form-group col-4">
            <label for="status">Status:</label>
            <select class="form-control" id="status" name="status">
                <option selected>Choose status...</option>
                <option value="owner">Owner</option>
                <option value="forester">Forester</option>
            </select>
            <div class="text-danger">${errorMap.status}</div>
        </div>
        <input type="submit" class="btn btn-success" value="Register">
    </form>
    <p style="color: green">${registrationCompleted}</p>
    <p>
        <a href="../index.jsp" class="btn btn-success">Log in</a>
    </p>
</div>
</body>
</html>
