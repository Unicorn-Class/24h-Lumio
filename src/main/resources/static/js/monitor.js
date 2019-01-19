function activationBtn(el) {
    if (el.getAttribute("class").includes("darken-4")) {
        el.setAttribute("class", el.getAttribute("class")
                        .substring(0, el.getAttribute("class").length - 9));
    } else {
        el.setAttribute("class",el.getAttribute("class")+" darken-4");
    }
}