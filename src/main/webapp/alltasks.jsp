<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet" href="<c:url value="css/style.css"/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="js/script.js"></script>
</head>
<body>
<div>
    <ul class="nav-bar">
        <li class="nav-list"><a class="nav-link" href="/">Home</a></li>
        <li class="nav-list"><a class="nav-link" href="create.jsp">Create Task</a></li>
        <li class="nav-list" class="active"><a class="nav-link" href="#">Show all tasks(JSON)</a></li>
    </ul>
</div>
<main>
    <div>
        <table id="tasks_list" style="margin-top: 20px;">
            <tr>
                <th>Name</th>
                <th>Task</th>
                <th>Status</th>
            </tr>
        </table>
        <button id="tasks">Get tasks from JSON</button>
    </div>
</main>
</body>
</html>