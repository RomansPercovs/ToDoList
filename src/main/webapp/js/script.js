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