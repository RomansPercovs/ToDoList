<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="css/style.css"/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.delete-btn').click(function () {
                var ans = confirm("Are you sure you want to delete this Record?");
                var $element = $(this);
                if(ans) {
                    var id = $element.closest('tr').find("td:eq(3)").text();
                    $.ajax({
                        type: 'DELETE',
                        url: '/delete/' + id,
                        contentType: 'application/json',
                        success: function (response) {
                            $element.closest('tr').remove();
                        }
                    });
                }
            });
            $('#delete-menu').click(function () {
                $('.delete').toggle();
            })
        });
    </script>
    <style>
        .nav-bar{
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #f2f2f2;
        }

        .nav-list{
            float: left;
        }

        .nav-list .nav-link {
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-family: Arial, Helvetica, sans-serif;
            font-weight: bold;

        }

        .nav-list .nav-link:hover {
            background-color: #4CAF50;
            color:white;
        }
    </style>
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