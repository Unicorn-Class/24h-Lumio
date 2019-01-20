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
    var div = document.getElementsByClassName("picker")[0];

    var title = div.getElementsByClassName("browser-default")[0].value;

    var p = "Function : "+div.getElementsByClassName("browser-default")[1].value;
    p += "<br>";
    p += "IdChoosed : ";
    p += "<br>";
    p += "Temps : ";


}