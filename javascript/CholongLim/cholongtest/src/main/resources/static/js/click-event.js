function showDetail () {
    document.querySelector('#desc').style.display = "block";
    document.querySelector('#open').style.display = "none";
}

function hideDetail () {
    document.querySelector('#desc').style.display = "none";
    document.querySelector('#open').style.display = "block";    
}

// display에 block가 들어가면 눈에서 사라진다 (내용이 사라지는 것은 아님)
// 인터넷에서 물건 상세페이지 만들때 ▽의 기능이다.
// 누르면 밑으로 내용이 더 나오고, △누르면 다시 접힌다.