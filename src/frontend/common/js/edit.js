$(".top-nav").load("../components/topNav.html")
let pageURL = $(location).attr('href');
let id = pageURL.split("/").pop();

loadLeftSidebarNav()

$(".done-btn").click(function (e) {
    e.preventDefault()

    const editedContent = $(".editable").val()
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/zuulserverApi/documents/storeDocument",
        data: JSON.stringify({
            postId: id,
            content: editedContent
        }),
        success(res) {
            console.log(res)
        },
        error(err) {
            console.log(err)
        }
    })
})