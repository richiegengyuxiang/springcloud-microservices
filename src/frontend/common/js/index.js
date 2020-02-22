$(".top-nav").load("../components/topNav.html")
$(".datasets-container").load("../components/datasetsContainer.html")

console.log("test222")

$.ajax({
    type:"GET",
    url: "/api/repos/getAll/",
    dataType: 'json',
    success: function(data){

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

        var items = $(".repo-container .repo-item");
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