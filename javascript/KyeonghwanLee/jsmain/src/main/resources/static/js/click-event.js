function showDetail () {
    document.querySelector('#desc').style.display = "block";
    document.querySelector('#open').style.display = "none";
}

function hideDetail (){
    document.querySelector('#desc').style.display = "none";//none은 눈에서 사라짐
    document.querySelector('#open').style.display = "block";// block은 세로로 뿌려짐
}