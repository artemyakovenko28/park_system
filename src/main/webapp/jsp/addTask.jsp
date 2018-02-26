<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/30/2018
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add task</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/park_system.css">
</head>
<body>
<div class="container">
    <h1 class="header">Task adding</h1>
    <form action="addTask" method="post">
        <div class="form-row">
            <div class="form-group col-2">
                <label for="userLogin">Forester</label>
                <select class="form-control" name="userLogin" id="userLogin">
                    <c:forEach items="${foresters}" var="forester">
                        <option value="${forester.login}">${forester.login}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-2">
                <label for="plantName">Plant</label>
                <select class="form-control" name="plantName" id="plantName">
                    <c:forEach items="${plants}" var="plant">
                        <option value="${plant.name}">${plant.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-2">
                <label for="taskType">Task</label>
                <select class="form-control" name="taskType" id="taskType">
                    <c:forEach items="${taskTypes}" var="taskType">
                        <option value="${taskType}">${taskType}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-auto" style="margin-top: 10px">
                <input type="submit" class="btn btn-success" value="Add task">
            </div>
            ${taskAdded}
        </div>
        <p class="text-center">
            <a href="home" class="btn btn-success">Back</a>
        </p>
        <p class="text-center">
            <a href="logout" class="btn btn-success">Log out</a>
        </p>
    </form>
</div>
</body>
</html>
