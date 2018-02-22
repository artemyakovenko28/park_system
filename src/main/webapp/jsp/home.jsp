<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/28/2018
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="user" scope="session" type="com.company.park_system.entity.User"/>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="../css/park_system.css"/>
</head>
<body>
<c:if test="${user.status == 'forester'}">
    <h1 class="header">Forester's home page</h1>
    <h2>Hello, ${user.login}!</h2>
    <a href="personalTasks">Personal tasks</a>
    <br/>
    <a href="logout">Log out</a>
    <br/>
</c:if>
<c:if test="${user.status == 'owner'}">
    <h1 class="header">Owner's home page</h1>
    <h2>Hello, ${user.login}</h2>
    <a href="addTask">Add task</a>
    <br/>
    <a href="completedTasks">Completed tasks</a>
    <br/>
    <a href="allTasks">All tasks</a>
    <br/>
    <a href="logout">Log out</a>
    <br/>
</c:if>
</body>
</html>
