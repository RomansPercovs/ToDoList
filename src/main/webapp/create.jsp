<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet" href="<c:url value="css/style.css"/>"/>
</head>
<body>
<div>
    <ul class="nav-bar">
        <li class="nav-list"><a class="nav-link" href="/">Home</a></li>
        <li class="nav-list" class="active"><a class="nav-link" href="#">Create Task</a></li>
        <li class="nav-list"><a class="nav-link" href="alltasks.jsp">Show all tasks(JSON)</a></li>
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