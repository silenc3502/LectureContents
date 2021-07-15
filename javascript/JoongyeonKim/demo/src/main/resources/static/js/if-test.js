var userNumber = prompt("Input Number:");
var displayArea = document.querySelector('#result');

if (userNumber != null){
    if (userNumber % 3 ===0) {
        displayArea.innerHTML = userNumber + "는 3의 배수입니다!";
    } else {
        displayArea.innerHTML = userNumber + "는 3의 배수가 아닙니다!";
    }
} else{
    alert("입력 취소!");
    //alert
    //alert 함수는 앞선 예제에서 살펴본 바 있습니다. 이 함수가 실행되면 사용자가 ‘확인(OK)’ 버튼을 누를 때까지 메시지를 보여주는 창이 계속 떠있게 됩니다.
}

// == 의 경우 서로 타입이 달라고 같은 타입으로 강제 변환하여 비교함
// === 타입까지 같아야 일치하는 것으로 인정