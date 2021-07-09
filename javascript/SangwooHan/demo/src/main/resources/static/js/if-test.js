var userNumber = prompt("Input Number: ")
var displayArea = document.querySelector('#result');

if (userNumber != null){
    if(userNumber % 3 === 0){
        displayArea.innerHTML = userNumber + "는 3의배수입니다.";
    }else{
        displayArea.innerHTML =userNumber + "는 3의 배수가 아닙니다!";

    }

    

}else{
    alert('동작취소');
}

