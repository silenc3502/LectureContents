var itemList = [];
//id가 add인 녀석을 클릭 했을 때 addList() 가 동작함
var addBtn = document.querySelector("#add");
addBtn.addEventListener("click",addList);

function addList() {
    //입력 데이터 가져오기
    var item = document.querySelector("#item").value;

    if(item != null) {
        //입력 데이터 추가
        itemList.push(item);
        //id가 "item"인 요소 값을 지움
        document.querySelector("#item").value = "";
        //입력창에 포커싱 적용
        document.querySelector("#item").focus();
    }
    showList();
}
function showList() {
    //<ul>태그로 리스팅 준비
    var list = "<ul>";
    for(var i =0; i< itemList.length; i++){
        list += "<li>" + itemList[i] + "<span class= 'close' id=" + i + "> X</span></li>";

    }
    //리스팅을 끝내는 </ul>태그 세팅
    list += "</ul>";
    document.querySelector("#itemList").innerHTML = list;

    var remove = document.querySelectorAll(".close");
    //x표시 누르면 removeList가 동작하게
    for(var i =0; i < remove.length; i++){
        remove[i].addEventListener("click",removeList);
    }
}


function removeList() {
    //모든 객체는 자기 자신인 this를 가지고 있어서
    //this(클릭한 삭제 버튼x)의 id값을 가져와 id로 설정
    var id = this.getAttribute("id");
    //itemList 배열에서 인덱스 값이 id인 요소 1개를 삭제함, (2개면 2)
    itemList.splice(id,1);
    //변경정보를 다시 화면에 출력함
    showList();
}