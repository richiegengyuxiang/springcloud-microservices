function loadPostItems(data) {
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
}

