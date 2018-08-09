$(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/tasks',
            dataType: 'json',
            contentType: 'application/json',
            success: function (json) {
                $(json).each(function (index, item) {
                    let name = item.name;
                    let task = item.task;
                    let status = item.status;
                    $('<tr><td>' + name + '</td><td>' +
                        task + '</td><td>' + status + '</td></tr>').appendTo('#tasks_list');
                });
            }
        });
    });