<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/30/2018
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Completed tasks</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/park_system.css">
</head>
<body>
<h1 class="header">Completed tasks</h1>
<table>
    <thead>
    <tr>
        <th>User login</th>
        <th>Plant name</th>
        <th>Task type</th>
        <th>Forester status</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${completedTasks}" var="task">
        <tr>
            <td>${task.userLogin}</td>
            <td>${task.plantName}</td>
            <td>${task.type}</td>
            <td>${task.foresterStatus}</td>
            <td>
                <form action="closeTask" method="post">
                    <input type="hidden" name="taskId" value="${task.id}">
                    <input type="submit" value="Close">
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
