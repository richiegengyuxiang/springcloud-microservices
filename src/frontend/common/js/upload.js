let pageURL = $(location).attr('href');
let repoId = pageURL.split("/").pop();


$("#upload-form").on("submit", function(e){
    e.preventDefault();

    let formData = new FormData();
    let file = $("#upload-file")[0].files[0];
    formData.append("file", file)
    formData.append("description", $("textarea").val())
    formData.append("repoId", repoId)

    $.ajax({

        xhr: function()
        {
            var xhr = new window.XMLHttpRequest();
            //Upload progress
            xhr.upload.addEventListener("progress", function(evt){
                if (evt.lengthComputable) {
                    var percentComplete = evt.loaded / evt.total;
                    //Do something with upload progress

                    $( "#progressbar" ).progressbar({
                        value: percentComplete * 100
                    });
                    console.log(percentComplete);
                }
            }, false);
            //Download progress
            xhr.addEventListener("progress", function(evt){
                if (evt.lengthComputable) {
                    var percentComplete = evt.loaded / evt.total;
                    //Do something with download progress
                    console.log(percentComplete);
                }
            }, false);
            return xhr;
        },

        type:"POST",
        url: "/api/datasets/upload",
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