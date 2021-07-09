var nameList = [];
var ageList = [];
var majorList = [];


//id가 add인 녀석을 클릭 했을때 addList()가 동작함
var addBtn = document.querySelector("#add");
//addEventListener라는 개념이 새로나왔다.
addBtn.addEventListener("click",addList);

function addList(){
    //입력 데이터 가져오기
    var name = document.querySelector("#name").value;
    var age = document.querySelector("#age").value;
    var major = document.querySelector("#major").value;


    if(name != null && age != null && major != null){
        var user = name+","+age+","+major;
        //입력데이터 추가
        nameList.push(name);
        ageList.push(age);
        majorList.push(major);


        //id가 "item"인 요소 값을 지움
        document.querySelector("#name").value="";
        document.querySelector("#age").value="";
        document.querySelector("#major").value="";

        //입력창에 포커싱 적용
        document.querySelector("#name").focus();
        document.querySelector("#age").focus();
        document.querySelector("#major").focus();

    }

    showList()
}

function showList(){
    //<ul> 태그로 리스팅 준비
    var list = "<ul>";

    //요소마다 반복시켜 리스팅하고 x표시 눌러서 사라지게
    for (var i = 0; i < nameList.length; i++) {
        list += "<li>" + nameList[i] +ageList[i]+majorList[i]+ "<span class='close' id=" + i + "> X</span></li>";
    }


    /*
    for (var i = 0; i < itemList.length; i++) {
        list += "<li>" + itemList[i] + "<span class='close' id=" + i + "> X</span></li>";
    }
    */

    //리스팅을 끝내는 </ul>태그 셋팅
    list += "</ul>";

    document.querySelector('#userList').innerHTML = list;

    //쿼리셀렉터 올은 클래스의 아이디를 모두 가져올수있다.
    var remove = document.querySelectorAll('.close');
    //for 가들어가는이유?
    for(var i =0; i<remove.length;i++){
        remove[i].addEventListener("click",removeList);
    }
}

function removeList(){


    var id =this.getAttribute('id');


    nameList.splice(id,1);

    //변경정보를 다시 화면에 출력
    showList()
}