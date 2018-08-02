<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="todolist.service.TaskServiceImp" %>
<%@ page import="todolist.Task" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
</head>
<body>
<main>
    <div>
        <table>
            <tr>
                <th>Name</th>
                <th>Task</th>
                <th>Status</th>
            </tr>
            <%
                TaskServiceImp taskServiceImp = new TaskServiceImp();
                List<Task> list = taskServiceImp.findAll();
                request.setAttribute("list", list);
            %>
            <c:forEach var="item" items="${list}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.task}</td>
                    <td>${item.status}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>