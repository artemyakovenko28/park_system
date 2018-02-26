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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/park_system.css">
</head>
<body>
<div class="container">
    <h1 class="header">Registration</h1>
    <form action="registration" method="POST">
        <div class="row">
            <div class="form-group col-4">
                <label for="login">Login:</label>
                <input type="text" id="login" name="login" placeholder="Enter your login...">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-4">
                <label for="password">Password:</label>
                <input id="password" type="text" name="password" placeholder="Enter your password...">
            </div>
        </div>
        <div class="row">
            <div class="form-group col4">
                <label for="status">Status:</label>
                <select id="status" name="status">
                    <option value="owner">Owner</option>
                    <option value="forester">Forester</option>
                </select>
            </div>
        </div>
        <input type="submit" class="btn btn-success" value="Sign up">
        <c:if test="${requestScope.emptyLogin != null}">
            <p>${emptyLogin}</p>
        </c:if>
        <c:if test="${requestScope.emptyPassword != null}">
            <p class="text-danger">${emptyPassword}</p>
        </c:if>
        <c:if test="${requestScope.emptyStatus != null}">
            <p class="text-danger">${emptyStatus}</p>
        </c:if>
        <c:if test="${requestScope.userExists != null}">
            <p class="text-danger">${userExists}</p>
        </c:if>
        <c:if test="${requestScope.registrationCompleted != null}">
            <p class="text-danger">${registrationCompleted}</p>
        </c:if>
    </form>
    <a href="../index.jsp">Sign in</a>
</div>
</body>
</html>
