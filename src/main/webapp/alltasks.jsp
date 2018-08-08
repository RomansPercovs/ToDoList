<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet" href="<c:url value="css/style.css"/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            // $('#tasks').click(function () {
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
            // });
        });
    </script>
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

        #tasks_list{
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div>
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="create.jsp">Create Task</a></li>
        <li class="active"><a href="#">Show all tasks(JSON)</a></li>
    </ul>
</div>
<main>
    <div>
        <table id="tasks_list">
            <tr>
                <th>Name</th>
                <th>Task</th>
                <th>Status</th>
            </tr>
        </table>
        <%--<button id="tasks">Get tasks from JSON</button>--%>
    </div>
</main>
</body>
</html>