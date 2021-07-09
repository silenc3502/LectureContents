    $(document).ready(function() {
        var formObj = $("#member");

        $("#btnRegister").on("click", function() {
            formObj.attr("action", "login");
            formObj.attr("method", "post");
            formObj.submit();
        });
    });