// function 일종의 생성자 역할을 해줄 수 있는 함수(메소드)
function member (id) {
    this.id = id;
}

var idCheck = new member('id','dd');

var checkList = [idCheck];

document.write("<h1>현재 가입한 회원의 수는!</h1>")

for (var i = 0; i < checkList.length; i++) {
    document.write("<p>"  + checkList[i].id + "</p>");
}