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
                const id = item.id;
                $('<tr>' +
                    '<td>' + name + '</td>' +
                    '<td>' + task + '</td>' +
                    '<td>' + status + '</td>' +
                    '<td style="display: none" class="task_id">' + id + '</td>' +
                    '<td class="delete">' +
                    '   <button class="delete-btn">' +
                    '       <i class="glyphicon glyphicon-trash"/>' +
                    '   </button>' +
                    '</td></tr>').appendTo('#tasks_list');
            });
        }
    });

    $('#delete-menu').click(function () {
        $('.delete').toggle();
    });

    $(document).on("click", ".delete-btn", function () {
        const ans = confirm("Are you sure you want to delete this record?");
        const $element = $(this);
        if(ans) {
            const id = $element.closest('tr').find("td:eq(3)").text();
            $.ajax({
                type: 'DELETE',
                url: '/tasks/' + id,
                contentType: 'application/json',
                success: function () {
                    $element.closest('tr').remove();
                }
            });
        }
    });
});
