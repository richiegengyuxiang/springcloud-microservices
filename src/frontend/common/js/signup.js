$(".top-nav").load("../components/topNav.html")

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function validatePassword(password) {
    var re = /^[0-9a-zA-Z]{8,}$/;
    return re.test(String(password));
}

$("#signup-form").submit(function (event) {
    event.preventDefault();
    // Get all inputs and store as values object.
    var values = {};
    $(".text-field").each(function () {
        values[this.name] = $(this).val();
    });

    // Reset form to original every time submit button is clicked.
    $(".text-field").css("border", "1px solid lightgray");
    $(".error").remove();

    // Check if text fields are empty
    $(".text-field").each(function () {
        if (values[this.name] == "") {
            $("#" + this.name + "-field").css("border", "2px solid red");
            if ($("#" + this.name + "-empty").length == 0) {
                $(
                    "<div class='error' id='" +
                    this.name +
                    "-empty'>" +
                    this.name.replace(/^\w/, c => c.toUpperCase()) +
                    " cannot be empty.</div>"
                ).insertAfter($("#" + this.name + "-field"));
            }
        }
    });

    // Check if email & password are valid.
    if (values["email"] != "" && !validateEmail(values["email"])) {
        $("#email-field").css("border", "2px solid red");
        $(
            "<div class='error' id='email-invalid'>Error: Email is invalid format.</div>"
        ).insertAfter($("#email-field"));
        return;
    }

    if (values["password"] != "" && !validatePassword(values["password"])) {
        $("#password-field").css("border", "2px solid red");
        $(
            "<div class='error' id='password-invalid'>Error: Password is invalid format.</div>"
        ).insertAfter($("#password-field"));
        return;
    }

    if (
        values["email"] != "" &&
        values["username"] != "" &&
        values["password"] != ""
    ) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/zuulserverApi/auth/signup",
            data: JSON.stringify(values),
            dataType: "text",
            success: function (res) {
                alert(res)
                if (res == "success") {
                    alert("success")
                } else if (res == "email already exists") {
                    $("#email-field").css("border", "2px solid red");
                    if ($("#email-exist").length == 0) {
                        $(
                            "<div class='error' id='email-exist'>Error: Email already exists.</div>"
                        ).insertAfter("#email-field");
                    }
                } else if (res == "username already exists") {
                    $("#username-field").css("border", "2px solid red");
                    if ($("#username-exist").length == 0) {
                        $(
                            "<div class='error' id='username-exist'>Error: Username already exists.</div>"
                        ).insertAfter("#username-field");
                    }
                }
            }
        });
    }
});
