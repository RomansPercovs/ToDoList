<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#tasks').click(function () {
                $.ajax({
                    type: 'GET',
                    url: 'http://localhost:8080/tasks',
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (json) {
                        $(json).each(function (index, item) {
                            var name = item.name;
                            var task = item.task;
                            var status = item.status;
                            $('<tr><td>' + name + '</td><td>' +
                                task + '</td><td>' + status + '</td></tr>').appendTo('#tasks_list');
                        });
                    }
                });
            });

        });
    </script>
</head>
<body>
<main>
    <div>
        <h2>Tasks from GET request which return HTML</h2>
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
                </tr>
            </c:forEach>

        </table>
        <button id="tasks">Get tasks from JSON</button>
    </div>
    
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
</main>
</body>
</html>