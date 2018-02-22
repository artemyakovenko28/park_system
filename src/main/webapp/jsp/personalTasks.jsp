<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/29/2018
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal tasks</title>
    <link rel="stylesheet" type="text/css" href="../css/park_system.css"/>
</head>
<body>
<h1 class="header">Personal tasks</h1>
<table>
    <thead>
    <tr>
        <th>Plant's name</th>
        <th>Type</th>
        <th>Status</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="personalTasks" scope="request" type="java.util.List"/>
    <c:forEach items="${personalTasks}" var="personalTask">
        <tr>
            <td>${personalTask.plantName}</td>
            <td>${personalTask.type}</td>
            <td>${personalTask.foresterStatus}</td>
            <td>
                <form action="completeTask" method="post">
                    <input type="hidden" name="taskId" value="${personalTask.id}">
                    <input type="submit" value="Complete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<a href="home">Back</a>
<br/>
<a href="logout">Log out</a>
<br/>
</body>
</html>
