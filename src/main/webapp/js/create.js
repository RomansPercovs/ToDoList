$('#submit').submit(function(){
    $.ajax({
        type:'POST',
        url:'/create',
        success: function(){
            window.location.href = '/';
        },
        error: function () {
            alert("There was a problem, try again");
            window.location.href = '/create'
        }
    });
});