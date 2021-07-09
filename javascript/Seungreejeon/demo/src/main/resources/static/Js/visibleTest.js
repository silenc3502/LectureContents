var visibility = document.querySelectorAll("#vueapp p");

var btn = document.querySelector("#btn");
btn.addEventListener("click", showList);

function showList () {
    for(var i = 0; i < visibility.length; i++){
        if(i % 2 == 0) {
            continue;
        }
        visibility[i].style.visibility = "visible";
    }
}

var btn_H = document.querySelector("#btn_H");
btn_H.addEventListener("click", hiddenList);

function hiddenList () {
    for(var i = 0; i < visibility.length; i++){
        visibility[i].style.visibility = "hidden";
    }
}
