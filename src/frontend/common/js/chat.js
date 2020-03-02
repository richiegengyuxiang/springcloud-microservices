$(".top-nav").load("../components/topNav.html")

function getUrlParamValue(variable) {
    const query = window.location.search.substring(1);
    const vars = query.split("&");
    for (const i = 0; i < vars.length; i++) {
        const pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return false;
}

// const userId = JSON.parse(localStorage.getItem("user")).id;
// const receiverId = getUrlParamValue("user");

const userId = "1"
const receiverId = "2"

function scrollToBottom(div) {
    $(div).scrollTop($(".message-container")[0].scrollHeight);
}


// $.ajax({
//     type: "POST",
//     url: "http://localhost:5000/fetchUserInfo",
//     data: {userId: receiverId},
//     dataType: "json",
//     success (res) {
//         $(".receiver").text(res[0].username);
//     },
//     error (result) {
//         console.log(result);
//     }
// });


const websocket = null;

conectWebSocket()

function conectWebSocket() {
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://172.17.0.1:8083/websocket");
        console.log("websocket")
    } else {
        alert('Not support websocket')
    }
    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("error");
    };
    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        setMessageInnerHTML("Loc MSG: 成功建立连接");
    }
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        displayReceivedMessage(event.data);
    }
    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("Loc MSG:关闭连接");
    }
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        websocket.close();
    }
}

//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    // document.getElementById('message').innerHTML += innerHTML + '<br/>';
    $(".message-container").append(
        "<div class='message-sent-container'>" +
        "<div class='message-sent'>" +
        innerHTML +
        "</div>" +
        "<img src='/images/user.svg' class='chat-profile-image'>" +
        "</div>"
    );
}

//关闭连接
function closeWebSocket() {
    websocket.close();
}

//发送消息
function send() {

    $(".message-container").append(
        "<div class='message-sent-container'>" +
        "<div class='message-sent'>" +
        $("textarea").val() +
        "</div>" +
        "<img src='/images/user.svg' class='chat-profile-image'>" +
        "</div>"
    );

    const message = $("textarea").val()
    websocket.send(message);
}

$("#send-btn").click(function () {
    const data = {
        senderId: userId,
        receiverId: receiverId,
        content: $("textarea").val()
    };

    send()

    // Reset input field
    $("textarea").val("");

    scrollToBottom(".message-container");
});

function displayReceivedMessage(data) {
    if (data.receiverId == userId) {
        $(".message-container").append(
            "<div class='message-received-container'>" +
            "<img src='/images/user.svg' class='chat-profile-image'>" +
            "<div class='message-received'>" +
            data.content +
            "</div>" +
            "</div>"
        );
    }

    scrollToBottom(".message-container");
}

// Load chat history
// $.ajax({
//     type: "POST",
//     url: "http://localhost:5000/fetchChatHistory",
//     data: JSON.stringify({
//         receiverId: receiverId,
//         senderId: userId
//     }),
//     dataType: "json",
//     contentType: "application/json",
//     success (res) {
//         $.each(res, function (index, value) {
//             if (value.receiverId == userId) {
//                 $(".message-container").append(
//                     "<div class='message-received-container'>" +
//                     "<img src='/images/user.svg' class='chat-profile-image'>" +
//                     "<div class='message-received'>" +
//                     value.content +
//                     "</div>" +
//                     "</div>"
//                 );
//             } else {
//                 $(".message-container").append(
//                     "<div class='message-sent-container'>" +
//                     "<div class='message-sent'>" +
//                     value.content +
//                     "</div>" +
//                     "<img src='/images/user.svg' class='chat-profile-image'>" +
//                     "</div>"
//                 );
//             }
//         });
//         scrollToBottom(".message-container");
//     },
//     error (result) {
//         console.log(result);
//     }
// });

