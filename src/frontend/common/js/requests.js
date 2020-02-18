$.ajax({
    type:"GET",
    url: "/api/requests/",
    dataType: 'json',
    success: function(data){

        $(".result").html(`${data.length} Requests`)

        $.each(data, function (index, value) {
                $(".dataset-container").append(
                    `<div class="dataset-item">
                        <div class="dataset-heading"><a href="/source/${value.id}" target="_blank">${value.heading}</a></div>
                        <div class="dataset-description">${value.description}</div>
                    </div>`
                )
            }
        )
    },
    error: function (error) {
        console.log(error)
    }
})