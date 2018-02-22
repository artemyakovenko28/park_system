<jsp:useBean id="user" scope="session" type="com.company.park_system.entity.User"/>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/1/2018
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="../css/park_system.css"/>
</head>
<body>
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
</body>
</html>
