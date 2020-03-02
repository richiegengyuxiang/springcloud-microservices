$(document).ready(function () {
    $(".search-parent").submit(function (e) {
        e.preventDefault()
        let input = $(".search").val()
        window.location.href = `/search?q=${input}`
    })

    const jwt = localStorage.getItem("user")
    if (jwt != null) {

        $.ajax({
            type: "POST",
            contentType: 'text/plain',
            url: "/zuulserverApi/user/getUserInfoByJwt",
            data: jwt,
            success(res) {
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
            error(error) {
                console.log(error)
            }
        })

    } else {
        $("#top-nav-inner").append(
            `
            <a href="/signup/" class="auth signup">
                Sign Up
            </a>
            <a href="/login/" class="auth login">
                Log in
            </a>
            
            `
        )
    }

})