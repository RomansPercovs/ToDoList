<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TODO List</title>
    <link rel="stylesheet" href="<c:url value="../../css/style.css"/>"/>
</head>
<body>
<%@ include file="../elements/nav-bar.jsp" %>

<main>
    <div class="form">
        <h2>Create new assignment</h2>
        <form method="post" assignee="taskForm">
            <div class="text-input">
                <label for="assignee">Assignee</label>
                <input id="assignee" assignee="assignee" type="text"/>
                <span class="separator"> </span>
            </div>

            <div class="text-input">s
                <label for="assignment">Task</label>
                <input id="assignment" assignee="assignment" type="text"/>
                <span class="separator"> </span>
            </div>

            <div class="text-input">
                <label for="status">Status</label>
                <input id="status" assignee="status" type="text"/>
                <span class="separator"> </span>
            </div>

            <div><input id="create" type="submit" value="Submit"/></div>
        </form>
    </div>
</main>
</body>
</html>