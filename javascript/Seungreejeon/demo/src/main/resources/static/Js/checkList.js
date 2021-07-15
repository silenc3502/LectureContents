var itmeList = [];

var addBtn = document.querySelector("#add");
addBtn.addEventListener("click", addList);

function addList () {
    var item = document.querySelector("#item").value;

    if(item != null) {
        //입력 데이터 추가
        itmeList.push(item);
        //id가 "item"인 요소 값을 지움
        document.querySelector("#item").value = "";
        //입력창에 포커싱 적용
        document.querySelector("#item").focus();
    }
    showList();

}

function showList() {
    //<ul> 태그로 리스팅 준비
    var list = "<ul>";

    // 요소마다 반복 시켜 리스팅하고 x 표시 눌러서 사라지게함
    for (var i = 0; i < itmeList.length; i++) {
        list += "<li>" + itmeList[i] + "<span class='close' id = " + i + ">X</span></li>";
        
    }
    //리스팅을 끝내는 </ul> 태그 셋팅

    list += "</ul>";

    document.querySelector("#itemList").innerHTML = list;

    // querySelector는 낱개로 가져오지만
    // querySelectorAll은 전부 가져온다.
    let remove = document.querySelectorAll(".close");

    for (var i = 0; i < remove.length; i++){
        remove[i].addEventListener("click", removeList);
    }
    alert("보여주기 동작중")


    function removeList () {
        alert("지우기 클리되는중")
        //모든 객체는 자기 자신인 this를 가지고 있어서
        //this(클릭한 삭제 버튼 X)의 id값을 가져와 id로 설정
        var id = this.getAttribute("id");

        itmeList.splice(id,1);
        //변경 정보를 다시 화면 출력함
        showList();
    }
}