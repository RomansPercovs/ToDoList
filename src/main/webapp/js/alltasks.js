$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: '/tasks',
        dataType: 'json',
        contentType: 'application/json',
        success: function (json) {
            $(json).each(function (index, item) {
                const name = item.assignee;
                const task = item.assignment;
                const status = item.status;
                $('<tr><td>' + name + '</td><td>' +
                    task + '</td><td>' + status + '</td></tr>').appendTo('#tasks_list');
            });
        }
    });
});