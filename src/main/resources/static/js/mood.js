function sendData() {

    var json = "{ \"idLumio\"";
    json += document.getElementsByClassName("browser-default")[0].value;
    json += ", \"mood\"";
    json += document.getElementsByClassName("browser-default")[1].value;
    json += "}";

    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "http://localhost:8080/sendMood",
        "method": "POST",
        "headers": {
            "Content-Type": "application/json",
            "cache-control": "no-cache",
            "Postman-Token": "6d776311-dd03-4050-80d1-fa4a8662cff8"
        },
        "processData": false,
        "data": json
    }

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}


