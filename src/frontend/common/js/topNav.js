$(document).ready(function () {
    $(".search-parent").submit(function (e) {
        e.preventDefault()
        let input = $(".search").val()
        window.location.href = `/search?q=${input}`
    })

    var jwt = localStorage.getItem("user")
    if (jwt != null) {

        $.ajax({
            type: "POST",
            contentType: 'text/plain',
            url: "/zuulserverApi/user/getUserInfoByJwt",
            data: jwt,
            success: function (res) {
                $("#top-nav-inner").append(
                    `
                    <a href="" class="auth user">
                        ${res.username}
                    </a>
                    `
                )

                $(".user").click(function (e) {
                    e.preventDefault()
                    window.location.href = `/user/${res.username}`
                })
            },
            error: function (error) {
                console.log(error)
            }
        })

    } else {
        $("#top-nav-inner").append(
            `
        <a href="/login/" class="auth login">
            Log in
        </a>
        <a href="/signup/" class="auth signup">
            Sign Up
        </a>
        `
        )
    }

})