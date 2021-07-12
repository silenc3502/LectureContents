var state = 1;

function toggleButton () {
    var list = document.querySelectorAll("#vueapp p");

    for (var i = 0; i < list.length; i++) {
        //0이면 거짓, 0이 아니면 참
        if(!((i + state) % 2)) {
            list[i].style.visibility = "visible";
        }
        else {
            list[i].style.visibility = "hidden";
        }
    }
    if (state == 1) {
        state = 0;
    }
    else if(state == 0) {
        state = 1;
    }
}
