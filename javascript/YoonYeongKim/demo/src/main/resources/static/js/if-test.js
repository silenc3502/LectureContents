var userNumber = prompt("Input Number: ");
var displayArea = document.querySelector('#result');
// 자바스크립트는 큰따옴표 작은따음표의 구분이 필요없다.

if (userNumber != null) {
    if (userNumber % 3 === 0) {
        displayArea.innerHTML = userNumber + "는 3의 배수입니다!";
    } else {
        displayArea.innerHTML = userNumber + '는 3의 배수가 아닙니다!';
    }
} else {
    alert("입력 취소!");
}

// == 의 경우 서로 타입이 달라도 같은 타입으로 강제 변환하여 비교함
// === 타입까지 같아야 일치하는 것으로 인정