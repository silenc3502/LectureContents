var userNumber = prompt("Input Number:");
var displayArea = document.querySelector('result'); //작은 따옴표나 큰 따옴표나 상관없다

if (userNumber != null) {
    if (userNumber % 3 === 0) {
    displayArea.innerHTML = userNumber + "는 3의 배수 입니다";
} else {
    displayArea.innerHTML = userNumber + "는 3의 배수가 아닙니다";
}

} else {
    alert("입력 취소!");
}

// ==의 경우 서로 타입이 달라도 같은 타입으로 강제 변화하여 비교
// === 타입까지 같아야 일치하는 것으로 인정
