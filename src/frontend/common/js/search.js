$(".top-nav").load("../components/topNav.html")
$(".posts-container").load("../components/datasetsContainer.html")

let searchParams = new URLSearchParams(window.location.search)
let question = searchParams.get('q')

$.ajax({
    type: "POST",
    url: "/zuulserverApi/search/",
    data: question,
    processData: false,
    contentType: false,
    dataType: 'json',
    success: function (data) {

        $(".result").html(`${data.length} Postsitory(s) Found`)

        loadPostItems(data)
    },
    error: function (error) {
        console.log(error);
    }
})