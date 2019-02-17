<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet"
          href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="../../css/style.css"/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/index.js"></script>
</head>
<body>
<%@ include file="../elements/nav-bar.jsp" %>
<main>
    <div class="menu">
        <button id="delete-menu">DELETE</button>
    </div>
    <div>
        <table id="tasks_list">
            <tr>
                <th>Assignee</th>
                <th>Task</th>
                <th>Status</th>
            </tr>
        </table>
    </div>
</main>
</body>
</html>