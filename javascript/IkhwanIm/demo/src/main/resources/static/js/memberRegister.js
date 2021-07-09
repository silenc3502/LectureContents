var password = document.querySelector('#password-input');

if(password != null){
    if(length(password) < "8"){
        alert("8글자 이상 입력해주세요");
    }else {
        displayArea.innerHTML = "적합";
    }
}