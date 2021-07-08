var nameList = [];
var ageList = [];
var majorList = [];

var addBtn = document.querySelector("#add");
addBtn.addEventListener("click", addList);

function addList () {
  var name = document.querySelector("#name").value;
  var age = document.querySelector("#age").value;
  var major = document.querySelector("#major").value;

  if (name != null) {
      nameList.push(name);
      document.querySelector("#name").value = "";
      document.querySelector("#name").focus();
  }
  if (age != null) {
    ageList.push(age);
    document.querySelector("#age").value = "";
    document.querySelector("#age").focus();
    }
  if (major != null) {
    majorList.push(major);
    document.querySelector("#major").value = "";
    document.querySelector("#major").focus();
  }


  showList();
}

function showList () {
    var list = "<ul>";

    for (var i = 0; i < nameList.length; i++) {
        list += "<li>" +"name: "+ nameList[i] + " age: " + 
                ageList[i] + " major : " + majorList[i] + 
                "<span class='close' id=" + i + "> X </span></li>";
    }
    list += "</ul>";

    document.querySelector('#userList').innerHTML = list;

    var remove = document.querySelectorAll(".close");

    for (var i = 0; i < remove.length; i++) {
        remove[i].addEventListener("click", removeList);
    }
}


function removeList () {

    var id = this.getAttribute("id");

    nameList.splice(id, 1);
    ageList.splice(id, 1);
    majorList.splice(id, 1);

    showList();
}

/*
var itemList = [];

var addBtn = document.querySelector("#add");
addBtn.addEventListener("click", addList);

function addList () {
    var name = document.querySelector("#name").value;
    var age = document.querySelector("#age").value;
    var major = document.querySelector("#major").value;

    if (name != null) {
        var item = name + ", " + age + ", " + major;
        itemList.push(item);
        document.querySelector("#name").value = "";
        document.querySelector("#age").value = "";
        document.querySelector("#major").value = "";
    }

    showList();
}

function showList () {
    var list = "<ul>";

    for (var i = 0; i < itemList.length; i++) {
        list += "<li>" + itemList[i] + "<span class='close' id=" + i + "> X</span></li>";
    }
    list += "</ul>";

    document.querySelector('#userList').innerHTML = list;

    var remove = document.querySelectorAll(".close");

    for (var i = 0; i < remove.length; i++) {
        remove[i].addEventListener("click", removeList);
    }
}

function removeList () {
    var id = this.getAttribute("id");
    itemList.splice(id, 1);
    showList();
}
*/
//강사님 방식