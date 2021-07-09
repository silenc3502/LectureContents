var userId = prompt("아이디: ");
var userPw = prompt("비밀번호: ");
var displayArea = document.querySelector('#result');

if (userPw != null) {
    if(userPw < 8 ) {
        alert("경고! 8자리 이상 입력하셔야 합니다!");
    } else {
        displayArea.innerHTML = userPW + "는 3의 배수가 아닙니다!";
    }
} else {
    alert("입력 취소!");
}