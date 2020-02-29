$(".top-nav").load("../components/topNav.html")
$(".datasets-container").load("../components/datasetsContainer.html")
// localStorage.clear()
$.ajax({
    type: "GET",
    url: "/zuulserverApi/posts/getAll",
    dataType: 'json',
    success: function (data) {

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

        var items = $(".post-container .post-item");
        var numItems = items.length;
        var perPage = 6;

        items.slice(perPage).hide();

        $('#pagination-container').pagination({
            items: numItems,
            itemsOnPage: perPage,
            prevText: "&laquo;",
            nextText: "&raquo;",
            onPageClick: function (pageNumber) {
                var showFrom = perPage * (pageNumber - 1);
                var showTo = showFrom + perPage;
                items.hide().slice(showFrom, showTo).show();
            }
        });
    },
    error: function (error) {
        console.log(error)
    }
})




