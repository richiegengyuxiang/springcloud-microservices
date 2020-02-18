$(document).ready(function() {
    $(".search-parent").submit(function (e) {
        e.preventDefault()
        let input = $(".search").val()
        window.location.href = `/search?q=${input}`
    })
})