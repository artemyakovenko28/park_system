<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/30/2018
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All tasks</title>
    <link rel="stylesheet" type="text/css" href="../css/park_system.css">
</head>
<body>
<h1 class="header">All tasks</h1>
<table>
    <thead>
    <tr>
        <th>User login</th>
        <th>Plant name</th>
        <th>Task type</th>
        <th>Forester status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allTasks}" var="task">
        <tr>
            <td>${task.userLogin}</td>
            <td>${task.plantName}</td>
            <td>${task.type}</td>
            <td>${task.foresterStatus}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="home">Back</a>
<br/>
<a href="logout">Log out</a>
<br/>
</body>
</html>
