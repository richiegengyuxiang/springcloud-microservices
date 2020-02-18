$(".top-nav").load("../components/topNav.html")

$("#upload-form").on("submit", function(e){
    e.preventDefault();

    let formData = new FormData();
    formData.append("heading", $("#title").val())
    formData.append("description", $("textarea").val())

    $.ajax({
        type:"POST",
        url: "/api/requests/request",
        data: formData,
        processData: false,
        contentType: false,
        dataType : 'json',
        success : function(data) {
            console.log(data);
        },
        error: function(error){
            console.log(error);
        }
    })
})

