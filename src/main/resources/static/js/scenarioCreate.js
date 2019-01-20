var json =[];

function addDiv (title, p, bg) {

    var tEl = document.createElement("h1");
    tEl.innerHTML = title;

    var pEl = document.createElement("p");
    pEl.innerHTML = p;

    var divEl = document.createElement("div");
    divEl.appendChild(tEl);
    divEl.appendChild(pEl);
    divEl.style.background = bg;

    document.getElementsByClassName("divContainer")[0].appendChild(divEl);
}

function loadDiv() {
    var div = new Object();

    var title = document.getElementsByClassName("browser-default")[0].value;
    div.title = title;

    var f = document.getElementsByClassName("browser-default")[1].value;
    div.function = f;
    var p = "Function : "+f;
    p += "<br>";
    var id = document.getElementById('idChoosed').value;
    div.id = id;
    p += "IdChoosed : "+id;
    p += "<br>";
    var d = document.getElementById("duration").value;
    div.duration = d;
    p += "Temps : "+d+" seconds";

    var bg = document.getElementById("color").value;
    div.color = bg;

    json.push(JSON.stringify(div));

    addDiv(title, p, bg);
}