$(".top-nav").load("../components/topNav.html")
$(".datasets-container").load("../components/datasetsContainer.html")

let searchParams = new URLSearchParams(window.location.search)
let question = searchParams.get('q')

$.ajax({
    type:"POST",
    url: "/postserviceApi/search/",
    data: question,
    processData: false,
    contentType: false,
    dataType : 'json',
    success : function(data) {

        $(".result").html(`${data.length} Postsitory(s) Found`)

        $.each(data, function (index, value) {
                $(".post-container").append(
                    `<div class="post-item">
                        <div class="post-heading">
                            <a href="/post/${value.id}" target="_blank">${value.name}</a>
                        </div>
                        <div class="post-description">${value.description}</div>
                    </div>`
                )
            }
        )
    },
    error: function(error){
        console.log(error);
    }
})