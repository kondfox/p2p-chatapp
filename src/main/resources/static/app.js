let stompClient = null;

function connect() {
    const socket = new SockJS('/chatapp-ws');
    socket.onmessage = (message) => console.log('WS message:', message)
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/messages/refresh', function (message) {
            console.log('message:', message)
//            showGreeting(JSON.parse(message.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

window.onload = connect