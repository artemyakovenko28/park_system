<%--<jsp:useBean id="user" scope="session" class="com.company.park_system.entity.User"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/1/2018
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/park_system.css">
</head>
<body>
<div class="container">
    <h1 class="header">Forester's home page</h1>
    <h3 class="text-center">Hello, ${user.login}!</h3>
    <p class="text-center">
        <a href="personalTasks" class="btn btn-success">Personal tasks</a>
    </p>
    <p class="text-center">
        <a href="logout" class="btn btn-success">Log out</a>
    </p>
</div>
</body>
</html>
