var itemList = [];

//id가 add인 녀석을 클릭 했을때 addList()가 동작함
var addBtn = document.querySelector("#add");
//addEventListener라는 개념이 새로나왔다.
addBtn.addEventListener("click",addList);

function addList(){
    //입력 데이터 가져오기
    var item = document.querySelector("#item").value;


    if(item != null){
        //입력데이터 추가
        itemList.push(item);

        //id가 "item"인 요소 값을 지움
        document.querySelector("#item").value="";

        //입력창에 포커싱 적용
        document.querySelector("#item").focus();

    }

    showList()
}

function showList(){
    //<ul> 태그로 리스팅 준비
    var list = "<ul>";

    //요소마다 반복시켜 리스팅하고 x표시 눌러서 사라지게
    for (var i = 0; i < itemList.length; i++) {
        list += "<li>" + itemList[i] + "<span class='close' id=" + i + "> X</span></li>";
    }


    /*
    for (var i = 0; i < itemList.length; i++) {
        list += "<li>" + itemList[i] + "<span class='close' id=" + i + "> X</span></li>";
    }
    */

    //리스팅을 끝내는 </ul>태그 셋팅
    list += "</ul>";

    document.querySelector('#itemList').innerHTML = list;

    //쿼리셀렉터 올은 클래스의 아이디를 모두 가져올수있다.
    var remove = document.querySelectorAll('.close');
    //for 가들어가는이유?
    for(var i =0; i<remove.length;i++){
        remove[i].addEventListener("click",removeList);
    }
}

function removeList(){

    //모든객체는 자기 자신인 this를 가지고 있어서 this(클릭한 삭제버튼 x)의 id 값을 가져와 id로 설정
    var id =this.getAttribute('id');

    //itemList배열에서 인덱스 값이 id인 요소1개를 삭제함
    //2개면 숫자가 2 가들어가며 3개면 3이 들어감
    itemList.splice(id,1);

    //변경정보를 다시 화면에 출력
    showList()
}