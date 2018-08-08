<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="css/style.css"/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="js/script.js"></script>
</head>
<body>
<div>
    <ul class="nav-bar">
        <li class="nav-list" class="active"><a class="nav-link" href="#">Home</a></li>
        <li class="nav-list"><a class="nav-link" href="create.jsp">Create Task</a></li>
        <li class="nav-list"><a class="nav-link" href="alltasks.jsp">Show all tasks(JSON)</a></li>
    </ul>
</div>
<main>
    <div class="menu">
        <button id="delete-menu">DELETE</button>
    </div>
    <div>
        <table id="tasks_list">
            <tr>
                <th>Name</th>
                <th>Task</th>
                <th>Status</th>
            </tr>
            <c:forEach var="item" items="${tasks}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.task}</td>
                    <td>${item.status}</td>
                    <td style="display: none" class="task_id">${item.id}</td>
                    <td class="delete">
                        <button class="delete-btn">
                            <i class="glyphicon glyphicon-trash"></i>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>