var evenBtn = document.querySelector('#evenBtn');
var oddBtn = document.querySelector('#oddBtn');
var list = document.querySelectorAll('#vueapp p');

evenBtn.addEventListener("click", showEven);
oddBtn.addEventListener("click", showOdd);

function showEven () {
  evenBtn.style.visibility = "hidden";
  oddBtn.style.visibility = "visible";
  for(var i = 1; i < list.length + 1; i++) {
    if(i % 2 == 0) {
      list[i - 1].style.visibility = "visible";
    } else {
      list[i - 1].style.visibility = "hidden";
    }
  }
}

function showOdd () {
  evenBtn.style.visibility = "visible";
  oddBtn.style.visibility = "hidden";
  for(var i = 1; i < list.length + 1; i++) {
    if(i % 2 == 1) {
      list[i - 1].style.visibility = "visible";
    } else {
      list[i - 1].style.visibility = "hidden";
    }
  }
}