<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet" href="<c:url value="css/style.css"/>"/>
</head>
<body>
<header>
    <a href="/">Home</a>
    <a href="#">Create Task</a>
    <a href="alltasks.jsp">Show all tasks(JSON)</a>
</header>
<main>
    <div>
        <h2>Create new task</h2>
        <form method="post" name="taskForm" action="http://localhost:8080/create">
            <div><label for="name">Name:</label></div>
            <input id="name" name="name" type="text"/>
            <div><label for="task">Task:</label></div>
            <input id="task" name="task" type="text"/>
            <div><label for="status">Status:</label></div>
            <input id="status" name="status" type="text"/>
            <div><input type="submit" value="Submit"/></div>
        </form>
    </div>
</main>
</body>
</html>