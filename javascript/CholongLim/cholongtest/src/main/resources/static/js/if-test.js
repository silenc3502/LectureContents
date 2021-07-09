var userNumber = prompt("Input Number: ");
var displayArea = document.querySelector('#result');

if(userNumber != null) {
    if(userNumber % 3 ===0) {
        displayArea.innerHTML = userNumber + "는 3의 배수입니다."
    } else {
        displayArea.innerHTML = userNumber + "는 3의 배수가 아닙니다."
    }
} else {
    alert("입력 취소.")
}
// 자바스크립트는 큰따옴표와 작은따옴표 상관없이 사용이 가능하다.