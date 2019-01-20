function sendData(data) {

    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/sendMood",
        "method": "POST",
        "headers": {
            "Content-Type": "application/functionsMusic",
            "cache-control": "no-cache",
            "Postman-Token": "6d776311-dd03-4050-80d1-fa4a8662cff8"
        },
        "processData": false,
        "data": data
    }

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}

function playPause() {
    sendData("playPause");
}


