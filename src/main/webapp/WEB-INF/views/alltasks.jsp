<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet" href="<c:url value="../../css/style.css"/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../../js/alltasks.js"></script>
</head>
<body>
<%@ include file="../elements/nav-bar.jsp" %>
    <div>
        <table id="tasks_list">
            <tr>
                <th>Assignee</th>
                <th>Task</th>
                <th>Status</th>
            </tr>
        </table>
    </div>
</body>
</html>