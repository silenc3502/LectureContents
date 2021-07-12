var userNumber = prompt("Input Number: ");
var displayArea = document.querySelector('#result');
// 자바스크립트는 따옴표 구별 안함

if (userNumber != null){
    if(userNumber % 3 === 0){
        // ==: 서로 타입이 달라도 같은 타입으로 강제 변환하여 비교
        // ===: 타입까지 같아야 일치한다고 판정
        displayArea.innerHTML = userNumber + "는 3의 배수입니다.";
    }else {
        displayArea.innerHTML = userNumber + "는 3의 배수가 아닙니다.";
    }
}else {
    alert("입력취소");
    // alert: 창띄우기
}