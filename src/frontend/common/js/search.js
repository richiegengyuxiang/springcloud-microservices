$(".top-nav").load("../components/topNav.html")
$(".datasets-container").load("../components/datasetsContainer.html")

let searchParams = new URLSearchParams(window.location.search)
let question = searchParams.get('q')

$.ajax({
    type:"POST",
    url: "/api/search/",
    data: question,
    processData: false,
    contentType: false,
    dataType : 'json',
    success : function(data) {

        $(".result").html(`${data.length} Repository(s) Found`)

        $.each(data, function (index, value) {
                $(".repo-container").append(
                    `<div class="repo-item">
                        <div class="repo-heading">
                            <a href="/repo/${value.id}" target="_blank">${value.name}</a>
                        </div>
                        <div class="repo-description">${value.description}</div>
                    </div>`
                )
            }
        )
    },
    error: function(error){
        console.log(error);
    }
})