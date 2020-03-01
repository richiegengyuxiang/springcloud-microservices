$(".top-nav").load("../components/topNav.html")

$("#logout-btn").click(function () {
    localStorage.clear();
})