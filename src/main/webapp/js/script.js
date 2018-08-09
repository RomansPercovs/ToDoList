$(document).ready(function () {
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