var state = 1;

function showDetail(){
    var list = document.querySelectorAll("#vueapp p");
    
    // state 값이 1이면 짝수 번째, 0이면 홀수 번째
    // i=0이면 0, 2, 4
    // i=1이면 1, 3, 5
    for(var i = 0; i < list.length; i++){
        // 0이면 거짓, 0이 아니면 참
        if(!((i + state) % 2)){
            list[i].style.visibility = "visible";
        }else{
            list[i].style.visibility = "hidden";
        }
    }
    if (state == 1){
    state = 0;
    }else {
    state = 1;
    }
}

