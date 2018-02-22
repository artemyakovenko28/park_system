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
    <link rel="stylesheet" type="text/css" href="css/park_system.css">
</head>
<body>
<c:if test="${sessionScope.user != null}">
    <jsp:forward page="jsp/home.jsp"/>
</c:if>
<h1 class="header">Welcome to the Park system!</h1>
<form name="loginForm" method="POST" action="home">
    <fieldset class="account">
        <legend>Authorization form:</legend>
        <label for="login">Login:</label>
        <br/>
        <input type="text" id="login" name="login" placeholder="Enter your login..."/>
        <br/>
        <label for="password">Password:</label>
        <br/>
        <input id="password" type="password" name="password" placeholder="Enter your password..."/>
        <br/>
        <br/>
        <input type="submit" value="Sign in"/>
    </fieldset>
</form>
${errorLoginPassMessage}
<p>Don't have an account?</p>
<a href="registration">Sign up</a>
</body>
</html>
