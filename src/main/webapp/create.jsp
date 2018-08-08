<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet" href="<c:url value="css/style.css"/>"/>
    <style>
        ul{
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #f2f2f2;
        }

        li{
            float: left;
        }

        li a {
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-family: Arial, Helvetica, sans-serif;
            font-weight: bold;
        }

        li a:hover {
            background-color: #4CAF50;
            color:white;
        }
    </style>
</head>
<body>
<div>
    <ul>
        <li><a href="/">Home</a></li>
        <li class="active"><a href="#">Create Task</a></li>
        <li><a href="alltasks.jsp">Show all tasks(JSON)</a></li>
    </ul>
</div>
<main>
    <div class="form">
        <h2>Create new task</h2>
        <form method="post" name="taskForm" action="http://localhost:8080/create">
            <div class="text-input">
                <label for="name">Name</label>
                <input id="name" name="name" type="text"/>
                <span class="separator"> </span>
            </div>

            <div class="text-input">
                <label for="task">Task</label>
                <input id="task" name="task" type="text"/>
                <span class="separator"> </span>
            </div>

            <div class="text-input">
                <label for="status">Status</label>
                <input id="status" name="status" type="text"/>
                <span class="separator"> </span>
            </div>

            <div><input type="submit" value="Submit"/></div>
        </form>
    </div>
</main>
</body>
</html>