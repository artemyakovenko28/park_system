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
<h1 class="header">Taks adding</h1>
<form action="addTask" method="post">
    <table>
        <thead>
        <tr>
            <th><label for="userLogin">Forester</label></th>
            <th><label for="plantName">Plant</label></th>
            <th><label for="taskType">Task</label></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <select name="userLogin" id="userLogin">
                    <c:forEach items="${foresters}" var="forester">
                        <option value="${forester.login}">${forester.login}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="plantName" id="plantName">
                    <c:forEach items="${plants}" var="plant">
                        <option value="${plant.name}">${plant.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="taskType" id="taskType">
                    <c:forEach items="${taskTypes}" var="taskType">
                        <option value="${taskType}">${taskType}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="submit" value="Add task">
            </td>
        </tr>
        </tbody>
    </table>
    ${taskAdded}
    <br/>
    <a href="home">Back</a>
    <br/>
    <a href="logout">Log out</a>
    <br/>
</form>
</body>
</html>
