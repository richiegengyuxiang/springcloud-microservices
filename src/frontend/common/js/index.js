$(".top-nav").load("../components/topNav.html")
$(".posts-container").load("../components/datasetsContainer.html")

$.ajax({
    type: "GET",
    url: "/zuulserverApi/posts/getAll",
    dataType: 'json',
    success (data) {

        $(".result").html(`${data.length} Postsitory(s) Found`)

        loadPostItems(data)

        const items = $(".post-container .post-item");
        const numItems = items.length;
        const perPage = 6;

        items.slice(perPage).hide();

        $('#pagination-container').pagination({
            items: numItems,
            itemsOnPage: perPage,
            prevText: "&laquo;",
            nextText: "&raquo;",
            onPageClick: function (pageNumber) {
                const showFrom = perPage * (pageNumber - 1);
                const showTo = showFrom + perPage;
                items.hide().slice(showFrom, showTo).show();
            }
        });
    },
    error (error) {
        console.log(error)
    }
})




