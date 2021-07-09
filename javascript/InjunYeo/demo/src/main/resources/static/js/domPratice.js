/*
function toggleButton(){
    var listEven = document.querySelectorAll('#vueapp p:nth-child(even)');
      
    
    for(var i =0;i<listEven.length;i++){
        list[i].style.visibility = "visible";
    }  

}
*/

var state =1;

function toggleButton(){
    var list = document.querySelectorAll('#vueapp p');


    for(var i =0; i<list.length;i++){
        //0이면 거짓, 0이아니면 참
        if(!((i+state)%2)){
            list[i].style.visibility = "visible";
        } else{
            list[i].style.visibility="hidden";
        }
    }

    if(state == 1){
        state = 0;
    } else{
        state =1;
    }

}