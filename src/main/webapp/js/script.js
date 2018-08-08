$(document).ready(function () {
    $('#tasks').click(function () {
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
    $('.delete-btn').click(function () {
        let ans = confirm("Are you sure you want to delete this Record?");
        let $element = $(this);
        if(ans) {
            let id = $element.closest('tr').find("td:eq(3)").text();
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
    });
});