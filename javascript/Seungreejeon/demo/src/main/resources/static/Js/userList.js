var userList = [];

var addBtn = document.querySelector("#add");
addBtn.addEventListener("click", addList);

function addList () {
    var name = document.querySelector("#name").value;
    var age = document.querySelector("#age").value;
    var major = document.querySelector("#major").value;

    if(name != null) {
        var item = name + "," + age + "," + major;
        userList.push(item);
        document.querySelector("#name").value = "";
        document.querySelector("#age").value = "";
        document.querySelector("#major").value = "";

    }
    showList();

}

function showList() {
    var list = "<ul>";

    for (var i = 0; i < userList.length; i++) {
        list += "<li>" + userList[i] + "<span class='close' id = " + i + ">X</span></li>";
        
    }

    list += "</ul>";

    document.querySelector("#userList").innerHTML = list;

    let remove = document.querySelectorAll(".close");

    for (var i = 0; i < remove.length; i++){
        remove[i].addEventListener("click", removeList);
    }
    alert("보여주기 동작중")


    function removeList () {
        alert("지우기 클리되는중")
        var id = this.getAttribute("id");

        userList.splice(id,1);
        showList();
    }
}