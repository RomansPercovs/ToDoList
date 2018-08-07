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
        });
    </script>
</head>
<body>
<header>
    <a href="#">Home</a>
    <a href="create.jsp">Create Task</a>
    <a href="">Delete Task</a>
    <a href="alltasks.jsp">Show all tasks(JSON)</a>
</header>
<main>
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
                    <td class="delete"><button class="delete-btn">DELETE</button>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>