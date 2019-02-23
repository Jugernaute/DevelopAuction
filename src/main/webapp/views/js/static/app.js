charset='UTF-8';
var stompClient = null;
console.log("app.js");

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected){
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greeting").html("");
}



function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    console.log("connect");
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            console.log(greeting);
            showGreeting(JSON.parse(greeting.body).content);
        });
    })
}

function disconnect() {
    if (stompClient != null){
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    var valueFromInput = $("#name").val();
    var message = {'name' : valueFromInput};
    stompClient.send("/app/helloPoint", {}, JSON.stringify(message));
}

function showGreeting(message) {
    console.log(message);
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
    console.log("44444444");
}

$(function () {

    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function () { connect(); });
    $( "#disconnect" ).click(function () {
        disconnect();
    });
    $( "#send"  ).click(function () {
        sendName();
    });
});

