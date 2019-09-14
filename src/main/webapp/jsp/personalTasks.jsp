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
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="shortcut icon" type="image/png" href="../css/favicon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/park_system.css">
</head>
<body>
<div class="container">
    <h1 class="header">Personal tasks</h1>
    <table class="table-park">
        <thead>
        <tr>
            <th>Plant's name</th>
            <th>Type</th>
            <th>Status</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${personalTasks}" var="personalTask">
            <tr>
                <td>${personalTask.plantName}</td>
                <td>${personalTask.type}</td>
                <td>${personalTask.foresterStatus}</td>
                <td>
                    <form action="completeTask" method="post">
                        <input type="hidden" name="taskId" value="${personalTask.id}">
                        <input type="submit" class="btn btn-success" value="Complete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <p class="text-center">
        <a href="home" class="btn btn-success">Back</a>
    </p>
    <p class="text-center">
        <a href="logout" class="btn btn-success">Log out</a>
    </p>
</div>
</body>
</html>
