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
    <link rel="stylesheet" type="text/css" href="../css/park_system.css">
</head>
<body>
<h1 class="header">Registration</h1>
<form name="registrationForm" method="POST" action="registration">
    <fieldset class="account center">
        <legend>Registration form:</legend>
        <table>
            <tr>
                <td><label for="login">Login:</label></td>
                <td><input type="text" id="login" name="login" placeholder="Enter your login..."></td>
            </tr>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><input id="password" type="text" name="password" placeholder="Enter your password..."></td>
            </tr>
            <tr>
                <td><label for="status">Status:</label></td>
                <td>
                    <select id="status" name="status">
                        <option value="owner">Owner</option>
                        <option value="forester">Forester</option>
                    </select>
                </td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="Sign up">
    </fieldset>
    <c:if test="${requestScope.emptyLogin != null}">
        <p>${emptyLogin}</p>
    </c:if>
    <c:if test="${requestScope.emptyPassword != null}">
        <p>${emptyPassword}</p>
    </c:if>
    <c:if test="${requestScope.emptyStatus != null}">
        <p>${emptyStatus}</p>
    </c:if>
    <c:if test="${requestScope.userExists != null}">
        <p>${userExists}</p>
    </c:if>
    <c:if test="${requestScope.registrationCompleted != null}">
        <p>${registrationCompleted}</p>
    </c:if>
</form>
<a href="../index.jsp">Sign in</a>
</body>
</html>
