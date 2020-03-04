$(".top-nav").load("../components/topNav.html")

let pageURL = $(location).attr('href');
let id = pageURL.split("/").pop();

$.ajax({
    type: "POST",
    url: "/zuulserverApi/posts/getById",
    contentType: "text/plain",
    data: id,
    success(post) {
        let postInfo =
            `
            <div class="header info">
                <div class="title">${post.name}</div>
                <div class="description-container">
                    <div class="description">${post.description}</div>
                </div>
            </div>
            
            <div class="info">
                <div class="title">
                    <span>Dataset(s)</span><a href="/upload/${post.id}">Upload</a> 
                </div>
                <div class="dataset-item-container"></div>
            </div>
            
            <div class="data-display info">
                <div class="dataset-name title"></div>
            </div>
            `
        $("body").append(postInfo)

        getByPostId(post.id)
    },
    error(error) {

    }
})

function getByPostId(id) {
    $.ajax({
        type: "POST",
        url: "/zuulserverApi/datasets/getByPostId",
        contentType: "text/plain",
        data: id,
        success(datasets) {
            $.each(datasets, function (index, value) {

                let datasetInfo =
                    `
                    <div class="dataset-item">
                        <div class="name">${value.name}</div><button class="delete-btn">Delete</button><button class="download-btn">download</button>
                    </div>
                    `;

                $(".dataset-item-container").append(datasetInfo);

                // Click to display clicked dataset
                $(".dataset-item").click(function (e) {
                    e.stopImmediatePropagation();
                    $(".data-display").empty();

                    //Set clicked item as active
                    $(".active").attr("class", "dataset-item")
                    this.className += " active";

                    // Display data according to its type
                    displayData(value)
                })

                $(".download-btn").click(function (e) {
                    e.stopImmediatePropagation();

                    e.preventDefault();
                    window.location.href = "/zuulserverApi/datasets/fileDownload/" + value.id
                })

                $(".delete-btn").click(function (e) {
                    e.stopImmediatePropagation();
                    e.preventDefault();
                    $.ajax({
                        type: "POST",
                        url: "/zuulserverApi/datasets/deleteById",
                        contentType: "text/plain",
                        data: value.id,
                        success(res) {
                            if (res == "deleted") {
                                $(".dataset-item-container").empty()
                                getByPostId(id)
                            }
                        },
                        error(error) {
                            console.log(error)
                        }
                    })
                })
            })

            displayData(datasets[0]);
            $(".dataset-item:eq(0)").attr("class", "dataset-item active")

        },
        error(error) {
            console.log(error)
        }
    })
}

function displayData(value) {
    if (["csv", "txt"].includes(value.type)) {
        fetchCSVAsString(value);
    } else if (["wav", "mp3"].includes(value.type)) {
        $(".data-display").append(`
            <audio controls>
                <source src="/zuulserverApi/datasets/fileDownload/${value.id}">
            </audio>
        `)
    } else if (["jpg", "png", "jpeg"].includes(value.type)) {
        $(".data-display").append(`
            <img src="/zuulserverApi/datasets/fileDownload/${value.id}">
        `)
    } else if (["mp4"].includes(value.type)) {
        $(".data-display").append(`
            <video width="400" controls>
                <source src="/zuulserverApi/datasets/fileDownload/${value.id}" type="video/mp4">
            </video>
        `)
    }

    function fetchCSVAsString(data) {

        $.ajax({

            xhr: function () {
                const xhr = new window.XMLHttpRequest();
                //Upload progress
                xhr.upload.addEventListener("progress", function (evt) {
                    if (evt.lengthComputable) {
                        const percentComplete = evt.loaded / evt.total;
                        //Do something with upload progress
                    }
                }, false);
                //Download progress
                xhr.addEventListener("progress", function (evt) {
                    if (evt.lengthComputable) {
                        const percentComplete = evt.loaded / evt.total;
                        //Do something with download progress

                        $("#progressbar").progressbar({
                            value: percentComplete * 100
                        });
                        console.log(percentComplete);
                    }
                    console.log(evt.lengthComputable);
                }, false);
                return xhr;
            },

            type: "POST",
            url: "/zuulserverApi/datasets/fileDownload/" + data.id,
            data: data.id,
            processData: false,
            contentType: false,
            success(dataset) {

                let output;
                if (data.type.toLowerCase() == "csv") {
                    let lines = dataset.split("\n");
                    output = [];
                    let i;

                    const numRow = lines.length;
                    for (i = 0; i < numRow; i++)
                        output.push(
                            "<tr><td>"
                            + lines[i].slice(0, -1).split(",").join("</td><td>")
                            + "</td></tr>");

                    output =
                        `
                    <div class='table-container'>
                        <table>${output.join("")}</table>
                    </div>

                    `;

                    $(".dataset-name").text(data.name)
                    $(".data-display").append(output)
                    $(".data-display").append(
                        `<div id="pagination-container"></div>`
                    )

                    const items = $(".table-container table tr");
                    const numItems = items.length;
                    const perPage = 10;

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

                } else if (data.type.toLowerCase() == "txt") {
                    output =
                        `
                    <div class='text-container'>
                        ${dataset}
                    </div>
                    `

                    $(".dataset-name").text(data.name)
                    $(".data-display").append(output)
                }
            },
            error(error) {
                console.log("error", error)
            }
        })
    }
}