var state =1;


function toggleButton() {
    var list = document.querySelectorAll('#vueapp p');

    for(var i=0; i<list.length; i++)
    {
        if(!state)
        {
            list[i].style.value = "visible";
        }
    }
    alert(list);

}